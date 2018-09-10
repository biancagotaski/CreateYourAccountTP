package com.developer.bianca.createyouraccounttp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.bianca.createyouraccounttp.models.RegisterCard;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class RegisterAdapter extends RecyclerView.Adapter{

    private List<DataSnapshot> dataSnapshots;

    private List<RegisterCard> registerCards;

    public RegisterAdapter(){
        dataSnapshots = new ArrayList<>();
    }


//    public RegisterAdapter(String fbEndpoint){
//       dataSnapshots = new ArrayList<>();
//
//        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference(fbEndpoint);
//        dbReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                RegisterCard registerCard = dataSnapshot.getValue(RegisterCard.class);
//                addItem(dataSnapshot);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                String key = dataSnapshot.getKey();
//                for(int i=0; i<dataSnapshots.size(); i++){
//                    if(key.equals(dataSnapshots.get(i).getKey())){
//                        removeItem(i);
//                        break;
//                    }
//                }
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

    public RegisterAdapter(List<RegisterCard> registerCards){
        this.registerCards = registerCards;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.register_card, parent, false);

        return new RegisterViewHolder(card);
    }

    //TODO: implementar os outros textView's que faltaram (cel, cpf e cidade) **no caso da senha não será exibida.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        DataSnapshot dataSnapshot = dataSnapshots.get(position);
//
//        RegisterCard registerCard = dataSnapshot.getValue(RegisterCard.class);
//        RegisterViewHolder viewHolder = (RegisterViewHolder) holder;
//        viewHolder.name.setText(registerCard.getName());
//        viewHolder.email.setText(registerCard.getEmail());
//        viewHolder.phone.setText(registerCard.getPhone());
//        //viewHolder.viewMore.setText(registerCard.get);

        RegisterCard registerCard = registerCards.get(position);
        RegisterViewHolder rvh = (RegisterViewHolder) holder;

        rvh.name.setText(registerCard.getName());
        rvh.email.setText(registerCard.getEmail());
        rvh.phone.setText(registerCard.getPhone());
    }

    @Override
    public int getItemCount() {
        return registerCards.size();
    }

    public void addItem(RegisterCard registerCard) {
        //dataSnapshots.add(0, dataSnapshot);
        registerCards.add(0, registerCard);
        notifyDataSetChanged();
    }

    //VERIFICAR O MÉTODO ABAIXO:
//    private void removeItem(int position){
//        registerCards.remove(position);
//        notifyItemRemoved(position);
//    }

    public class RegisterViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView password;
        public TextView email;
        public TextView phone;
        public TextView cel;
        public TextView cpf;
        public TextView city;
        //public TextView viewMore;

        public RegisterViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_field);
            password = itemView.findViewById(R.id.password_field);
            email = itemView.findViewById(R.id.email_field);
            phone = itemView.findViewById(R.id.phone_field);
            cel = itemView.findViewById(R.id.cel_field);
            cpf = itemView.findViewById(R.id.cpf_field);
            city = itemView.findViewById(R.id.city_field);
            //viewMore = itemView.findViewById(R.id.viewMore_field);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    DataSnapshot snapshot = dataSnapshots.get(getAdapterPosition());
//                }
//            });
        }
    }
}
