package com.example.benchmarks.data.application;

import android.app.Application;

import com.example.benchmarks.data.UpdateDataLogic;
import com.example.benchmarks.data.UpdateMapsDataLogic;
import com.example.benchmarks.data.di.CollectionsComponent;
import com.example.benchmarks.data.di.CollectionsModule;
import com.example.benchmarks.data.di.DaggerCollectionsComponent;
import com.example.benchmarks.data.di.DaggerMapsComponent;
import com.example.benchmarks.data.di.MapsComponent;
import com.example.benchmarks.data.di.MapsModule;
import com.example.benchmarks.presentation.CollectionsViewModel;
import com.example.benchmarks.presentation.MapsViewModel;

public class MyApplication extends Application {

    private CollectionsComponent collectionsComponent;
    private MapsComponent mapsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        collectionsComponent = DaggerCollectionsComponent.builder()
                .collectionsModule(new CollectionsModule(new CollectionsViewModel(this, new UpdateDataLogic())))
                .build();

        mapsComponent = DaggerMapsComponent.builder()
                .mapsModule(new MapsModule(new MapsViewModel(this, new UpdateMapsDataLogic())))
                .build();
    }

    public MapsComponent getMapsComponent() {
        return mapsComponent;
    }

    public CollectionsComponent getCollectionsComponent() {
        return collectionsComponent;
    }
}