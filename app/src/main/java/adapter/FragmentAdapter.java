package adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.benchmarks.CollectionsFragment;
import com.example.benchmarks.MapsFragment;
import com.example.benchmarks.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;

//    private Fragment mFragmentAtPos0;
//    private FragmentManager mFragmentManager;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CollectionsFragment();
            case 1:
                return new MapsFragment();
            default:
                return null;
        }
    }

//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position){
//            case 0:
//                if (mFragmentAtPos0 == null) {
//                    mFragmentAtPos0 = new CollectionsFragment(new FirstPageFragmentListener() {
//                        public void onSwitchToNextFragment() {
//                            mFragmentManager.beginTransaction().remove(mFragmentAtPos0).commit();
//                            mFragmentAtPos0 = new CollectionsTableFragment();
//                            notifyDataSetChanged();
//                        }
//                    });
//                    return mFragmentAtPos0;
//                }
//
//            case 1:
//                return new MapsFragment();
//            default:
//                return null;
//        }
//    }

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
}
