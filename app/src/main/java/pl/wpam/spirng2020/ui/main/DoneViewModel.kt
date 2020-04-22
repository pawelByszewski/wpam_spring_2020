package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wpam.spirng2020.repository.Todo
import pl.wpam.spirng2020.repository.TodoRepository
import java.util.*

class DoneViewModel : ViewModel() {

    private val todoRepository: TodoRepository = TodoRepository

    private val _toDos = MutableLiveData<List<Todo>>()
    val toDos: LiveData<List<Todo>>
        get() = _toDos

    fun onResume() {
        refreshTodos()
    }

    private fun refreshTodos() {
        _toDos.value = todoRepository.fetchDone()
    }
}
