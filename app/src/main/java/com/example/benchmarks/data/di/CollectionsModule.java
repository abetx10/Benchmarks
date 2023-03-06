package com.example.benchmarks.data.di;

import com.example.benchmarks.data.UpdateDataLogic;
import com.example.benchmarks.presentation.CollectionsViewModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionsModule {
    private final CollectionsViewModel collectionsViewModel;

    @Inject
    public CollectionsModule(CollectionsViewModel collectionsViewModel) {
        this.collectionsViewModel = collectionsViewModel;
    }

    @Provides
    public CollectionsViewModel provideCollectionsViewModel() {
        return collectionsViewModel;
    }

    @Provides
    public UpdateDataLogic provideUpdateDataLogic() {
        return new UpdateDataLogic();
    }
}