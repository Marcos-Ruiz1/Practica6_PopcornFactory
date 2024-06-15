package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

var radioButtonSelectedId:Int = -1;
class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)

        var posMovie = -1

        val bundle = intent.extras

        if(bundle != null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        val confirm: Button = findViewById(R.id.confirm)


        confirm.setOnClickListener {
            //Hacer logica para seleccionar el asiento de la pelicula
            //mostrar una nueva actividad con el resumen de la compra, que se vea el nombre del cliente y el
            // asiento que se seleccionó
            val selectedRadioButton: RadioButton = findViewById(radioButtonSelectedId)
            selectedRadioButton.setBackgroundResource(R.drawable.radio_disabled)
            Toast.makeText( this, "Enjoy the movie! :D ", Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, PurchaseDetail::class.java)
            intent.putExtra("numberSeat", selectedRadioButton.text.toString())
           // intent.putExtra("cliente", Cliente("marcos zazueta", "efectivo", selectedRadioButton.text.toString().toInt()))

            this.startActivity(intent)
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId != -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
                radioButtonSelectedId = row1.checkedRadioButtonId

            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId != -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
                radioButtonSelectedId = row2.checkedRadioButtonId

            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId != -1){
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
                radioButtonSelectedId = row3.checkedRadioButtonId

            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId != -1){
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)
                radioButtonSelectedId = row4.checkedRadioButtonId

            }
        }
    }
}