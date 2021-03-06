package com.example.app.presentation.ui.github.views

import com.example.app.presentation.ui.github.model.GithubUser


interface GithubUserView {
    fun renderView(githubUser: GithubUser)
    fun showError(exception: Exception)
}