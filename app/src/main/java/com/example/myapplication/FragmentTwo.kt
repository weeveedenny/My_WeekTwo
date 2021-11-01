import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_fragment_two, container, false)

        // Initialize the TextView

        val fragmentTwoTextView = view.findViewById<TextView>(R.id.FragmentTwo)

        //Get argument passed to fragment
        val stackPosition = this.arguments?.getInt("STACK_POSITION")

        //Set TextView Text
        fragmentTwoTextView.text = "Fragment-Two:  Position $stackPosition"
        return view
    }
}