package com.example.klemavilanova.animation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class fragment_right : Fragment() {

    companion object {
        fun newInstance(): fragment_right {
            var right = fragment_right()
            var args = Bundle()
            right.arguments = args
            return right
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_right, container, false)
    }

}