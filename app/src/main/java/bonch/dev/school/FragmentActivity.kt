package bonch.dev.school

import android.icu.util.IndianCalendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import bonch.dev.school.fragments.MyFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var attachFragmentButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField:TextView

    val fragment = MyFragment()
    val fragmentManager = supportFragmentManager

    var indicator:Boolean = false
    var counter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initialize()
        setOnClickListeners()
        if(savedInstanceState != null){
            indicator = savedInstanceState.getBoolean("INDICATOR")
            counter = savedInstanceState.getInt("TAP_COUNTER")
            indicatorButton.isEnabled = false
            counterButton.text = "Количество нажатий = ${counter.toString()}"

        }

    }

    fun initialize(){
        indicatorButton = indicator_button
        attachFragmentButton = attach_fragment_button
        counterButton = counter_button
        textField = text_field
        fragmentManager.beginTransaction().replace(R.id.fragment_container_2, fragment).commit()

    }

    fun setOnClickListeners(){
        indicatorButton.setOnClickListener {
            if(!indicator){
                indicator = true
                indicatorButton.isEnabled = false
            }
        }

        counterButton.setOnClickListener {
            counter++
            counterButton.text = "Количество нажатий = ${counter.toString()}"
        }

        attachFragmentButton.setOnClickListener {

            var arguments:Bundle = Bundle()

            arguments.putBoolean("INDICATOR", indicator)
            arguments.putString("INPUT_TEXT", textField.text.toString())
            arguments.putInt("TAP_COUNTER", counter)

            fragment.arguments = arguments
            fragment.setTextView()


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_COUNTER", counter)
        outState.putBoolean("INDICATOR", indicator)
    }
}
