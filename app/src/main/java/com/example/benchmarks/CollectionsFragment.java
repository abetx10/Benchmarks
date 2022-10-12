package com.example.benchmarks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adapter.FragmentAdapter;


public class CollectionsFragment extends Fragment implements View.OnClickListener {
//    public final static String COLL_FRAG_TAG = "collFrag";
    public final static String NUMBER = "number";

    Button mCalculateCollBt;
    EditText mCollectionSizeEd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCollectionSizeEd = view.findViewById(R.id.ed_collectionSize);
        mCalculateCollBt = view.findViewById(R.id.bt_calculateCollections);
        mCalculateCollBt.setOnClickListener(this);
        mCalculateCollBt.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
//        mCollectionSizeEd.setText("100");

        Fragment fragment = new CollectionsTableFragment();
        Bundle args = new Bundle();
        args.putString(NUMBER, mCollectionSizeEd.getText().toString());
        fragment.setArguments(args);

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.cl_fragmentCollection, fragment)
                .addToBackStack(null)
                .commit();
        mCalculateCollBt.setVisibility(View.GONE);
    }
}