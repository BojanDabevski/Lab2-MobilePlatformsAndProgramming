package mk.finki.ukim.mobileapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.finki.ukim.mobileapi.adapters.MovieAdapter
import mk.finki.ukim.mobileapi.api.MobileApi
import mk.finki.ukim.mobileapi.api.MobileApiClient
import mk.finki.ukim.mobileapi.databinding.FragmentFirstBinding
import mk.finki.ukim.mobileapi.models.Data
import mk.finki.ukim.mobileapi.models.v3
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieListFragment : Fragment() {
    private lateinit var mobileApiClient : MobileApi
    private lateinit var tvMovieListTitle: TextView
    private lateinit var mobileRecyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mobileApiClient = MobileApiClient.getMobileApi()!!
        val moviesLinkId: EditText = view.findViewById<EditText>(R.id.etMovieId)
        tvMovieListTitle = view.findViewById(R.id.tvMovieListTitle)

        mobileRecyclerView = view.findViewById(R.id.allMoviesRecyclerView)

        mobileRecyclerView.layoutManager = LinearLayoutManager(activity)

        recyclerViewAdapter = MovieAdapter( mutableListOf<Data>())
        mobileRecyclerView.adapter=recyclerViewAdapter
        moviesLinkId.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                val listId:String = moviesLinkId.text.toString()
                searchMovieById(listId)
                true
            }
            else{
                Toast.makeText(activity,"Error!",Toast.LENGTH_LONG).show()
                false
            }
        }

    }
    private fun searchMovieById(id:String){
        mobileApiClient.getMoviesById(id).enqueue(object : Callback<v3> {
            override fun onResponse(call: Call<v3>?, response: Response<v3>) {
                displayData(response.body())
                Toast.makeText(activity,"Success!", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<v3>?, t: Throwable) {
                var m=t.message
                Toast.makeText(activity,t.message, Toast.LENGTH_LONG).show()

            }
        })

    }
    private fun displayData(data: v3){
        tvMovieListTitle.text = data.title
        recyclerViewAdapter.updateData(data.movies.data)


    }


}