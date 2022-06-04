package com.example.g_mart;

import android.os.Bundle;
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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class cart extends AppCompatActivity {



    FirebaseAuth fAuth;

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter adapter;
    Button add;

















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);



        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.firestorel);
       // btnsignout = findViewById(R.id.btnsignout);
       // fAuth = FirebaseAuth.getInstance();
       // orderv = (Button) findViewById(R.id.cart123);
        //addtoc=(Button) findViewById(R.id.buttonabc);
   //     mFirestoreList = findViewById(R.id.cartv);
    //    add=findViewById(R.id.button23);




        fAuth = FirebaseAuth.getInstance();

            final HashMap<String,Object> cartMap = new HashMap<>();
            cartMap.put("name",CartsModel.getName());
            cartMap.put("price",CartsModel.getPrice());
            cartMap.put("img",CartsModel.getImg());
            firebaseFirestore.collection("AddToCart").document(fAuth.getCurrentUser().getUid())
                    .collection("CurrentUser").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    Toast.makeText(cart.this,"Added To Cart",Toast.LENGTH_SHORT).show();
                    finish();
                }
            });








     //   CollectionReference query = firebaseFirestore.collection("");

    //    FirestoreRecyclerOptions<CartsModel> options = new FirestoreRecyclerOptions.Builder<CartsModel>()
      //          .setQuery(query, CartsModel.class)
      //          .build();

     //   adapter = new FirestoreRecyclerAdapter<CartsModel, cart.CartViewHolder>(options) {
      //      @NonNull
      //      @Override
      //      public cart.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cart_single, parent, false);
         //       return new cart.CartViewHolder(view);
            }

         //   @Override
          //  protected void onBindViewHolder(@NonNull cart.CartViewHolder holder, int position, @NonNull CartsModel model) {
            //    Glide.with(holder.img1.getContext()).load(model.getImg()).into(holder.img1);
            //    holder.list_name1.setText(model.getName());
            //    holder.list_price1.setText(model.getPrice() + "");

        //    }
      //  };
      //  mFirestoreList.setHasFixedSize(true);
     //   mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
     //   mFirestoreList.setAdapter(adapter);


   // }

   // private class CartViewHolder extends RecyclerView.ViewHolder {

    //    private ImageView img1;
    //    private TextView list_name1;
     //   private TextView list_price1;
     //   public CartViewHolder(@NonNull View itemView){
     //       super(itemView);
      //     img1=(ImageView)itemView.findViewById(R.id.image1);
       //     list_name1=itemView.findViewById(R.id.list_name1);
       //     list_price1=itemView.findViewById(R.id.list_price1);
      //  }

   // }
   // @Override
   // protected void onStop(){
     //   super.onStop();
       // adapter.stopListening();
   // }
   // @Override
   // protected void onStart() {
    //    super.onStart();
     //   adapter.startListening();
   // }





}
