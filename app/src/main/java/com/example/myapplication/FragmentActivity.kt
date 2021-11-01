package com.example.myapplication
import FragmentTwo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class FragmentActivity : AppCompatActivity() {
    private lateinit var fragmentTransaction: FragmentTransaction
    var stackPosition = supportFragmentManager.backStackEntryCount + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        //Initialise Default Fragment
        initialFragment()

        //Add a new fragment on each button click
        var addButton = findViewById<Button>(R.id.AddFragment)
        addButton.setOnClickListener {
            fragmentPlus()
        }

        //Remove Fragment from top of back stack
        var removeButton = findViewById<Button>(R.id.RemoveFragment)
        removeButton.setOnClickListener {

            //Return to main activity if that's the last fragment in the stack.
            if (supportFragmentManager.backStackEntryCount == 1) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                //Remove Fragment at the top
                supportFragmentManager.popBackStack()
            }
        }
    }



    //Method to Add Fragment
    private fun fragmentPlus() {
        val fragment: Fragment

        //initialize stackPosition to backStackCount
        stackPosition = supportFragmentManager.backStackEntryCount + 1

        //Create a bundle to hold data to be passed between activity and fragments
        val bundle = Bundle()
        bundle.putInt("STACK_POSITION", stackPosition)

        //Create an Instance of each fragment class and then pass argument to fragment based on the individual stack position
        when(stackPosition) {
            1 -> {
                fragment = FragmentOne()
                fragment.arguments = bundle
            }
            2 -> {
                fragment = FragmentTwo()
                fragment.arguments = bundle
            }
            3 -> {
                fragment = FragmentThree.newInstance(
                    "Fragment Three:  Position $stackPosition"
                )
            }
            else -> {
                fragment = FragmentOne()
                fragment.arguments = bundle
            }
        }

        //Add fragment dynamically based on the backStack position
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }

    //Method to Add Initial Fragment
    private fun initialFragment() {
        stackPosition = supportFragmentManager.backStackEntryCount + 1
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, FragmentThree.newInstance(
                "Initial Fragment: Position $stackPosition"))
            addToBackStack(null)
            commit()
        }
    }



}