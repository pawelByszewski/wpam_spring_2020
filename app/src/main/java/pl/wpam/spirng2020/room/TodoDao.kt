package pl.wpam.spirng2020.room

import androidx.room.*

@Dao
interface TodoDao {
    @get:Query("SELECT * FROM TodoEntity")
    val all: List<TodoEntity?>?

    @Query("SELECT * FROM TodoEntity WHERE done = :isDone")
    fun find(isDone: Boolean?): List<TodoEntity?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todoEntities: TodoEntity?)

    @Update
    fun updateTodos(vararg todoEntity: TodoEntity)
}