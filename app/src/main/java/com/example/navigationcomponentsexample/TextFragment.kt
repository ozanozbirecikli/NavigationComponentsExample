package com.example.navigationcomponentsexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_text.view.*

class TextFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    lateinit var recipient: String
    lateinit var deleteName: String
    lateinit var surname: String
    lateinit var age: String
    lateinit var user: User

    lateinit var bundle:Bundle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            recipient = arguments?.getString("recipient").toString()
            surname = arguments?.getString("surname").toString()
            age = arguments?.getString("age").toString()

        if(!recipient.equals("None"))
            user = User(recipient, surname, age)

            deleteName = arguments?.getString("deleteUser").toString()


        Log.wtf("textsa", "recipient: " + recipient + " deleteName: " + deleteName)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.next_button).setOnClickListener(this)

        if (!recipient.equals("None")) {
            view.text_layout.visibility = View.VISIBLE
            view.delete_layout.visibility = View.GONE
            view.nameSurname.setText(recipient + " " + surname)
            view.age_text.setText(age)
        }else if(!deleteName.equals("None")){
            view.text_layout.visibility = View.GONE
            view.delete_layout.visibility = View.VISIBLE
            view.delete_name.setText(deleteName)

        }

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_button -> {
                if(!recipient.equals("None")){
                bundle = bundleOf("newuser" to user)}
                else{
                    bundle = bundleOf("deleteUser" to deleteName)
                }
                navController.navigate(R.id.action_textFragment_to_mainFragment, bundle)
            }
        }
    }
}
