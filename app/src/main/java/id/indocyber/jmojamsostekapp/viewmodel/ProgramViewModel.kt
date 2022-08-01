package id.indocyber.jmojamsostekapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.indocyber.api_service.usecase.ProgramUseCase
import kotlinx.coroutines.launch

class ProgramViewModel (application: Application, val programUseCase: ProgramUseCase) : AndroidViewModel(application) {

    val programData = MutableLiveData<List<String>>()
    val selectedProgram = arrayListOf<String>()

    init {
        getProgram()
    }

    fun getProgram(){
        viewModelScope.launch {
            programUseCase.invoke().collect{
                programData.postValue(it)
            }
        }
    }
}