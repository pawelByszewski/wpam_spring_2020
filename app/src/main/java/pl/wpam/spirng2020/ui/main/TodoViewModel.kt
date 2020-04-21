package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wpam.spirng2020.repository.TodoRepository
import java.util.*

class TodoViewModel : ViewModel() {

    private val todoRepository: TodoRepository = TodoRepository

    private val _toDos by lazy {
        MutableLiveData<List<String>>().apply { value = todoRepository.fetchAll() }
    }
    val toDos: LiveData<List<String>>
        get() = _toDos

    fun addToDo() {
        _toDos.value = todoRepository.add(UUID.randomUUID().toString())
    }
}
