package seamonster.kraken.androidep1

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import seamonster.kraken.androidep1.databinding.ActivityMainBinding
import seamonster.kraken.androidep1.databinding.DialogAddUserBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ListUserAdapter()
        binding.rvListUser.adapter = adapter
        binding.rvListUser.layoutManager = LinearLayoutManager(this)
        viewModel.userList.observeForever {
            adapter.data = it
            adapter.notifyDataSetChanged()
            Log.d(TAG, "observer: updated, ${it.size}")
        }

        binding.fabAddUser.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = DialogAddUserBinding.inflate(dialog.layoutInflater)
            dialogBinding.buttonCloseDialog.setOnClickListener {
                dialog.dismiss()
                adapter.notifyDataSetChanged()
            }
            dialogBinding.buttonAddUser.setOnClickListener {
                val userName = dialogBinding.textUserName.text.toString()
                val userAge = dialogBinding.textUserAge.text.toString().toInt()
                val userGender = dialogBinding.textUserGender.text.toString()
                viewModel.addUser(User(userName, userAge, userGender))
                Log.d(TAG, "buttonAddUser: clicked $userName $userAge $userGender")
            }
            dialog.setContentView(dialogBinding.root)
            dialog.show()
        }
    }
}