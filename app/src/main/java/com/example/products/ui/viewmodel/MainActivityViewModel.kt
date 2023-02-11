package com.example.products.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products.data.model.GeneralResponse
import com.example.products.data.model.UIState
import com.example.products.data.usecase.MainActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCase: MainActivityUseCase
) : ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    private var msfResponse = MutableStateFlow<UIState>(UIState.IsEmpty)
    var lsfResponse = msfResponse.asStateFlow()

    fun getProductService(type: String) {

        viewModelScope.launch {
            isLoading.postValue(true)
            val upComing = async {
                useCase.getProductUseCase(type)
            }
            msfResponse.value = resulUIState(upComing.await())
        }
        isLoading.postValue(false)
    }

    private fun <T> resulUIState(response: GeneralResponse<T>) =
        if (response.entity != null) {
            UIState.Success(response.entity)
        } else {
            UIState.Error(response.messageError)
        }

    fun clearUIState() = UIState.IsEmpty
}