package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        resultTextView = result_text_view

        val counterValue = intent.getIntExtra("TAP_AMOUNTS", 0)
        val indicatorValue = intent.getBooleanExtra("INDICATOR", false)
        val textValue = intent.getStringExtra("TEXT_FIELD")

        resultTextView.setText("Кнопку нажали: ${counterValue}\nНажили ли кнопку?: ${indicatorValue}\nТекст: ${textValue}")

    }
}
