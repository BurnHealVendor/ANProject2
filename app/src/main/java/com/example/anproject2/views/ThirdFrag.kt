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

class ThirdFrag : Fragment() {

    private var eventDetails: Event? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            eventDetails = it.getParcelable("myEvent")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        eventDetails?.let {

            val dateFormat = SimpleDateFormat("MM/dd/yyyy")
            val dateStrToCV = dateFormat.parse(it.date)


            binding.tvTitle.text = it.title
            binding.tvCat.text = it.category
            binding.cvDate.date = dateStrToCV.time

//            dateStrToCV?.time?.let { detailTime ->
//
//            }
        }

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
        fun newInstance(newEvent: Event) =
            ThirdFrag().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }
}