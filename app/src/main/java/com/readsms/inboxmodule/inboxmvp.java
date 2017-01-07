package com.readsms.inboxmodule;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public interface Inboxmvp {

    interface View {
        void cursorLoaded(Cursor cursor);
    }

    interface Presenter extends LoaderManager.LoaderCallbacks<Cursor> {

    }

}
