package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""

        if(bundle != null){

            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            findViewById<ImageView>(R.id.image_movie_detail).setImageResource(bundle.getInt("image"))
            findViewById<TextView>(R.id.title_movie_detail).setText(bundle.getString("titulo"))
            findViewById<TextView>(R.id.sinopsis_movie_detail).setText(bundle.getString("sinopsis"))
            findViewById<TextView>(R.id.seatsLeft).setText("$ns seats available")
        }

        if(ns ==0){
            findViewById<Button>(R.id.buyTickets).isEnabled = false
        }else{
            findViewById<Button>(R.id.buyTickets).setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("movie", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }

    }
}