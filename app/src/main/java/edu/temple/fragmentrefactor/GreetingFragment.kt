package edu.temple.fragmentrefactor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.temple.fragmentrefactor.databinding.FragmentGreetingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GreetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreetingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGreetingBinding.bind(view)
        val message = arguments?.getString(ARG_MESSAGE) ?: "Hello World"
        binding.displayTextView.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_MESSAGE: String = "message"

        /**
         * @param message Message.
         * @return A new instance of fragment GreetingFragment.
         */
        // TODO: Rename and change types and number of parameters
        //@JvmStatic
        fun newInstance(message: String) =
            GreetingFragment().apply {
                Log.d("new instant","initializing ${message}")
                arguments = Bundle().apply {
                    putString(ARG_MESSAGE, message)
                }
            }
    }
}