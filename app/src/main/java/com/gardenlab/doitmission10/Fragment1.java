package com.gardenlab.doitmission10;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ViewPager pager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        pager= rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyViewPagerAdapter mPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager());
        Fragment view1 = new View1();
        Fragment view2 = new View2();
        Fragment view3 = new View3();
        mPagerAdapter.addItem(view1);
        mPagerAdapter.addItem(view2);
        mPagerAdapter.addItem(view3);

        pager.setAdapter(mPagerAdapter);
        return rootView;
    }


    class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> views = new ArrayList<>();

        MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Fragment getItem(int position) {
            return views.get(position);
        }

        public void addItem(Fragment view){
            views.add(view);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}

