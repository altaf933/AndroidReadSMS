package com.readsms.inboxmodule;

import android.support.annotation.NonNull;

import com.readsms.BasePresenter;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public class InboxPresenter extends BasePresenter<Inboxmvp.View> {

    public InboxPresenter(Inboxmvp.View view) {
        super(view);
    }

    public static InboxPresenter with(@NonNull Inboxmvp.View view) {
        return new InboxPresenter(view);
    }
}
