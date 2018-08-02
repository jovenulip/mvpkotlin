package com.dyuben.mvpkotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dyuben.mvpkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        button.setOnClickListener {
            presenter.changeText(text1.text.toString())

        }
    }

    override fun updateText(s: String) {
        text1.text = s
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


