package mx.itson.edu.popcornfactory

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PurchaseDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_purchase_detail)

        val bundle = intent.extras

        val textDetail: TextView = findViewById(R.id.tdasd)

        if(bundle != null){
            val seatNumber = bundle.getString("numberSeat")
            textDetail.text = "El asiento comprado es el número $seatNumber"
        }

    }
}