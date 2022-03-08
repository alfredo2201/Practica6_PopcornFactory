package perez.isai.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val titulo: TextView = findViewById<TextView>(R.id.titleSeats)
        var title =""
        var posMovie = -1
        var numSeat = -1
        val bundle = intent.extras


        if(bundle != null){
            title = bundle.getString("title").toString()
            posMovie = bundle.getInt("id")
            titulo.text = title
        }

        val confirm:Button = findViewById<Button>(R.id.btnConfirm)

        confirm.setOnClickListener {
            if(numSeat > 0){
                var intent = Intent(this, ReservationActivity::class.java)
                intent.putExtra("numSeat",numSeat)
                intent.putExtra("title",title)
                intent.putExtra("id",posMovie)
                numSeat = -1
                posMovie = -1
                startActivity(intent)
            }else{
                Toast.makeText(this,"Select a seat", Toast.LENGTH_LONG).show()
            }
        }
        val row1:RadioGroup = findViewById(R.id.row1)
        val row2:RadioGroup = findViewById(R.id.row2)
        val row3:RadioGroup = findViewById(R.id.row3)
        val row4:RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                numSeat = checkedId
            }
        }
        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
                numSeat = checkedId
            }
        }
        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
                numSeat = checkedId
            }
        }
        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                row4.check(checkedId)
                numSeat = checkedId
            }
        }

    }
}