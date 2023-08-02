package com.procex.procexapp.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.procex.procexapp.data.dataSource.local.dao.FormularioDao
import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity

@Database(
    entities = [FormularioEntity::class],
    version = 1,
    exportSchema = false

)
abstract class ProcexDB: RoomDatabase() {

    abstract fun formularioDao(): FormularioDao  // DATA ACCESS OBJECT

}