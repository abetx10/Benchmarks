package com.example.benchmarks.data.di;

import com.example.benchmarks.presentation.MapsViewModel;

import dagger.Component;

@Component(modules = {MapsModule.class})
public interface MapsComponent {
    void inject(MapsViewModel viewModel);

    MapsViewModel getMapsViewModel();
}