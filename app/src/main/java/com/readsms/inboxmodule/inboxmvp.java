package com.readsms.inboxmodule;

import android.app.LoaderManager;
import android.database.Cursor;

/**
 * Created by altaf.h.shaikh on 1/5/2017.
 */

public interface Inboxmvp {

    interface View {
        void cursorLoaded();
    }

    interface Presenter extends LoaderManager.LoaderCallbacks<Cursor> {

    }

}
