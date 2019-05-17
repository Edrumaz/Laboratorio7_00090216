package com.example.labo7_pdm_00090216.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_pdm_00090216.database.daos.GithubRepoDAO
import com.example.labo7_pdm_00090216.database.entities.GithubRepo

class GithubRepository (private val repoDAO: GithubRepoDAO){

    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo:GithubRepo) = repoDAO.insert(repo)
}