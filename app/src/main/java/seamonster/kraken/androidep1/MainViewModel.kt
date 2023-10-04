package seamonster.kraken.androidep1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _userList = ArrayList<User>()

    val userList = MutableLiveData(_userList)
    companion object {
        private const val TAG = "MainViewModel"
    }

    fun addUser(user: User) {
        userList.value = _userList.apply { add(user) }
        Log.d(TAG, "addUser: list length = ${userList.value?.size}")
    }
}