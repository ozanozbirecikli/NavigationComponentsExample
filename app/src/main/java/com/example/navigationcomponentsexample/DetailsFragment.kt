package com.example.navigationcomponentsexample

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null
    var recipient:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")

        Log.wtf("recipient", recipient)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.save_button).setOnClickListener(this)
        view.findViewById<TextView>(R.id.cancel_button).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.save_button -> {
                if(!TextUtils.isEmpty(input_surname.text.toString()) && !TextUtils.isEmpty(input_age.text.toString())) {
                    val bundle = bundleOf("recipient" to  recipient,
                        "surname" to input_surname.text.toString(),
                        "age" to input_age.text.toString())
                    navController!!.navigate(R.id.action_detailsFragment_to_textFragment, bundle)
                }else{

                    Toast.makeText(activity, "You have to enter your Surname and Age",Toast.LENGTH_SHORT).show()
                }

            }
            R.id.cancel_button -> activity?.onBackPressed()
        }
    }

}
