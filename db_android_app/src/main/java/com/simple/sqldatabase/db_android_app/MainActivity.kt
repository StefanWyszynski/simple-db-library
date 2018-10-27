package com.simple.sqldatabase.db_android_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.simple.sqldatabase.DBManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * delete button ommited by lazy author :)
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tables: List<Table>
    private lateinit var dbManager: DBManager
    private var listAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDatabase()
        setupListview()
        setupButtonsListeners()
    }

    private fun setupDatabase() {
        dbManager = DBManager(this, TEST_DATABASE_NAME, Table::class.java)
        tables = dbManager.getAllRows(Table::class.java)
    }

    private fun setupListview() {
        listAdapter = ListAdapter(applicationContext, R.layout.list_item, tables)

        list.adapter = listAdapter
        list.isClickable = true
    }

    private fun setupButtonsListeners() {
        btn_update.setOnClickListener(this)
        btn_add.setOnClickListener(this)
        btn_load.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_add -> onAddClick()
            R.id.btn_update -> onUpdateClick()
            R.id.btn_load -> onLoadClick()
        }
    }

    private fun onAddClick() {
        val testTable = dbManager.createNewDAOTable(Table::class.java)
        testTable?.text?.set(edittext.text.toString())
        testTable?.checked?.set(checkbox.isChecked)
        dbManager.add(testTable)
        // get last element to extract generated id
        var allRows = dbManager.getAllRows(Table::class.java)
        testTable.id = allRows?.get(allRows.size-1)?.id;
        listAdapter?.add(testTable)
        listAdapter?.notifyDataSetChanged()
    }

    private fun onUpdateClick() {
        if (listAdapter!!.count == 0) {
            return
        }
        val firstItem = listAdapter?.getItem(0)
        firstItem?.apply {
            text?.set(edittext.text.toString())
            checked?.set(checkbox.isChecked)
            dbManager.update(this, id)
        }

        tables = dbManager.getAllRows(Table::class.java)
        updateTestListAdapter()
    }

    private fun onLoadClick() {
        tables = dbManager.getAllRows(Table::class.java)
        updateTestListAdapter()
    }

    private fun updateTestListAdapter() {
        listAdapter?.apply {
            clear()
            addAll(tables)
            notifyDataSetChanged()
        }
    }

    companion object {
        val TEST_DATABASE_NAME = "testdatabase.db"
    }
}
