package com.example.tallermaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class AddCar extends AppCompatActivity {

    private Spinner sp_brands, sp_models, sp_colors;
    private EditText licence_plate , price;
    private String[] brands , models, colors;
    private ArrayAdapter<String> adapterBrand, adapterModel,adapterColor;
    private int photo[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        licence_plate = findViewById(R.id.txtLicence_plate);
        price = findViewById(R.id.txtPrice);
        sp_brands = findViewById(R.id.spBrand);
        sp_colors = findViewById(R.id.spColor);
        sp_models = findViewById(R.id.spModel);

        photo = new int[3];
        photo[0]  = R.drawable.image1;
        photo[1]  = R.drawable.image2;
        photo[2]  = R.drawable.image3;

        brands = getResources().getStringArray(R.array.brands_cars);
        models = getResources().getStringArray(R.array.models_cars);
        colors = getResources().getStringArray(R.array.colors_cars);

        adapterBrand = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                brands);

        adapterModel = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                models);

        adapterColor = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                colors);

        sp_brands.setAdapter(adapterBrand);
        sp_models.setAdapter(adapterModel);
        sp_colors.setAdapter(adapterColor);
    }

    public void save( View v ){
        Car c;
        String lc, pri,b,co,m;
        int color,model,brand;
        if ( validate() ){
            lc = licence_plate.getText().toString();
            pri = price.getText().toString();

            brand = sp_brands.getSelectedItemPosition();
            color = sp_colors.getSelectedItemPosition();
            model = sp_models.getSelectedItemPosition();

            switch (brand){
                case 1:
                    b = getString(R.string.brand_bmw);
                    break;
                case 2:
                    b = getString(R.string.brand_audi);
                    break;
                case 3:
                    b = getString(R.string.brand_renault);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + brand);
            }

            switch (color){
                case 1:
                    co =  getString(R.string.green);
                    break;
                case 2:
                    co = getString(R.string.red);
                    break;
                case 3:
                    co = getString(R.string.blue);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + color);
            }

            switch (model){
                case 1:
                    m = getString(R.string.model_2000);
                    break;
                case 2:
                    m = getString(R.string.model_2005);
                    break;
                case 3:
                    m = getString(R.string.model_2010);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + model);
            }

            Log.i("Model" , m);
            Log.i("Brand" , b);
            Log.i("Color" , co);
            Log.i("Licence Plate" , lc);
            Log.i("Price" , pri);

            c = new Car(randomPhoto(photo),lc,b,m,co,pri);
            c.save();

            Log.i("cars" , String.valueOf(Data.get()));
            Toast.makeText(this, R.string.car_added , Toast.LENGTH_LONG).show();
        }

    }

    public int randomPhoto(int photos[]){
        int select_photo;
        Random r = new Random();
        select_photo = r.nextInt(photos.length);
        return photos[select_photo];
    }

    public boolean validate(){
        if (licence_plate.getText().toString().trim().isEmpty()) {
            licence_plate.setError(getString(R.string.validate_licence_plate));
            licence_plate.requestFocus();
            return false;
        }

        if (price.getText().toString().isEmpty()) {
            price.setError(getString(R.string.validate_price));
            price.requestFocus();
            return false;
        }

        if (Integer.parseInt(price.getText().toString()) == 0) {
            price.setError(getString(R.string.validate_price));
            price.requestFocus();
            return false;
        }
        if(sp_brands.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_brand,Toast.LENGTH_LONG).show();
            return false;
        }
        if(sp_models.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_model,Toast.LENGTH_LONG).show();
            return false;
        }
        if(sp_colors.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_color,Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}