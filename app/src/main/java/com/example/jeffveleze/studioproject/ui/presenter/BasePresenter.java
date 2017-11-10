package com.example.jeffveleze.studioproject.ui.presenter;

import com.example.jeffveleze.studioproject.ui.view.BaseView;

/**
 * Created by jeffveleze on 11/4/17.
 */
public class BasePresenter <T extends BaseView> implements LeaderBoardPresenterInterface<T> {
    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {

        public MvpViewNotAttachedException() {
            super("Please call LeaderBoardPresenterInterface.attachView(BaseView) before" +
                    " requesting data to the LeaderBoardPresenterInterface");
        }
    }
}