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
import kotlinx.android.synthetic.main.fragment_delete.*
import kotlinx.android.synthetic.main.fragment_text.*


class DeleteFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<TextView>(R.id.next_button).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_button -> {
                if (!TextUtils.isEmpty(name_text.text.toString())) {

                    val bundle = bundleOf("deleteUser" to name_text.text.toString())
                    navController!!.navigate(R.id.action_deleteFragment_to_textFragment2, bundle)



                } else {
                    Toast.makeText(activity, "You have to enter a Name", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}