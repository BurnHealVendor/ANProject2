package com.example.anproject2.views

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anproject2.databinding.FragmentFirstBinding
import com.example.anproject2.databinding.FragmentSecondBinding
import com.example.anproject2.fragmentNavigation
import com.example.anproject2.model.Event
import com.example.anproject2.model.EventSingleton
import java.text.SimpleDateFormat
import java.util.*

class SecondFrag : Fragment() {

    private var selectedDate: String? = null

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.cvDate.setOnDateChangeListener { calendarView, year, month, day ->
            Log.d("SECONDFRAG", "$month / $day / $year")

            val realMonth = month + 1
            selectedDate = if (realMonth < 10) {
                "0$realMonth/$day/$year"
            } else {
                "$realMonth/$day/$year"
            }
        }

        binding.btnDone.setOnClickListener {
            val event = Event(binding.etTitle.text.toString(), binding.etCat.text.toString(), selectedDate.toString())

            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFrag.newInstance(event)
            )
        }

        return binding.root
    }

    companion object {
        fun newInstance() = SecondFrag()
    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("MM/dd/yyyy")
        return format.format(date)
    }
}