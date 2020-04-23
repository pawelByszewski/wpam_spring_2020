package pl.wpam.spirng2020.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.wpam.spirng2020.repository.Todo

@Entity
class TodoEntity {
    @PrimaryKey
    var id: String
    @ColumnInfo(name = "title")
    var title: String
    @ColumnInfo(name = "done")
    var done: Boolean


    constructor(todo: Todo) {
        id = todo.id
        title = todo.title
        done = todo.done
    }

    constructor(id: String, title: String, done: Boolean) {
        this.id = id
        this.title = title
        this.done = done
    }
}