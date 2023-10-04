package seamonster.kraken.androidep1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import seamonster.kraken.androidep1.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer1, FragmentA())
        transaction.replace(R.id.fragmentContainer2, FragmentB())
        transaction.commit()
    }
}