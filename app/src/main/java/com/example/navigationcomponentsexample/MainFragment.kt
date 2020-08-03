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


class MainFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    lateinit var deleteUser: String

    companion object {
        var userList: ArrayList<User> = ArrayList<User>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (arguments != null) {
            val newUser = arguments?.getParcelable<User>("newuser")
            deleteUser = arguments?.getString("deleteUser").toString()
            if (newUser != null) {
                userList.add(newUser)
                arguments?.remove("newuser")
            }


            if (!deleteUser.equals("None")) {
                for (user in userList) {
                    if (user.name.equals(deleteUser)) {
                        userList.remove(user)
                        arguments?.remove("deleteUser")
                    }
                }
            }
        }

        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.viewButton).setOnClickListener(this)
        view.findViewById<TextView>(R.id.addButton).setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.addButton -> navController!!.navigate(R.id.action_mainFragment_to_signUpFragment)
            R.id.viewButton -> {
                val bundle = bundleOf("users" to userList.toTypedArray())
                navController!!.navigate(R.id.action_mainFragment_to_viewFragment, bundle)
            }
        }
    }
}
