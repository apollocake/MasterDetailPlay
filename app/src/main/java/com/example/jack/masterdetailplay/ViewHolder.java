package com.example.jack.masterdetailplay;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final MyGLSurfaceView mContentView;
    public DirectoryModel.FileItem mItem;

    public ViewHolder(View view) {
        super(view);
        mView = view;
        mIdView = (TextView) view.findViewById(R.id.id);
        mContentView = (MyGLSurfaceView) view.findViewById(R.id.bloop_detail_container_gl);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}