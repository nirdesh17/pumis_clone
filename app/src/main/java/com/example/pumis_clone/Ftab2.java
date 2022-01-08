package com.example.pumis_clone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ftab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ftab2 extends Fragment {

    TextView t7,t8,t9,t10,t11;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userid;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Ftab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ftab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Ftab2 newInstance(String param1, String param2) {
        Ftab2 fragment = new Ftab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ftab2, container, false);
//         Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ftab2, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view,@Nullable Bundle savedInstanceSate)
    {
        super.onViewCreated(view, savedInstanceSate);
        t7=view.findViewById(R.id.address);
        t8=view.findViewById(R.id.city);
        t9=view.findViewById(R.id.district);
        t10=view.findViewById(R.id.state);
        t11=view.findViewById(R.id.country);


        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        userid=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userid);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                t7.setText(documentSnapshot.getString("address"));
                t8.setText(documentSnapshot.getString("city"));
                t9.setText(documentSnapshot.getString("district"));
                t10.setText(documentSnapshot.getString("State"));
                t11.setText(documentSnapshot.getString("Country"));
            }
        });

    }
}