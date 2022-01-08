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
 * Use the {@link Ftab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ftab1 extends Fragment {

    TextView t1,t2,t3,t4,t5,t6;
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

    public Ftab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ftab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Ftab1 newInstance(String param1, String param2) {
        Ftab1 fragment = new Ftab1();
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


        return inflater.inflate(R.layout.fragment_ftab1, container, false);


    }
    @Override
    public void onViewCreated(@Nullable View view,@Nullable Bundle savedInstanceSate)
    {
        super.onViewCreated(view, savedInstanceSate);
        t1=view.findViewById(R.id.course);
        t2=view.findViewById(R.id.branch);
        t3=view.findViewById(R.id.sem);
        t4=view.findViewById(R.id.roll_no);
        t5=view.findViewById(R.id.division);
        t6=view.findViewById(R.id.batch);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        userid=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userid);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                t1.setText(documentSnapshot.getString("course"));
                t2.setText(documentSnapshot.getString("branch"));
                t3.setText(documentSnapshot.getString("Sem"));
                t4.setText(documentSnapshot.getString("Roll No"));
                t5.setText(documentSnapshot.getString("Division"));
                t6.setText(documentSnapshot.getString("batch"));
            }
        });

    }
}