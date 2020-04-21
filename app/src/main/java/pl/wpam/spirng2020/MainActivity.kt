package pl.wpam.spirng2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.main_activity.*
import pl.wpam.spirng2020.ui.main.TodoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
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
            TodoFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
