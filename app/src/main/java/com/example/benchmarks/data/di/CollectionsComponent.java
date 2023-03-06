package com.example.benchmarks.data.di;
import com.example.benchmarks.presentation.CollectionsViewModel;

import dagger.Component;

@Component(modules = {CollectionsModule.class})
public interface CollectionsComponent {
    void inject(CollectionsViewModel viewModel);

    CollectionsViewModel getCollectionsViewModel();
}