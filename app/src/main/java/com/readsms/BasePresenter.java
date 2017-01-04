package com.readsms;

/**
 * Created by altaf.h.shaikh on 1/4/2017.
 */

public class BasePresenter<V> implements BaseMVP.MsgPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    public BasePresenter(V view) {
        attachView(view);
    }

    private BasePresenter() {
        throw new RuntimeException("Cant not be initialized");
    }

    @Override
    public void destroyView() {
        view = null;
    }

    protected boolean isAttached() {
        return view != null;
    }

    protected V getView() {
        checkViewAttached();
        return view;

    }

    private void checkViewAttached() {
        if (!isAttached()) throw new NullPointerException("View not injected to parameter");

    }
}
