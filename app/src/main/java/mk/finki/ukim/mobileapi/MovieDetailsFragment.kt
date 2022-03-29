package mk.finki.ukim.mobileapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import mk.finki.ukim.mobileapi.databinding.FragmentSecondBinding


class MovieDetailsFragment : Fragment() {

    private lateinit var tvId:TextView
    private lateinit var tvTitle:TextView
    private lateinit var tvDescription:TextView
    private lateinit var tvDirector:TextView
    private lateinit var tvActors:TextView
    private val args: MovieDetailsFragmentArgs by navArgs()
    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvId = view.findViewById(R.id.tvId)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvDirector = view.findViewById(R.id.tvDirector)
        tvActors = view.findViewById(R.id.tvActors)

        tvId.text=args.id
        tvTitle.text=args.title
        tvDescription.text=args.description
        tvDirector.text=args.director
        tvActors.text=args.actors

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}