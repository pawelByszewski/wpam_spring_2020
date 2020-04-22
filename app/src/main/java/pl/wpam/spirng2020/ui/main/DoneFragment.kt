package pl.wpam.spirng2020.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.todo_fragment.*
import pl.wpam.spirng2020.R
import pl.wpam.spirng2020.ui.main.todo.DoneRecycleViewAdapter

class DoneFragment : Fragment() {

    companion object {
        fun newInstance() = DoneFragment()
    }

    private lateinit var viewModel: DoneViewModel
    private val todoRecycleViewAdapter: DoneRecycleViewAdapter = DoneRecycleViewAdapter(listOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.done_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DoneViewModel::class.java)
        viewModel.toDos.observe(this, Observer {
            todoRecycleViewAdapter.apply {
                todos = it
                notifyDataSetChanged()
            }
        })

        todo_recycle_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoRecycleViewAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
}
