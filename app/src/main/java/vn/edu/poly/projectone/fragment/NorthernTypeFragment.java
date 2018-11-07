package vn.edu.poly.projectone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.cook.NorthernGrilledActivity;
import vn.edu.poly.projectone.type.NorthernCowActivity;


public class NorthernTypeFragment extends Fragment {

    private LinearLayout lnCow;

    public static NorthernTypeFragment newInstance() {
        NorthernTypeFragment fragment = new NorthernTypeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_northern_type, container, false);
        lnCow = view.findViewById(R.id.lnCow);
        lnCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NorthernCowActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
