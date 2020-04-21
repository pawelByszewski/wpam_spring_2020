package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    private var toDosList  = mutableListOf<String>()

    private val _toDos = MutableLiveData<List<String>>().apply { value = toDosList }

    val toDos: LiveData<List<String>>
        get() = _toDos

    fun addToDo() {
        _toDos.value = toDosList.apply { add(UUID.randomUUID().toString()) }
    }
}
