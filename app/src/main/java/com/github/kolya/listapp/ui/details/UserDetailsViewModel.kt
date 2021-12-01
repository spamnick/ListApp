package com.github.kolya.listapp.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.kolya.listapp.models.UserDataUI
import com.github.kolya.listapp.models.mapper.toUserDataUI
import com.github.kolya.module.domain.GetUserDataByUserNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailsViewModel constructor(
    application: Application,
    private val userDataUI: UserDataUI,
    private val getUserDataByUserNameUseCase: GetUserDataByUserNameUseCase
) : AndroidViewModel(application) {

    val uiData = MutableLiveData<UiState>(UiState.Loading)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserDataByUserNameUseCase(userDataUI.name).toUserDataUI()
            withContext(Dispatchers.Main){
                uiData.value = UiState.UserLoaded(user)
            }
        }
    }

    sealed class UiState{
        object Loading : UiState()
        data class UserLoaded(val userDataUI: UserDataUI) : UiState()
    }

}
