package seamonster.kraken.androidep1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import seamonster.kraken.androidep1.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {
    private lateinit var binding: Activity1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSwitchFragment.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, FragmentB())
            transaction.commit()
            it.visibility = View.GONE
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentA())
        transaction.commit()
    }
}