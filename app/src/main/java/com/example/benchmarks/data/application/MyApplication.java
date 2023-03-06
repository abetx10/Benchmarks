package com.example.benchmarks.data.application;

import android.app.Application;

import com.example.benchmarks.data.UpdateDataLogic;
import com.example.benchmarks.data.di.CollectionsComponent;
import com.example.benchmarks.data.di.CollectionsModule;
import com.example.benchmarks.data.di.DaggerCollectionsComponent;
import com.example.benchmarks.presentation.CollectionsViewModel;


public class MyApplication extends Application {

    private CollectionsComponent collectionsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        collectionsComponent = DaggerCollectionsComponent.builder()
                .collectionsModule(new CollectionsModule(new CollectionsViewModel(this, new UpdateDataLogic())))
                .build();
    }

    public CollectionsComponent getCollectionsComponent() {
        return collectionsComponent;
    }
}