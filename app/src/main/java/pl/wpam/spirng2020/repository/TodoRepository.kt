package pl.wpam.spirng2020.repository

object TodoRepository {

    private var toDosList  = mutableListOf<String>()

    fun add(todo: String) : List<String> = toDosList.apply { add(todo) }

    fun fetchAll(): List<String> = toDosList
}