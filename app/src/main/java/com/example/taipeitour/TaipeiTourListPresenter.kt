package com.example.taipeitour

class TaipeiTourListPresenter(private val view: TaipeiTourListContract.View): TaipeiTourListContract.Presenter {
    override fun loadData(): MutableList<TaipeiTourListModel> {
        val nameList: MutableList<TaipeiTourListModel> = mutableListOf()
        nameList.add(TaipeiTourListModel(1,"title1", "desc1"))
        nameList.add(TaipeiTourListModel(50,"title2", "desc2"))
        nameList.add(TaipeiTourListModel(3,"title3", "desc3"))
        nameList.add(TaipeiTourListModel(43,"title4", "desc4"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))
        nameList.add(TaipeiTourListModel(500,"title5", "desc5"))

        return nameList
    }


}