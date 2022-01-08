package com.example.pumis_clone;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pumis_clone.databinding.ActivityNextBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class NextActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNext.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_timetable,R.id.nav_transcript,R.id.nav_attendence,R.id.nav_result,R.id.nav_fees,R.id.nav_hostel,R.id.nav_transport)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_next);
        try
        {
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
        };
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=item.getItemId();
                switch (i)
                {
                    case R.id.nav_profile:
                        Intent intent1= new Intent(NextActivity.this,ProfileActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_timetable:
                        Intent intent2= new Intent(NextActivity.this,TimeTableActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_transcript:
                        Intent intent3= new Intent(NextActivity.this,TranscriptActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_attendence:
                        Intent intent4= new Intent(NextActivity.this,AttendanceActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_result:
                        Intent intent5= new Intent(NextActivity.this,ResultActivity.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_fees:
                        Intent intent6= new Intent(NextActivity.this,AcademicfeesActivity.class);
                        startActivity(intent6);
                        break;
                    case R.id.nav_hostel:
                        Intent intent7= new Intent(NextActivity.this,HostelActivity.class);
                        startActivity(intent7);
                        break;
                    case R.id.nav_transport:
                        Intent intent8= new Intent(NextActivity.this,TransportActivity.class);
                        startActivity(intent8);
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();

                        break;
                    default:
                        break;
                }


                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.next, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_next);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



}