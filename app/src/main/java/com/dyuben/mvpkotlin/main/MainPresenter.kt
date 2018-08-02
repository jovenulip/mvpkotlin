package com.dyuben.mvpkotlin.main

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {

    init {
        mainView.presenter = this
    }

    override fun changeText(s: String){
       mainView.updateText(s.toUpperCase())
    }
}