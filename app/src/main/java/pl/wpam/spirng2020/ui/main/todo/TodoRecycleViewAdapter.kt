package pl.wpam.spirng2020.ui.main.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.wpam.spirng2020.R

class TodoRecycleViewAdapter(var todos: List<String>) : RecyclerView.Adapter<TodoRecycleViewAdapter.ViewHolder>() {

    class ViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val title: TextView = itemView.findViewById<TextView>(R.id.todo_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val todoCardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_card, parent, false)
        return ViewHolder(todoCardView)
    }

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = todos[position]
    }

}