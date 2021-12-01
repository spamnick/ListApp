package com.github.kolya.listapp.ui.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.kolya.listapp.models.UserDataUI
import com.github.kolya.listapp.models.mapper.toUserDataUI
import com.github.kolya.module.domain.GetUserListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListViewModel constructor(
    application: Application,
    private val getUserListUseCase: GetUserListUseCase
) : AndroidViewModel(application) {

    val listUiData = MutableLiveData<ListState>(ListState.Loading)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val userList = getUserListUseCase()
                .map { it.toUserDataUI() }
            withContext(Dispatchers.Main){
                listUiData.value = ListState.ListLoaded(userList)
            }
        }
    }

    sealed class ListState {
        object Loading : ListState()
        data class ListLoaded(val list: List<UserDataUI>) : ListState()
    }
}

