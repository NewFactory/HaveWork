package ca.newfactory.havework;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.activity_main__bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.bottom_nav_menu__navigation_dashboard:
                    selectedFragment = new ca.newfactory.havework.DashboardFragment();
                    break;
                case R.id.bottom_nav_menu__navigation_person:
                    selectedFragment = new PersonFragment();
                    break;
                case R.id.bottom_nav_menu__navigation_notifications:
                    selectedFragment = new NotificationsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main__fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}
