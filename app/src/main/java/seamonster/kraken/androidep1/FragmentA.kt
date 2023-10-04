package seamonster.kraken.androidep1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentA : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: ok")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ok")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ok")
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ok")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ok")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: ok")
    }

    companion object {
        const val TAG = "FragmentA"
    }
}