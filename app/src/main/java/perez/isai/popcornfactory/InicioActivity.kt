package perez.isai.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.grid_item.view.*

class InicioActivity : AppCompatActivity() {
    private var adapter: PeliculaAdapte? = null
    var moviesList = arrayListOf<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        moviesList = ArrayList<Pelicula>()
        cargaFilms()
        adapter = PeliculaAdapte(this,moviesList)
        gv_series.adapter = adapter

    }
    fun cargaFilms(){
        moviesList.add(Pelicula("1917", R.drawable.pmil,R.drawable.pmilheader,"British trenches somewhere in France. World war has been going on for the third year,heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy.",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Big Hero 6", R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called &quot;Big Hero 6.&quot;",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Leap Year", R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Men in Black", R.drawable.mib,R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York. He is searching for a super energy source called &quot;The Galaxy&quot;. Now, Agents J and K must stop the bug before it can escape with the galaxy.",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Toy Story", R.drawable.toystory,R.drawable.toystoryheader,"Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Inception", R.drawable.inception,R.drawable.inceptionheader,"Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.",arrayListOf<Cliente>()))
        moviesList.add(Pelicula("Harry Potter",R.drawable.harrypotter, R.drawable.harrypotterheader, "Late one night, Albus Dumbledore and Minerva McGonagall, professors at Hogwarts School of Witchcraft and Wizardry, along with the school's groundskeeper Rubeus Hagrid, deliver a recently orphaned infant named Harry Potter to his only remaining relatives, the Dursleys. Ten years later, Harry has lived a difficult life with the Dursleys. After inadvertently causing an accident during a family trip to London Zoo, Harry begins receiving unsolicited letters by owls. After he and the Dursleys escape to an island to avoid more letters, Hagrid re-appears and informs Harry that he is a wizard and has been accepted into Hogwarts against the Dursleys' wishes. After taking Harry to Diagon Alley to buy his supplies for Hogwarts and a pet owl named Hedwig as a birthday present, Hagrid informs him of his past: Harry's parents James and Lily Potter died due to a Killing Curse at the hands of the malevolent and all-powerful wizard: Lord Voldemort. Harry, the only survivor in the chaos, thus becomes well-known in the wizarding world as The Boy Who Lived.",arrayListOf<Cliente>()))
    }
    fun setSeatMovie(pos:Int,client:Cliente){
        cargaFilms()
        moviesList[pos].seats.add(client)
    }
}

class PeliculaAdapte: BaseAdapter {
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context?, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(p0: Int): Any {
        return peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var pelicula = peliculas[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.grid_item, null)
        println(pelicula.titulo)

        vista.title_film.text = pelicula.titulo
        vista.image_film.setImageResource(pelicula.image)

        vista.image_film.setOnClickListener{
            var seatsAvailable = 20 -pelicula.seats.size
            Log.d("SEATS","$seatsAvailable")
            var intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            intent.putExtra("numberSeats", (20 - pelicula.seats.size))
            intent.putExtra("pos", position)
            context!!.startActivity(intent)
        }
        return vista
    }


}


