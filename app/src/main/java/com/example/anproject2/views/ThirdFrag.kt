package com.example.anproject2.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anproject2.databinding.FragmentThirdBinding
import com.example.anproject2.fragmentNavigation
import com.example.anproject2.model.Event
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [frag3.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.cvDate.setOnDateChangeListener { calendarView, i, i2, i3 ->
            Log.d("SECONDFRAG", calendarView.date.toString())
        }

        binding.btnDone.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFrag.newInstance()
            )
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment frag3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            ThirdFrag().apply {
                /*var dateFormat: SimpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
                val dateStrToCV: Long = dateFormat.parse(newEvent?.date.toLong())

                binding.tvTitle.setText(newEvent?.title)
                binding.tvCat.setText(newEvent?.category)
                binding.cvDate.setDate(newEvent?.date.toLong())*/
            }
    }
}