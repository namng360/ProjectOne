package vn.edu.poly.projectone.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.poly.projectone.R;


public class NorthernCookFragment extends Fragment {
    public static NorthernCookFragment newInstance() {
        NorthernCookFragment fragment = new NorthernCookFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_northern_cook, container, false);
    }
}
