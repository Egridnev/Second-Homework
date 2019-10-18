package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.school.R


class MyFragment:Fragment() {
    lateinit var resultTextView:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my, container, false)
        resultTextView = view.findViewById(R.id.result_text_view)
        return view
    }

    fun setTextView(){

        val bundle = this.arguments
        if (bundle != null) {
            val counterValue = bundle.getInt("TAP_COUNTER", 0)
            val indicatorValue = bundle.getBoolean("INDICATOR", false)
            val textValue = bundle.getString("INPUT_TEXT")

            resultTextView.setText("Кнопку нажали: ${counterValue}\nНажили ли кнопку?: ${indicatorValue}\nТекст: ${textValue}")
        }
    }
}