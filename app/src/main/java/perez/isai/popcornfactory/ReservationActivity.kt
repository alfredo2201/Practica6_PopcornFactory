package perez.isai.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val bundle = intent.extras
        val numberSeat: TextView = findViewById<TextView>(R.id.number_seat)
        var numSeat = -1
        var posMovie = -1
        var title = ""

        if(bundle != null){
            numSeat = bundle.getInt("numSeat")
            posMovie = bundle.getInt("posMovie")
            title = bundle.getString("title").toString()
            numberSeat.text = bundle.getInt("numSeat").toString()
        }
        val name: EditText= findViewById<EditText>(R.id.client_name)
        val cash: RadioButton = findViewById<RadioButton>(R.id.radio_cash)
        val card: RadioButton = findViewById<RadioButton>(R.id.radio_card)
        val button = findViewById<Button>(R.id.button_complete_purchase)
        var nameClient = ""
        var paymentMethod = ""


        button.setOnClickListener {
            nameClient = name.text.toString()
            var intent = Intent(this,InicioActivity::class.java)
            when {
                cash.isChecked -> {
                    paymentMethod = "cash"
                    saveReservation(nameClient,paymentMethod,numSeat,posMovie)
                    startActivity(intent)
                }
                card.isChecked -> {
                    paymentMethod = "card"
                    saveReservation(nameClient,paymentMethod,numSeat,posMovie)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(this,"Select a payment method.", Toast.LENGTH_LONG).show()
                }
            }
            numSeat = -1
            posMovie =-1
        }

    }
    private fun saveReservation(name:String, paymentMethod:String, seat:Int, posMovie:Int){
        var client = Cliente(name,paymentMethod,seat)
        InicioActivity().setSeatMovie(posMovie,client)
    }
}