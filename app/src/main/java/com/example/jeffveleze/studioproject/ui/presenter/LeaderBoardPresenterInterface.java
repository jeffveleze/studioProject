package com.example.jeffveleze.studioproject.ui.presenter;

import com.example.jeffveleze.studioproject.ui.view.BaseView;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface LeaderBoardPresenterInterface<V extends BaseView> {

    void attachView(V mvpView);

    void detachView();
}