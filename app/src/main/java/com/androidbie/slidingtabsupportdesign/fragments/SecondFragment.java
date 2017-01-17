package com.androidbie.slidingtabsupportdesign.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidbie.slidingtabsupportdesign.MainActivity;
import com.androidbie.slidingtabsupportdesign.R;

/**
 * Created by putuguna on 13/01/17.
 */

public class SecondFragment extends Fragment {

    private Button btnOpenCurrentFragment;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOpenCurrentFragment = (Button) view.findViewById(R.id.btn_open_current_fragment);

        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnOpenCurrentFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("tab_opened", "1");
                editor.commit();
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });

    }
}
