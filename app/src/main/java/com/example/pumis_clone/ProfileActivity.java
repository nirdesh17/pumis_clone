package com.example.pumis_clone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity{

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userid;
    ImageView proffile;

    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        t16=(TextView)findViewById(R.id.Profile_name);
        t17=(TextView)findViewById(R.id.Enrollment_no);
        proffile=(ImageView)findViewById(R.id.profile_tabs);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        userid=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userid);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {



                    t16.setText(documentSnapshot.getString("Name"));
                    t17.setText(documentSnapshot.getString("Enrollment"));
                Picasso.get().load(String.valueOf(documentSnapshot.get("image"))).into(proffile);


            }
        });

        tabLayout=(TabLayout) findViewById(R.id.tabLayout1);
        pager2=(ViewPager2) findViewById(R.id.vpager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());

          pager2.setAdapter(adapter);



        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.education));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.location));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.call));

    try {


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    catch (Exception e)
    {
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
    }

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}