package perez.isai.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)
        val bundle = intent.extras
        if(bundle != null){
            iv_imagen_pelicula.setImageResource(bundle.getInt("header"))
            tv_TituloPelicula.setText(bundle.getString("nombre"))
            tv_DescPelicula.setText(bundle.getString("sinopsis"))

        }
    }
}