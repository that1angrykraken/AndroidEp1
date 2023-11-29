package seamonster.kraken.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view1, FragmentA())
        transaction.add(R.id.fragment_container_view2, FragmentB())
        transaction.commit()
    }
}