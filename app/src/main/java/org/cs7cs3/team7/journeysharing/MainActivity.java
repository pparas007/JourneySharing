package org.cs7cs3.team7.journeysharing;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_schedule_journey:
                    Fragment scheduleJourneyFragment = ScheduleJourneyFragment.newInstance();
                    loadFragment(scheduleJourneyFragment);
                    return true;
                case R.id.nav_on_demand_journey:
                    Fragment onDemandJourneyFragment = OnDemandJourneyFragment.newInstance();
                    loadFragment(onDemandJourneyFragment);
                    return true;
                case R.id.nav_profile:
                    Fragment profileFragment = ProfileFragment.newInstance();
                    loadFragment(profileFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //loading default fragment
        Fragment scheduleJourneyFragment = ScheduleJourneyFragment.newInstance();
        loadFragment(scheduleJourneyFragment);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        //transaction.addToBackStack(fragment.toString());
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }
}