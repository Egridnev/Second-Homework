package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.FragmentActivity
import bonch.dev.school.R

class FirstFragment : Fragment(){

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        button = view.findViewById(R.id.next_activity_button)
        setListener()
        return view
    }

    fun setListener(){
        button.setOnClickListener {
            (context as FragmentActivity).replaceFragment()
        }
    }

}