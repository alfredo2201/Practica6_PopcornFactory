package perez.isai.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)
        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title =""

        if(bundle != null){
            ns = bundle.getInt("numberSeats")
            iv_imagen_pelicula.setImageResource(bundle.getInt("header"))
            tv_TituloPelicula.text = bundle.getString("titulo")
            tv_DescPelicula.text = bundle.getString("sinopsis")
            seatsLeft.text = "$ns seats available"
            id = bundle.getInt("pos")
            title = bundle.getString("titulo")!!

        }

        if(ns == 0){
            buyTickets.isEnabled = false
        }else{
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("id",id)
                intent.putExtra("title",title)
                startActivity(intent)
            }
        }
    }
}