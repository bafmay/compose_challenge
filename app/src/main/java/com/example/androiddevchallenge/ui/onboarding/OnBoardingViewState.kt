package com.example.androiddevchallenge.ui.onboarding

sealed class OnBoardingViewState {
    class Success(val items: List<OnBoardingItem>) : OnBoardingViewState()
    class Failed(message: String) : OnBoardingViewState()
}
