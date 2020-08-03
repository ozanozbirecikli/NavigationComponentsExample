package com.example.navigationcomponentsexample

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_view.*

class ViewFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    //    lateinit var userList:ArrayList<User>
    var users: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//            var userList = arguments?.getParcelableArrayList<User>("users")
        var userList = arguments?.getParcelableArray("users")

        if (userList?.size!! > 0) {
            val us: User = userList[0] as User

            users = ""
            for (x in 0..userList.size - 1) {
                val usr = userList[x] as User
                users += usr.name + " - " + usr.lastname + " - " + usr.age + "\n"
            }
        } else if (userList?.size!! == 0) {
            users = "There is No User Added"

        } else {
            Log.wtf("users", "no data")

        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        users_text.setText(users)

        view.findViewById<TextView>(R.id.deleteButton).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.deleteButton -> {
                var userList = arguments?.getParcelableArray("users")
                if (userList?.size!! > 0) {
                    navController!!.navigate(R.id.action_viewFragment_to_deleteFragment)
                } else {
                    Toast.makeText(activity, "There is No User to Delete", Toast.LENGTH_SHORT)
                        .show()

                }
            }

        }
    }
}
