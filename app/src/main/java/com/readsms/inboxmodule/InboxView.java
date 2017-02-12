package com.readsms.inboxmodule;


import android.Manifest;
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

import java.util.List;

import butterknife.BindView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public class InboxView extends BaseFragment<Inboxmvp.View, InboxPresenter> implements
        Inboxmvp.View, EasyPermissions.PermissionCallbacks {

    private InboxPresenter presenter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    private static final int RC_SMS_PERM = 122;

    @Override
    public void cursorLoaded(Cursor cursor) {


        MsgCursorAdapter adapter = new MsgCursorAdapter(ReadSMSApp.getInstance().
                getApplicationContext(), cursor);
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
        smsPermission();


    }

    @AfterPermissionGranted(RC_SMS_PERM)
    public void smsPermission() {
        if (EasyPermissions.hasPermissions(getContext(), Manifest.permission.READ_SMS)) {
            // Have permission, do the thing!
//            Toast.makeText(getActivity(), "TODO: SMS things", Toast.LENGTH_LONG).show();
            getLoaderManager().initLoader(1, null, getPresenter());
        } else {
            // Request one permission
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_sms),
                    RC_SMS_PERM, Manifest.permission.READ_SMS);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        getLoaderManager().initLoader(1, null, getPresenter());
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
