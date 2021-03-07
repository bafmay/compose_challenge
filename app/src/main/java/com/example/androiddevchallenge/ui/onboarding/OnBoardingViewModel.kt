package com.example.androiddevchallenge.ui.onboarding

import androidx.lifecycle.*
import com.example.androiddevchallenge.utils.PuppyDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val dataManager: PuppyDataManager
) : ViewModel() {

    private val _state = MutableLiveData<OnBoardingViewState>(OnBoardingViewState.Failed(""))
    val state: LiveData<OnBoardingViewState> = _state

    fun getOnBoardingItems() {
        viewModelScope.launch {
            val items = dataManager.onBoardingItems
            _state.value = OnBoardingViewState.Success(items)
        }
    }

}