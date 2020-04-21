package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import pl.wpam.spirng2020.R
import pl.wpam.spirng2020.ui.main.todo.TodoRecycleViewAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val todoRecycleViewAdapter: TodoRecycleViewAdapter = TodoRecycleViewAdapter(listOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.toDos.observe(this, Observer {
            todoRecycleViewAdapter.apply {
                todos = it
                notifyDataSetChanged()
            }
        })
        add_button.setOnClickListener { viewModel.addToDo() }

        todo_recycle_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoRecycleViewAdapter
        }
    }
}
