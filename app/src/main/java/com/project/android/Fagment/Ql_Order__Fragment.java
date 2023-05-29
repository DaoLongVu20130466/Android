package com.project.android.Fagment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.android.Adapter.OderAdapter;
import com.project.android.R;
import com.project.android.model.Oder;
import com.project.android.model.Product;

import java.util.ArrayList;
import java.util.List;


public class Ql_Order__Fragment extends Fragment {
    private RecyclerView recyclerView;
    private OderAdapter oderAdapter;
    private List<Oder> oderList;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup viewGroup,@Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_ql_order__,viewGroup,false);
        recyclerView = view.findViewById(R.id.rcv_order);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        getListOder();
        oderList = new ArrayList<>();
        oderAdapter = new OderAdapter(oderList);
        recyclerView.setAdapter(oderAdapter);
        return view;
    }
    public void getListOder(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Oder/Oder");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                Oder oder = snapshot.getValue(Oder.class);
                if (oder != null){
                    oderList.add(oder);
                    oderAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}