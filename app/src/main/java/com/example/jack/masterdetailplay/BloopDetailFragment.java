package com.example.jack.masterdetailplay;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BloopDetailFragment extends Fragment
{
    public static final String ARG_ITEM_ID = "item_id";
    private GLSurfaceView mGLView;

    public BloopDetailFragment()
    {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mGLView = new MyGLSurfaceView(this.getActivity()); //I believe you may also use getActivity().getApplicationContext();
        return mGLView;
    }
}
