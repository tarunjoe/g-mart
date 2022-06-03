package com.example.g_mart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class mainboard extends AppCompatActivity {


    FirebaseAuth fAuth;
    Button btnsignout;
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter adapter;



    Button orderv ;
    Button addtoc;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainboard);



        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.firestorel);
        btnsignout = findViewById(R.id.btnsignout);
        fAuth = FirebaseAuth.getInstance();
        orderv = (Button) findViewById(R.id.cart123);
        addtoc=(Button) findViewById(R.id.buttonabc);








         orderv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedtocart();
                Intent intent = new Intent(mainboard.this, cart.class);
                startActivity(intent);
            }
        });





        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.signOut();
                signOutUser();


            }
        });






        CollectionReference query = firebaseFirestore.collection("Products");

        FirestoreRecyclerOptions<ProductsModel> options = new FirestoreRecyclerOptions.Builder<ProductsModel>()
                .setQuery(query, ProductsModel.class)
                .build();


        adapter = new FirestoreRecyclerAdapter<ProductsModel, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
                return new ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull ProductsModel model) {
                Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
                holder.list_name.setText(model.getName());
                holder.list_price.setText(model.getPrice() + "");


               




            }
        };




        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private void addedtocart() {
    }

 //   private void addedtocart() {
  //      final  HashMap<String,Object> cartMap = new HashMap<>();
   //     cartMap.put("name",ProductsModel.getName());
    //    cartMap.put("price",ProductsModel.getPrice());
     //   cartMap.put("img",ProductsModel.getImg());
     //   firebaseFirestore.collection("AddToCart").document(fAuth.getCurrentUser().getUid())
      //          .collection("CurrentUser").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
      //      @Override
       //     public void onComplete(@NonNull Task<DocumentReference> task) {
        //        Toast.makeText(mainboard.this,"Added To Cart",Toast.LENGTH_SHORT).show();
         //       finish();
         //   }
       // });
   // }


    private void signOutUser() {
        Intent mainActivity =new Intent(mainboard.this, MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
        finish();
    }






    private static class ProductsViewHolder extends RecyclerView.ViewHolder  {

        private ImageView img;
        private TextView list_name;
        private TextView list_price;


        public ProductsViewHolder(@NonNull View itemView){
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.image);
            list_name=itemView.findViewById(R.id.list_name);
            list_price=itemView.findViewById(R.id.list_price);
           // itemView.setOnClickListener(view -> {
             //   Log.d("demo", "heyy" + getAbsoluteAdapterPosition() + "user"+ list_name );
              //  Log.d("demo", "heyy" + getAbsoluteAdapterPosition() + "user"+ list_price );
           // });

            itemView.findViewById(R.id.buttonabc).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "heyy" + getAbsoluteAdapterPosition() +"user"+ list_name );
                    Log.d("demo", "heyy" + getAbsoluteAdapterPosition() + "user"+ list_price );
                    Log.d("demo", "heyy" + getAbsoluteAdapterPosition() + "user"+ img);
                    Log.d("demo","kokokok"+ getItemId());




                }
            });





        }




    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

}