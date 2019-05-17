package com.example.labo7_pdm_00090216.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_pdm_00090216.database.RoomDB
import com.example.labo7_pdm_00090216.database.entities.GithubRepo
import com.example.labo7_pdm_00090216.database.repositories.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {

    private val repository:GithubRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()
        repository = GithubRepository(repoDAO)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}