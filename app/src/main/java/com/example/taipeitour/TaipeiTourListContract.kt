package com.example.taipeitour

import org.w3c.dom.NameList

interface TaipeiTourListContract {
    interface View {

    }

    interface Presenter {
        fun loadData(): MutableList<TaipeiTourListModel>
    }
}