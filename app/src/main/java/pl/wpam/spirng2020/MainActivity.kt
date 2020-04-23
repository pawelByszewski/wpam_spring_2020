package pl.wpam.spirng2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.main_activity.*
import pl.wpam.spirng2020.room.AppDatabase
import pl.wpam.spirng2020.ui.main.DoneFragment
import pl.wpam.spirng2020.ui.main.TodoFragment

class MainActivity : AppCompatActivity() {

    companion object {
        var appDatabase: AppDatabase? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "wpam-db"
        )
            .allowMainThreadQueries()
            .build()

        tab_pager.adapter = DemoCollectionAdapter(this)

        TabLayoutMediator(
            tab_layout, tab_pager,
            TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                if (position == 0) {
                    tab.text = "Todo"
                } else {
                    tab.text = "Done"
                }
            }
        ).attach()
    }
}

internal class DemoCollectionAdapter(fragment: FragmentActivity?) :
    FragmentStateAdapter(fragment!!) {
    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            TodoFragment()
        } else {
            DoneFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
