package com.example.anproject2.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anproject2.databinding.FragmentThirdBinding
import com.example.anproject2.fragmentNavigation
import com.example.anproject2.model.Event
import java.text.SimpleDateFormat

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
        eventDetails?.let {
            val dateFormat = SimpleDateFormat("MM/dd/yyyy")
            val dateStrToCV = dateFormat.parse(it.date)

            binding.etTitle.setText(it.title)
            binding.etCat.setText(it.category)
            binding.cvDate.date = dateStrToCV.time

            /*dateStrToCV?.time?.let { detailTime ->

            }*/
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
        @JvmStatic
        fun newInstance(newEvent: Event) =
            ThirdFrag().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }
}