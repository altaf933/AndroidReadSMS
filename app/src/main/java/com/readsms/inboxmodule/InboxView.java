package com.readsms.inboxmodule;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.readsms.BaseFragment;
import com.readsms.ReadSMSApp;
import com.readsms.inbox.R;

import butterknife.BindView;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public class InboxView extends BaseFragment<Inboxmvp.View, InboxPresenter> implements Inboxmvp.View {

    private InboxPresenter presenter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    public void cursorLoaded(Cursor cursor) {
        MsgCursorAdapter adapter = new MsgCursorAdapter(ReadSMSApp.getInstance().getApplicationContext(), cursor);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        getLoaderManager().initLoader(1, null, getPresenter());

    }
}
