package com.example.benchmarks;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.benchmarks.domain.GetArrayListData;
import java.util.ArrayList;
import adapter.CollectionsDataLineAdapter;
import adapter.TimeData;

public class CollectionsTableFragment extends Fragment implements View.OnClickListener{
    public final static String NUMBER = "number";

    RecyclerView recyclerView;
    EditText mEnterNumberEd;
    Button mStartCalcBt;
    CollectionsDataLineAdapter collDataAdapter;
    private ArrayList<TimeData> timeDataArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collections_table, container, false);

        String numbers = this.getArguments().getString(NUMBER);
        dataInitialize();

        mEnterNumberEd = view.findViewById(R.id.ed_enterNumber);
        mEnterNumberEd.setText(numbers);
        mStartCalcBt = view.findViewById(R.id.bt_startCalc);
        mStartCalcBt.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.rv_collections);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        collDataAdapter = new CollectionsDataLineAdapter(getContext(), timeDataArrayList);
        recyclerView.setAdapter(collDataAdapter);
        collDataAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onClick(View view) {
        updateProgressBar();
        updateData();
    }

    private void dataInitialize() {
        timeDataArrayList = new ArrayList<>();
        String[] dataTitle = new String[] {
                getString(R.string.title_1),
                getString(R.string.title_2),
                getString(R.string.title_3),
                getString(R.string.title_4),
                getString(R.string.title_5),
                getString(R.string.title_6),
                getString(R.string.title_7)
        };

        String[] timeDataArray = new String[]{
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
        };

        String[] state = new String[] {
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
        };

        for (int i = 0; i < dataTitle.length; i++) {
            TimeData timeData = new TimeData(dataTitle[i], timeDataArray[i], state[i]);
            timeDataArrayList.add(timeData);
        }
    }

        private void updateProgressBar() {
            timeDataArrayList.clear();

            String[] dataTitle = new String[] {
                    getString(R.string.title_1),
                    getString(R.string.title_2),
                    getString(R.string.title_3),
                    getString(R.string.title_4),
                    getString(R.string.title_5),
                    getString(R.string.title_6),
                    getString(R.string.title_7)
            };

            String[] timeDataArray = new String[] {
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
                    getString(R.string.startArrayListData),
            };

            String[] stateIsProgress = new String[] {
                    getString(R.string.state_progress),
                    getString(R.string.state_progress),
                    getString(R.string.state_progress),
                    getString(R.string.state_progress),
                    getString(R.string.state_progress),
                    getString(R.string.state_progress),
                    getString(R.string.state_progress)
            };

            for (int i = 0; i < dataTitle.length; i++) {
                TimeData updateProgressBar = new TimeData(dataTitle[i], timeDataArray[i], stateIsProgress[i]);
                timeDataArrayList.add(updateProgressBar);
                collDataAdapter.notifyDataSetChanged();
            }
        }

        private void updateData() {
        Integer num = Integer.parseInt(mEnterNumberEd.getText().toString());
        timeDataArrayList.clear();

        String[] dataTitle = new String[]{
                getString(R.string.title_1),
                getString(R.string.title_2),
                getString(R.string.title_3),
                getString(R.string.title_4),
                getString(R.string.title_5),
                getString(R.string.title_6),
                getString(R.string.title_7)
        };

        String[] updateArrayListData = new String[]{
                    String.valueOf(new GetArrayListData(num).AddingBegin()),
                    String.valueOf(new GetArrayListData(num).AddingEnd()),
                    String.valueOf(new GetArrayListData(num).AddingMiddle()),
                    String.valueOf(new GetArrayListData(num).SearchByValue()),
                    String.valueOf(new GetArrayListData(num).RemoveBegin()),
                    String.valueOf(new GetArrayListData(num).RemoveMiddle()),
                    String.valueOf(new GetArrayListData(num).RemoveEnd())
            };

        String[] state = new String[] {
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
                    getString(R.string.state_ready),
            };

        for (int i = 0; i < dataTitle.length; i++) {
            TimeData updateTimeData = new TimeData(dataTitle[i], updateArrayListData[i], state[i]);
            timeDataArrayList.add(updateTimeData);
            collDataAdapter.notifyDataSetChanged();
        }
    }

//    public void onBackPressed() {
//        getChildFragmentManager().popBackStack();
//    }
}