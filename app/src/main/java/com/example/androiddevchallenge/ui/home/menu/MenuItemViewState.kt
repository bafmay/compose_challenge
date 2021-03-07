package com.example.androiddevchallenge.ui.home.menu

sealed class MenuItemViewState {
    class Success(val items: List<MenuItem>) : MenuItemViewState()
    class Failed(val message: String) : MenuItemViewState()
}