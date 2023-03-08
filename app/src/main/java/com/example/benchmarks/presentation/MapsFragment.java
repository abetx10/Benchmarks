package com.example.benchmarks.presentation;


import static com.example.benchmarks.presentation.StartFragment.NUMBER;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.data.application.MyApplication;
import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.presentation.adapter.MapsDataAdapter;
import com.example.benchmarks.presentation.callbacks.UpdateListCallback;

import java.util.ArrayList;

public class MapsFragment extends Fragment implements View.OnClickListener, UpdateListCallback {
    RecyclerView recyclerView;
    EditText mEnterNumberEd;
    Button mStartCalcBt;
    private boolean mStopRequested = false;
    private boolean mStopActivate = false;
    MapsDataAdapter mapsDataAdapter;
    private MapsViewModel mapsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_table, container, false);

        mapsViewModel = ((MyApplication) requireActivity().getApplication()).getMapsComponent().getMapsViewModel();
//        mapsViewModel = new ViewModelProvider(this).get(MapsViewModel.class);

        String numbers = this.getArguments().getString(NUMBER);
        mapsViewModel.getOperationItemList();

        mEnterNumberEd = view.findViewById(R.id.ed_enterNumberMaps);
        mEnterNumberEd.setText(numbers);
        mStartCalcBt = view.findViewById(R.id.bt_startCalcMaps);
        mStartCalcBt.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.rv_maps);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);

        mapsDataAdapter = new MapsDataAdapter(getContext(), mapsViewModel.operationItemsList);
        recyclerView.setAdapter(mapsDataAdapter);
        mapsDataAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapsViewModel.setUpdateListCallback(null);
    }

    @Override
    public void onUpdateList(ArrayList<OperationItem> list) {
        mapsDataAdapter.updateList(list);
    }

    @Override
    public void onClick(View v) {
        if (!mStopActivate) {
            mStartCalcBt.setText(R.string.stop);
            mStartCalcBt.setBackgroundColor(getResources().getColor(R.color.black));
            mStopActivate = true;

            mapsViewModel.startProgressBar();
            mapsDataAdapter.updateList(mapsViewModel.updateOperationItemsList);

            int num = Integer.parseInt(mEnterNumberEd.getText().toString());
            mapsViewModel.setUpdateListCallback((UpdateListCallback) this);
            mapsViewModel.updateData(num, mStopRequested);

        } else {
            mStopRequested = true;
            mStartCalcBt.setText(R.string.start);
            mStartCalcBt.setBackgroundColor(getResources().getColor(R.color.purple_500));
        }
    }
}