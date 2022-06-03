package com.codeyuba.todoapp.screens

class MainPresenter : MainContract.Actions{

    var _views:MainContract.Views? = null

    constructor(_views:MainContract.Views?){
        this._views = _views
        initScreen()
    }

    override fun initScreen(){
        _views?.setupViews()
        _views?.setupListeners()
    }

    override fun addTaskToRecyclerView() {
        _views?.addTaskToRecyclerView(_views?.getTask()!!)
    }

    override fun addTaskToDatabase() {

    }

    override fun fetchAllDataFromDatabase() {

    }
}