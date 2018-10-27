package com.simple.sqldatabase.db_android_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class ListAdapter(context: Context, textViewResourceId: Int, objects: List<Table?>) :
        ArrayAdapter<Table>(context, textViewResourceId, objects) {

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view: View? = convertView
        val user = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val id_text = view?.findViewById<TextView>(R.id.id_text_field)
        val userID = user?.id?.get()
        id_text?.setText("" + userID)

        val text = view?.findViewById<TextView>(R.id.text_field)
        val userText = user.text?.get()
        text?.setText(userText)

        val checkBox = view?.findViewById<CheckBox>(R.id.checkbox_field)
        val userIsChecked = user.checked?.get() ?: false
        checkBox?.setChecked(userIsChecked)

        return view
    }
}