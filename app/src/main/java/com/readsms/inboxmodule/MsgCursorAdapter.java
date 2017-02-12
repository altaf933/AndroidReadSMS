package com.readsms.inboxmodule;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.readsms.AppUtils;
import com.readsms.CursorRecyclerViewAdapter;
import com.readsms.inbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by altaf.h.shaikh on 1/7/2017.
 */

public class MsgCursorAdapter extends CursorRecyclerViewAdapter<MsgCursorAdapter.ViewHolder> {


    public MsgCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        String person = cursor.getString(cursor.getColumnIndex("person"));
        String address = cursor.getString(cursor.getColumnIndex("address"));
        viewHolder.snippetView.setText(cursor.getString(cursor.getColumnIndex("body")));
        viewHolder.dateView.setText(AppUtils.millisecToString(cursor.getLong(cursor.getColumnIndex("date"))));
        viewHolder.unreadView.setImageResource(R.drawable.ic_unread_indicator);
        viewHolder.fromView.setText(cursor.getString(cursor.getColumnIndex("address")));
        final boolean hasUnread = cursor.getInt(cursor.getColumnIndexOrThrow("read")) == 0;
        if (hasUnread) {
            viewHolder.unreadView.setVisibility(View.VISIBLE);
            viewHolder.snippetView.setMaxLines(5);
        } else {
            viewHolder.unreadView.setVisibility(View.GONE);
            viewHolder.snippetView.setMaxLines(1);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_conversation, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.conversation_list_name)
        TextView fromView;
        @BindView(R.id.conversation_list_snippet)
        TextView snippetView;
        @BindView(R.id.conversation_list_date)
        TextView dateView;
        @BindView(R.id.conversation_list_badges)
        LinearLayout conversationListBadges;
        @BindView(R.id.conversation_list_muted)
        ImageView mutedView;
        @BindView(R.id.conversation_list_error)
        ImageView errorIndicator;
        @BindView(R.id.conversation_list_unread)
        ImageView unreadView;
        @BindView(R.id.conversation_list_avatar)
        ImageView mAvatarView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
