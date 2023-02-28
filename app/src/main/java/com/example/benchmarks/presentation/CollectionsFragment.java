package com.example.benchmarks.presentation;

import static com.example.benchmarks.presentation.StartFragment.NUMBER;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.presentation.adapter.CollectionsDataAdapter;
import com.example.benchmarks.R;

import java.util.ArrayList;

public class CollectionsFragment extends Fragment implements View.OnClickListener, UpdateListCallback {

    RecyclerView recyclerView;
    EditText mEnterNumberEd;
    Button mStartCalcBt;
    CollectionsDataAdapter collDataAdapter;
    private CollectionsViewModel collectionsVm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collections_table, container, false);

        collectionsVm = new ViewModelProvider(this).get(CollectionsViewModel.class);

        String numbers = this.getArguments().getString(NUMBER);
        collectionsVm.getOperationItemList();

        mEnterNumberEd = view.findViewById(R.id.ed_enterNumber);
        mEnterNumberEd.setText(numbers);
        mStartCalcBt = view.findViewById(R.id.bt_startCalc);
        mStartCalcBt.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.rv_collections);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);

        collDataAdapter = new CollectionsDataAdapter(getContext(), collectionsVm.operationItemsList);
        recyclerView.setAdapter(collDataAdapter);
        collDataAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        collectionsVm.setUpdateListCallback(null);
    }

    @Override
    public void onUpdateList(ArrayList<OperationItem> updateOperationItemsList) {
        collDataAdapter.updateList(updateOperationItemsList);
    }

    @Override
    public void onClick(View view) {
        Integer num = Integer.parseInt(mEnterNumberEd.getText().toString());

        collectionsVm.startProgressBar();
        collDataAdapter.updateList(collectionsVm.updateOperationItemsList);
        collectionsVm.updateData(num);
        collectionsVm.setUpdateListCallback(this);
    }
}