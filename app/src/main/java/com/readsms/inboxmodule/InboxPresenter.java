package com.readsms.inboxmodule;

import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.readsms.BasePresenter;
import com.readsms.ReadSMSApp;

import static com.readsms.BaseConstant.URI_SMS;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public class InboxPresenter extends BasePresenter<Inboxmvp.View> implements Inboxmvp.Presenter {

    public InboxPresenter(Inboxmvp.View view) {
        super(view);
    }

    public static InboxPresenter with(@NonNull Inboxmvp.View view) {
        return new InboxPresenter(view);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Uri uri = Uri.parse(URI_SMS);

        return new CursorLoader(ReadSMSApp.getInstance().getApplicationContext(),
                uri, null, null, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        getView().cursorLoaded(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
