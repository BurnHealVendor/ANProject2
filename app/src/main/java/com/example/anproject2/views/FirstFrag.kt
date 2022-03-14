package com.example.anproject2.views

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anproject2.adapter.EventAdapter
import com.example.anproject2.adapter.OnItemClickListener
import com.example.anproject2.databinding.FragmentFirstBinding
import com.example.anproject2.fragmentNavigation
import com.example.anproject2.model.Event
import com.example.anproject2.model.EventSingleton

class FirstFrag : Fragment(), OnItemClickListener {
    private var event: Event? = null

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter(mListener = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getParcelable("event")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter
        }


        EventSingleton.myNewEvent?.let {
            eventAdapter.updateEventData(it)
        }

        binding.btnAdd.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFrag.newInstance()
            )
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFrag().apply {
                newEvent?.let {
                    eventAdapter.updateEventData(it)
                }
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }

    override fun onItemClicked(position: Int) {
        val clickedEvent = eventAdapter.getEventData(position)
        fragmentNavigation(
            supportFragmentManager = requireActivity().supportFragmentManager,
            ThirdFrag.newInstance(clickedEvent)
        )
    }
}