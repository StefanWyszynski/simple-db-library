package com.simple.sqldatabase.db_android_app

import com.simple.sqldatabase.DBDAOTableBase
import com.simple.sqldatabase.annotations.DBColumn
import com.simple.sqldatabase.fields.DBFieldBoolean
import com.simple.sqldatabase.fields.DBFieldInteger
import com.simple.sqldatabase.fields.DBFieldString

/**
 * all fields have to be public
 */
class Table : DBDAOTableBase() {
    val TABLE_ITEM = "test_table"

    @DBColumn(primaryKey = true, autoIncrement = true)
    var id: DBFieldInteger? = null

    @DBColumn
    var text: DBFieldString? = null

    @DBColumn
    var checked: DBFieldBoolean? = null

    override fun getTableName(): String {
        return TABLE_ITEM
    }
}