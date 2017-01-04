package com.readsms;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public interface BaseMVP {
    interface MsgPresenter<V> {
        void attachView(V view);

        void destroyView();
    }

}
