package vn.edu.poly.projectone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.R;


public class NorthernCookFragment extends Fragment {

    private LinearLayout lnNuong;

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
        View view = inflater.inflate(R.layout.fragment_northern_cook, container, false);
        lnNuong = view.findViewById(R.id.lnNuong);
        lnNuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NorthernGrilledActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
