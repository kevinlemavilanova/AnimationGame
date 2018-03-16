package com.example.klemavilanova.animation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class fragment_left : Fragment() {

    companion object {
        fun newInstance(): fragment_left {
            var left = fragment_left()
            var args = Bundle()
            left.arguments = args
            return left
        }
        var cont = 0
        fun GiroIzq (){
            cont++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_left, container, false)
    }


}