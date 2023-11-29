package seamonster.kraken.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view, FragmentA())
        transaction.commit()
    }
}