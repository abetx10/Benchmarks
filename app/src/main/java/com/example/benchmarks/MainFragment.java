package com.example.benchmarks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import adapter.FragmentAdapter;


public class MainFragment extends Fragment {
    ViewPager2 mViewPager;
    FragmentAdapter mAdapter;
    TabLayout mTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = view.findViewById(R.id.tabLayout);
        mViewPager = view.findViewById(R.id.viewPager);

        mViewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), getLifecycle()));
        new TabLayoutMediator(mTabLayout, mViewPager, ((tab, position) -> mViewPager.setCurrentItem(tab.getPosition()))).attach();
        FragmentAdapter.setTitle(mTabLayout);
    }
}