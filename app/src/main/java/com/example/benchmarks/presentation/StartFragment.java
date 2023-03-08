package com.example.benchmarks.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.benchmarks.R;
import com.google.android.material.tabs.TabLayout;

public class StartFragment extends Fragment implements View.OnClickListener {
    public final static String NUMBER = "number";

    Button mCalculateCollBt;
    EditText mCollectionSizeEd;
    TabLayout mTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout = view.findViewById(R.id.tabLayout);
        mCollectionSizeEd = view.findViewById(R.id.ed_collectionSize);
        mCalculateCollBt = view.findViewById(R.id.bt_calculateCollections);
        mCalculateCollBt.setOnClickListener(this);
        mCalculateCollBt.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (MainFragment.tabPosition == 0) {
            Fragment fragment = new CollectionsFragment();
            goFromStartToSecondFragment(fragment);
        } else {
            Fragment fragment = new MapsFragment();
            goFromStartToSecondFragment(fragment);
        }
    }

    public void goFromStartToSecondFragment(Fragment fragment) {
        String input = mCollectionSizeEd.getText().toString();
        if (input.matches("[0-9]+")) {
            Bundle args = new Bundle();
            args.putString(NUMBER, input);
            fragment.setArguments(args);
        } else {
            Toast.makeText(getContext(), "Please use only numbers", Toast.LENGTH_LONG).show();
            return;
        }

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.cl_fragmentStart, fragment)
                .addToBackStack(null)
                .commit();
        mCalculateCollBt.setVisibility(View.GONE);
    }
}