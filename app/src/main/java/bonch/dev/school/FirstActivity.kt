package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var counter:Counter
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText
    private lateinit var indicator: Indicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initializeView()
        if(savedInstanceState == null){
            indicator = Indicator()
        }else{
            indicator = Indicator(savedInstanceState.getBoolean("INDICATOR"))
            indicatorButton.isEnabled = false
        }
        counter = if(savedInstanceState == null){
            Counter()
        }else{
            Counter(savedInstanceState.getInt("TAP_AMOUNTS"))

        }
        counterButton.text = "${counter.currentCount}"
        setListener()
    }

    private fun initializeView(){
        counterButton = counter_button
        indicatorButton = indicator_button
        nextActivityButton = next_activity_button
        textField = text_field



    }

    private fun setListener(){
        counterButton.setOnClickListener {
            counter.increment()
            counterButton.text = "${counter.currentCount}"

        }

        indicatorButton.setOnClickListener {
            indicator.changeState()
            indicatorButton.isEnabled = false
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(this@FirstActivity, SecondActivity::class.java)
            intent.putExtra("TAP_AMOUNTS", counter.currentCount)
            intent.putExtra("INDICATOR", indicator.pressed)
            intent.putExtra("TEXT_FIELD", textField.text.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCount)
        outState.putBoolean("INDICATOR", indicator.pressed)


    }
}
