package com.developer.bianca.createyouraccounttp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.bianca.createyouraccounttp.models.RegisterCard;
import com.developer.bianca.createyouraccounttp.utils.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterListFragment extends Fragment{
    RecyclerView registerList;

    public RegisterListFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register_list, container, false);
        registerList = rootView.findViewById(R.id.register_list);

        Bundle args = getArguments();
        if(args != null){
            String fbEndpoint = args.getString(Constants.REGISTERS_ENDPOINT_KEY);
            DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference(fbEndpoint);
            // Lê dados do firebase
            dbReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    RegisterCard registerCard = dataSnapshot.getValue(RegisterCard.class);
                    RegisterCard adapter = (RegisterCard) registerList.getAdapter();
                    adapter.addItem(questionCard);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    //TODO:
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
