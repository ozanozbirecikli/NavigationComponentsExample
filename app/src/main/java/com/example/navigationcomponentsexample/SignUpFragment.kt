package com.example.navigationcomponentsexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.next_button).setOnClickListener(this)
        view.findViewById<TextView>(R.id.cancel_button).setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.next_button -> {
                if(!TextUtils.isEmpty(input_name.text.toString())) {
                    val bundle = bundleOf("recipient" to input_name.text.toString())
                    navController!!.navigate(R.id.action_signUpFragment_to_detailsFragment, bundle)
                }else{
                    Toast.makeText(activity, "You have to enter your Name", Toast.LENGTH_SHORT).show()

                }
            }

                R.id.cancel_button -> activity?.onBackPressed()
        }
    }

}
