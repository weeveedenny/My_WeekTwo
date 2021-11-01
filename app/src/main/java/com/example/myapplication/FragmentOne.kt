package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_fragment_one, container, false)

        //Initialize my TextView
        val Fragment1TextView = view.findViewById<TextView>(R.id.FragmentOne)

        //Get argument passed to the fragment
        val stackPosition = this.arguments?.getInt("STACK_POSITION")

        //Set TextView Text
        Fragment1TextView.text = "Fragment-One:  Position $stackPosition"
        return view
    }
}