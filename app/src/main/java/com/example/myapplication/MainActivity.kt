import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDiv: Button
    private lateinit var edit1: EditText
    private lateinit var edit2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMulti = findViewById(R.id.btnMulti)
        btnDiv = findViewById(R.id.btnDiv)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)

        btnAdd.setOnClickListener {
            val no1 = edit1.text.toString().toIntOrNull()
            val no2 = edit2.text.toString().toIntOrNull()

            if (no1 != null && no2 != null) {
                val sum = no1 + no2
                Toast.makeText(this, "The Addition is $sum", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill the required blanks.", Toast.LENGTH_LONG).show()
            }
        }

        btnSub.setOnClickListener {
            val no1 = edit1.text.toString().toIntOrNull()
            val no2 = edit2.text.toString().toIntOrNull()

            if (no1 != null && no2 != null) {
                val sub = if (no1 > no2) no1 - no2 else no2 - no1
                Toast.makeText(this, "The Subtraction is $sub", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill the required blanks.", Toast.LENGTH_LONG).show()
            }
        }

        btnMulti.setOnClickListener {
            val no1 = edit1.text.toString().toIntOrNull()
            val no2 = edit2.text.toString().toIntOrNull()

            if (no1 != null && no2 != null) {
                val multi = no1 * no2
                Toast.makeText(this, "The Multiplication is $multi", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill the required blanks.", Toast.LENGTH_LONG).show()
            }
        }

        btnDiv.setOnClickListener {
            val no1 = edit1.text.toString().toIntOrNull()
            val no2 = edit2.text.toString().toIntOrNull()

            if (no1 != null && no2 != null) {
                if (no2 == 0) {
                    Toast.makeText(this, "A number cannot be divided by zero.", Toast.LENGTH_LONG).show()
                } else {
                    val div = no1 / no2
                    Toast.makeText(this, "The Division is $div", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please fill the required blanks.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
