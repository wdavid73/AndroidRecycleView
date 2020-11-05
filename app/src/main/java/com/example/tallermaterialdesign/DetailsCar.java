package com.example.tallermaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsCar extends AppCompatActivity {

    private ImageView photo;
    private TextView licence_plate,brand,model,color,price;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_car);

        photo = findViewById(R.id.imgCarDetails);
        licence_plate = findViewById(R.id.lblLicensePlateDetails);
        brand = findViewById(R.id.lblDetailsBrand);
        color = findViewById(R.id.lblDetailsColor);
        model = findViewById(R.id.lblDetailsModel);
        price = findViewById(R.id.lblDetailsPrice);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        licence_plate.setText(bundle.getString("cedula"));
        brand.setText(bundle.getString("brand"));
        color.setText(bundle.getString("color"));
        model.setText(bundle.getString("model"));
        price.setText(bundle.getString("price"));
        photo.setImageResource(bundle.getInt("photo"));

    }
}