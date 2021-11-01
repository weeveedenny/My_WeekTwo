package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters
const val STACK_POSITION = "param1"


// Create a Fragment subclass.

class FragmentThree : Fragment() {
    private var stackPosition: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stackPosition = it.getString(STACK_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_fragment_three, container, false)

        //Initialize TextView
        val FragmentThreeTextView = view.findViewById<TextView>(R.id.FragmentBlank)

        //Set TextView Text
        FragmentThreeTextView.text = stackPosition
        return view
    }

    companion object {

        // New instance of this fragment
        @JvmStatic
        fun newInstance(stackPosition: String) =
            FragmentThree().apply {
                arguments = Bundle().apply {
                    putString(STACK_POSITION, stackPosition)
                }
            }
    }


}
