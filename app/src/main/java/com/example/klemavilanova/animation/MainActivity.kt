package com.example.klemavilanova.animation

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_left.*
import kotlinx.android.synthetic.main.fragment_right.*
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI

class MainActivity : AppCompatActivity() {

    private val ui: CoroutineContext = UI

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.left, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }
    private fun addFragment2(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.right, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var left = com.example.klemavilanova.animation.fragment_left.Companion
        var right = com.example.klemavilanova.animation.fragment_right.Companion
        addFragment(left.newInstance())
        addFragment2(right.newInstance())

        var AnimLeft = ObjectAnimator.ofFloat(imgLeft,"rotation",90f)
        var AnimRight = ObjectAnimator.ofFloat(imgRight,"rotation",90f)


        giros.setText("0")

        pulse.setOnClickListener(){
            launch(ui) {
                left.GiroIzq()
                AnimLeft = ObjectAnimator.ofFloat(imgLeft,"rotation",AnimLeft.animatedValue as Float+180)
                AnimLeft.setDuration(700)
                AnimLeft.start()

                AnimRight = ObjectAnimator.ofFloat(imgRight,"rotation",AnimRight.animatedValue as Float+90)
                AnimRight.setDuration(700)
                AnimRight.start()

                giros.setText((left.cont + right.cont).toString())
            }
        }

        pulse2.setOnClickListener() {
            launch(ui) {
                right.GiroRgh()
                AnimRight = ObjectAnimator.ofFloat(imgRight,"rotation",AnimRight.animatedValue as Float+180)
                AnimRight.setDuration(700)
                AnimRight.start()

                AnimLeft = ObjectAnimator.ofFloat(imgLeft,"rotation",AnimLeft.animatedValue as Float+90)
                AnimLeft.setDuration(700)
                AnimLeft.start()

                giros.setText((left.cont + right.cont).toString())

            }
        }

    }



}
