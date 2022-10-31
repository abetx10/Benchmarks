package com.example.benchmarks.presentation;

import static com.example.benchmarks.presentation.StartFragment.NUMBER;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.benchmarks.domain.CopyOnWriteArrayList.CopyOnWriteArrayListSizeUseCase;
import com.example.benchmarks.presentation.adapter.CollectionsDataLineAdapter;
import com.example.benchmarks.domain.ArrayList.ArrayListAddingBeginUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListAddingEndUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListAddingMiddleUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListRemoveBeginUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListRemoveEndUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListRemoveMiddleUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListSearchByValueUseCase;
import com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase;
import com.example.benchmarks.domain.LinkedList.LinkedListSizeUseCase;
import com.example.benchmarks.R;
import com.example.benchmarks.data.TimeDataList;
import com.example.benchmarks.data.TitleData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CollectionsTableFragment extends Fragment implements View.OnClickListener{

    RecyclerView recyclerView;
    EditText mEnterNumberEd;
    Button mStartCalcBt;
    CollectionsDataLineAdapter collDataAdapter;
    private ArrayList<TimeDataList> timeDataList;
    private ArrayList<TitleData> titleDataArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collections_table, container, false);

        String numbers = this.getArguments().getString(NUMBER);
        titleInitialize();
        dataInitialize();

        mEnterNumberEd = view.findViewById(R.id.ed_enterNumber);
        mEnterNumberEd.setText(numbers);
        mStartCalcBt = view.findViewById(R.id.bt_startCalc);
        mStartCalcBt.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.rv_collections);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        collDataAdapter = new CollectionsDataLineAdapter(getContext(), timeDataList, titleDataArrayList);
        recyclerView.setAdapter(collDataAdapter);
        collDataAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onClick(View view) {
        updateProgressBar();
        updateData();
    }

    private void titleInitialize() {
        titleDataArrayList = new ArrayList<>();
        String[] titleData = new String[] {
                getString(R.string.title_1),
                getString(R.string.title_2),
                getString(R.string.title_3),
                getString(R.string.title_4),
                getString(R.string.title_5),
                getString(R.string.title_6),
                getString(R.string.title_7)
        };

        for (int i = 0; i < titleData.length; i++) {
            TitleData title = new TitleData(titleData[i]);
            titleDataArrayList.add(title);
        }
    }

    private void dataInitialize() {
        timeDataList = new ArrayList<>();
        String[] timeDataArray = new String[]{
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
        };

        String[] stateArray = new String[] {
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
        };

        String[] timeDataLinked = new String[]{
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
        };

        String[] stateLinked = new String[] {
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
        };

        String[] timeDataCopy = new String[]{
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
                getString(R.string.startArrayListData),
        };

        String[] stateCopy = new String[] {
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
                getString(R.string.state_ready),
        };

        for (int i = 0; i < timeDataArray.length; i++) {
            TimeDataList timeDataList = new TimeDataList(
                    timeDataArray[i], stateArray[i],
                    timeDataLinked[i], stateLinked[i],
                    timeDataCopy[i], stateCopy[i]
            );
            this.timeDataList.add(timeDataList);
        }
    }

    private void updateProgressBar() {
        timeDataList.get(0).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(0);

        timeDataList.get(1).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(1);

        timeDataList.get(2).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(2);

        timeDataList.get(3).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(3);

        timeDataList.get(4).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(4);

        timeDataList.get(5).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(5);

        timeDataList.get(6).stateArrayList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(6);

        timeDataList.get(0).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(0);

        timeDataList.get(1).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(1);

        timeDataList.get(2).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(2);

        timeDataList.get(3).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(3);

        timeDataList.get(4).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(4);

        timeDataList.get(5).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(5);

        timeDataList.get(6).stateLinkedList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(6);

        timeDataList.get(0).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(0);

        timeDataList.get(1).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(1);

        timeDataList.get(2).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(2);

        timeDataList.get(3).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(3);

        timeDataList.get(4).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(4);

        timeDataList.get(5).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(5);

        timeDataList.get(6).stateCopyList = getString(R.string.state_progress);
        collDataAdapter.notifyItemChanged(6);
        }

    private void updateData() {
        Integer num = Integer.parseInt(mEnterNumberEd.getText().toString());

        new ArrayListSizeUseCase(num).arrayListSize
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( s -> updateArrayListTime());

        new LinkedListSizeUseCase(num).linkedListSize
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( s -> doneC());

        new CopyOnWriteArrayListSizeUseCase(num).copyListSize
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( s -> doneC());

    }

    private void doneC() {
        Toast.makeText(requireActivity(), "DoneCopy", Toast.LENGTH_LONG).show();
    }

    private void updateArrayListTime() {
                    new ArrayListAddingBeginUseCase().addingBegin
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(0).timeArrayList = time.toString();
                        timeDataList.get(0).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(0);
                    });

            new ArrayListAddingMiddleUseCase().addingMiddle
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(1).timeArrayList = time.toString();
                        timeDataList.get(1).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(1);
                    });

            new ArrayListAddingEndUseCase().addingEnd
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(2).timeArrayList = time.toString();
                        timeDataList.get(2).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(2);
                    });

            new ArrayListSearchByValueUseCase().searchByValue
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(3).timeArrayList = time.toString();
                        timeDataList.get(3).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(3);
                    });

            new ArrayListRemoveBeginUseCase().removeBegin
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(4).timeArrayList = time.toString();
                        timeDataList.get(4).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(4);
                    });

            new ArrayListRemoveMiddleUseCase().removeMiddle
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(5).timeArrayList = time.toString();
                        timeDataList.get(5).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(5);
                    });

            new ArrayListRemoveEndUseCase().removeEnd
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> {
                        timeDataList.get(6).timeArrayList = time.toString();
                        timeDataList.get(6).stateArrayList = getString(R.string.state_ready);
                        collDataAdapter.notifyItemChanged(6);
                    });
    }
}

//    public void onBackPressed() {
//        getChildFragmentManager().popBackStack();
//    }
