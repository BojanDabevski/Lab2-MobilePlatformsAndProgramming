package mk.finki.ukim.mobileapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import mk.finki.ukim.mobileapi.MovieDetailsFragmentDirections
import mk.finki.ukim.mobileapi.MovieListFragmentDirections
import mk.finki.ukim.mobileapi.R
import mk.finki.ukim.mobileapi.models.Data

class MovieAdapter(var allMovies:MutableList<Data>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

   /* interface CellClickListener {
        fun onCellClickListener(data: Data)
    }*/
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val movieId: TextView
        val movieTitle: TextView
        val movieDirector: TextView


        init {
            movieId = view.findViewById(R.id.movieId)
            movieTitle= view.findViewById(R.id.movieTitle)
            movieDirector= view.findViewById(R.id.movieDirector)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = allMovies[position]

        holder.movieId.text = currentMovie.id.toString()
        holder.movieTitle.text = currentMovie.title
        holder.movieDirector.text = currentMovie.director
        holder.itemView.setOnClickListener{ view ->
            val id = currentMovie.id.toString()
            val title = currentMovie.title
            val description = currentMovie.description
            val director = currentMovie.director
            val actors= currentMovie.actors

            val action = MovieListFragmentDirections.actionFirstFragmentToSecondFragment(id,title,description,director,actors)
            view.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return allMovies.size

    }
    fun updateData(data:MutableList<Data>){
        this.allMovies= data
        this.notifyDataSetChanged()

    }

}