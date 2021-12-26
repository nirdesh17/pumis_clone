package com.example.pumis_clone.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.pumis_clone.AcademicfeesActivity;
import com.example.pumis_clone.AttendanceActivity;
import com.example.pumis_clone.HostelActivity;
import com.example.pumis_clone.ProfileActivity;
import com.example.pumis_clone.R;
import com.example.pumis_clone.ResultActivity;
import com.example.pumis_clone.TimeTableActivity;
import com.example.pumis_clone.TranscriptActivity;
import com.example.pumis_clone.TransportActivity;

public class HomeFragment extends Fragment {

    Activity context;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        context= getActivity();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    public void onStart()
    {
        super.onStart();
        CardView prof1 = (CardView) context.findViewById(R.id.profile11);
        CardView prof2 = (CardView) context.findViewById(R.id.profile12);
        CardView prof3 = (CardView) context.findViewById(R.id.profile13);
        CardView prof4 = (CardView) context.findViewById(R.id.profile14);
        CardView prof5 = (CardView) context.findViewById(R.id.profile15);
        CardView prof6 = (CardView) context.findViewById(R.id.profile16);
        CardView prof7 = (CardView) context.findViewById(R.id.profile17);
        CardView prof8 = (CardView) context.findViewById(R.id.profile18);
        prof1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileActivity.class);
                startActivity(intent);
            }
        });
        prof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TimeTableActivity.class);
                startActivity(intent);
            }
        });
        prof3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TranscriptActivity.class);
                startActivity(intent);
            }
        });
        prof4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AttendanceActivity.class);
                startActivity(intent);
            }
        });
        prof5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ResultActivity.class);
                startActivity(intent);
            }
        });
        prof6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AcademicfeesActivity.class);
                startActivity(intent);
            }
        });
        prof7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HostelActivity.class);
                startActivity(intent);
            }
        });
        prof8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TransportActivity.class);
                startActivity(intent);
            }
        });
    }
}