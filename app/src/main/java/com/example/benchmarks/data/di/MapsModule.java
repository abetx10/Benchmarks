package com.example.benchmarks.data.di;

import com.example.benchmarks.data.UpdateMapsDataLogic;
import com.example.benchmarks.presentation.MapsViewModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MapsModule {
    private final MapsViewModel mapsViewModel;

    @Inject
    public MapsModule(MapsViewModel mapsViewModel) {
        this.mapsViewModel = mapsViewModel;
    }

    @Provides
    public MapsViewModel provideMapsViewModel() {
        return mapsViewModel;
    }

    @Provides
    public UpdateMapsDataLogic provideUpdateMapsDataLogic() {
        return new UpdateMapsDataLogic();
    }
}