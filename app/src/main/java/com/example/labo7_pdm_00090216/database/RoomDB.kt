package com.example.labo7_pdm_00090216.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labo7_pdm_00090216.database.daos.GithubRepoDAO
import com.example.labo7_pdm_00090216.database.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB:RoomDatabase() {

    abstract fun repoDAO():GithubRepoDAO

    companion object {

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context):RoomDB{
            val temInstance = INSTANCE
            if (temInstance != null){
                return temInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context, RoomDB::class.java, "Repo_DB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}