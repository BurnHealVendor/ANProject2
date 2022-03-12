package com.example.anproject2.views

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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [frag1.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFrag : Fragment(), OnItemClickListener {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment

        binding.recView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter


        }

        EventSingleton.myNewEvent?.let {
            eventAdapter.updateEventData(it)
        }

        binding.btnAdd.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFrag.newInstance("", "")
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
         * @return A new instance of fragment frag1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFrag().apply {
                if (newEvent != null) {
                val title: String = newEvent.title
                val cat: String = newEvent.category
                val date: String = newEvent.date

                eventAdapter.updateEventData(Event(title, cat, date))
            }
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }

    override fun onItemClicked(position: Int) {
        var clickedEvent = eventAdapter.getEventData(position)
        fragmentNavigation(
            supportFragmentManager = requireActivity().supportFragmentManager,
            ThirdFrag.newInstance(clickedEvent)
        )
    }
}