/*package com.example.ecom.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ecom.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PlaceOrderActivity extends AppCompatActivity {

    private EditText editTextName, editTextPhoneNumber, editTextAddress;
    private Button buttonPlaceOrder;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonPlaceOrder = findViewById(R.id.buttonPlaceOrder);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder() {
        String name = editTextName.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(address)) {
            // Handle empty fields
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Now, you can store these values in Firebase or perform any other necessary action.
        // You need to have Firebase initialized and set up for this part.

        // Example of storing data in Firebase (you need to replace "your_collection" with your actual collection name):
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("name", name);
        orderData.put("phoneNumber", phoneNumber);
        orderData.put("address", address);

        db.collection("MAD_MP_Orders")
                .add(orderData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(PlaceOrderActivity.this, "Order placed successfully", Toast.LENGTH_SHORT).show();


                        // Navigate to OrderFragment
                        //NavController navController = Navigation.findNavController(PlaceOrderActivity.this, R.id.nav_host_fragment);
                        //navController.navigate(R.id.action_placeOrderActivity_to_orderFragment);

                        Intent intent = new Intent(this, OrderFragment.class);
                        startActivity(intent);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PlaceOrderActivity.this, "Error placing order", Toast.LENGTH_SHORT).show();
                    }
                });
    }
*/