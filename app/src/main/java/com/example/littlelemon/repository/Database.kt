package com.example.littlelemon.repository

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity
data class MenuItemEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
)

@Dao
interface MenuItemDAO {
    @Query(value = "SELECT * FROM MenuItemEntity")
    fun getAll(): List<MenuItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg menuItems: MenuItemEntity)
}

@Database(entities = [MenuItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDAO(): MenuItemDAO
}

object Database {
    fun build(context: Context): AppDatabase {
        val db =
            Room.databaseBuilder(context, AppDatabase::class.java, "little-database").build()
        return db
    }
}