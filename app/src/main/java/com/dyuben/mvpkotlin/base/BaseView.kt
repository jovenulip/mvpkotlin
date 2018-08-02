package com.dyuben.mvpkotlin.base

interface BaseView<T> {
    var presenter: T
    fun showError()
}