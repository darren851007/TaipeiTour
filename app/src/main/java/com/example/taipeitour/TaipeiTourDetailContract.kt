package com.example.taipeitour

interface TaipeiTourDetailContract {
    interface View {

    }

    interface Presenter {
        fun getData(id: Int)
    }
}