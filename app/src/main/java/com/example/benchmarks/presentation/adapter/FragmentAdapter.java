package com.example.benchmarks.presentation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.benchmarks.presentation.StartFragment;
import com.example.benchmarks.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position){
//            case 0:
//            case 1:
//                return new StartFragment();
//            default:
//                return null;
//        }
//    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
            return new StartFragment();
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

    public static void setTitle(TabLayout tabLayout) {
        TabLayout.Tab tab;

        tab = tabLayout.getTabAt(0);
        tab.setText(R.string.collections);

        tab = tabLayout.getTabAt(1);
        tab.setText(R.string.maps);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
