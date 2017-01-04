package com.readsms.inboxmodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.readsms.BaseFragment;
import com.readsms.inbox.R;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public class InboxView extends BaseFragment<Inboxmvp.View, InboxPresenter> implements Inboxmvp.View {

    private InboxPresenter presenter;

    @Override
    public void cursorLoaded() {

    }

    @Override
    protected int fragmentLayout() {
        return R.layout.inboxmain;
    }

    @NonNull
    @Override
    protected InboxPresenter getPresenter() {
        if (presenter == null)
            presenter = InboxPresenter.with(this);
        return presenter;
    }

    @Override
    protected void onFragmentCreated(View view, @Nullable Bundle savedInstanceState) {


    }
}
