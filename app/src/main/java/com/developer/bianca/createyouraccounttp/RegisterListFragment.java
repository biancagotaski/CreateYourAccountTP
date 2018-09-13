package com.developer.bianca.createyouraccounttp;

import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developer.bianca.createyouraccounttp.models.RegisterCard;
import com.developer.bianca.createyouraccounttp.utils.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class RegisterListFragment extends Fragment {

    static {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    DatabaseReference dbReference;
    String fbEndpoint;
    RecyclerView registerList;
    //OnFragmentInteractionListener fragmentInteractionListener;
    // isso é para oferecer um listener para o card e atribuir uma ação à ele
    //referente ao listener.

    public RegisterListFragment() { /* Required empty public constructor */ }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register_list, container, false);
        registerList = rootView.findViewById(R.id.register_list);

        List<RegisterCard> registerCardList = new LinkedList<>();
        final RegisterAdapter adapter = new RegisterAdapter(registerCardList);
        registerList.setAdapter(adapter);
        registerList.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle args = getArguments();
        if (args != null) {
            fbEndpoint = args.getString(Constants.REGISTERS_ENDPOINT_KEY);
            dbReference = FirebaseDatabase.getInstance().getReference(fbEndpoint);

            // Lê dados do firebase
            dbReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    RegisterCard registerCard = dataSnapshot.getValue(RegisterCard.class);
                    RegisterAdapter adapter = (RegisterAdapter) registerList.getAdapter();
                    adapter.addItem(registerCard);
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

            dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(!dataSnapshot.exists()){
                        Toast.makeText(getContext(), "Lista vazia", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        return rootView;
    }

    public static RegisterListFragment newInstance(String fbEndpoint){
        Bundle args = new Bundle();
        RegisterListFragment fragment = new RegisterListFragment();
        args.putString(Constants.REGISTERS_ENDPOINT_KEY, fbEndpoint);
        fragment.setArguments(args);

        return fragment;
    }
}
