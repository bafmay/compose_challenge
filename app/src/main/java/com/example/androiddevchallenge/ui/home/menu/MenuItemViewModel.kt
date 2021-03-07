package com.example.androiddevchallenge.ui.home.menu

import androidx.lifecycle.*
import com.example.androiddevchallenge.utils.PuppyDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel @Inject constructor(
    private val dataManager: PuppyDataManager
) : ViewModel() {

    private val _state = MutableLiveData<MenuItemViewState>()
    val state: LiveData<MenuItemViewState> get() = _state

    fun getMenuItems() {
        viewModelScope.launch {
            val items = dataManager.menuItems
            _state.value = MenuItemViewState.Success(items)
        }
    }

}
