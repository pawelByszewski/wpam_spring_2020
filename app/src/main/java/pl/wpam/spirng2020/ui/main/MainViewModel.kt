package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var counterValue = 0

    private val _counter = MutableLiveData<Int>().apply { value = counterValue }
    val counter: LiveData<Int>
        get() = _counter

    fun increase() {
        _counter.value = ++counterValue
    }
}
