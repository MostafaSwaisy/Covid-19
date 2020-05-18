package com.example.cov19;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.cov19.Fragments.UserFragment;
import com.example.cov19.Fragments.MapsFragment;
import com.example.cov19.Fragments.NewsFragment;
import com.example.cov19.Fragments.StatsFragment;
import com.example.cov19.Fragments.SymptomsFragment;
import com.google.android.material.tabs.TabLayout;



import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout =  findViewById(R.id.tab_layout);

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new StatsFragment(),"Stats");
        viewPagerAdapter.addFragment(new NewsFragment(),"News");
        viewPagerAdapter.addFragment(new MapsFragment(),"Maps");
        viewPagerAdapter.addFragment(new SymptomsFragment(),"Symptoms");
        viewPagerAdapter.addFragment(new UserFragment(),"Chat");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private  ArrayList<String> titles;

    ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        this.fragments = new ArrayList<>();
        this.titles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public  void  addFragment(Fragment fragment , String title){
        fragments.add(fragment);
        titles.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
