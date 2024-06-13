package mx.itson.edu.popcornfactory

import android.os.Bundle
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

        // Obtener los datos del Intent
        val titulo = intent.getStringExtra("titulo")
        val sinopsis = intent.getStringExtra("sinopsis")
        val header = intent.getIntExtra("header", 0)
        val image = intent.getIntExtra("image", 0)

        // Establecer los datos en las vistas correspondientes
        findViewById<ImageView>(R.id.image_movie_detail).setImageResource(image)
        findViewById<TextView>(R.id.title_movie_detail).text = titulo
        findViewById<TextView>(R.id.sinopsis_movie_detail).text = sinopsis
    }
}