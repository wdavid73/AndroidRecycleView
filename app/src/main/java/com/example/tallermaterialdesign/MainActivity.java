package com.example.tallermaterialdesign;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterCar.OnCarClickListener{

    private RecyclerView list_cars;
    private AdapterCar adapter;
    private LinearLayoutManager llm;
    private ArrayList<Car> cars;
    private Intent inte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_cars = findViewById(R.id.lstCars);

        Log.i("info" , String.valueOf(cars));
        //cars = new ArrayList<Car>();
        //cars.add(new Car(R.drawable.image1 , "ABC-123","BMW","2000","RED","1250"));
        //cars.add(new Car(R.drawable.image2 , "ABC-321","BMW","2000","RED","1350"));
        //cars.add(new Car(R.drawable.image3 , "ABC-222","BMW","2000","RED","2250"));


        adapter = new AdapterCar(cars ,this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_cars.setLayoutManager(llm);
        list_cars.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                inte = new Intent(MainActivity.this,AddCar.class);
                startActivity(inte);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("pause" , "metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("stop" , "metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("destroy" , "metodo onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start" , "metodo onStart");
        cars = Data.get();

        adapter = new AdapterCar(cars ,this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_cars.setLayoutManager(llm);
        list_cars.setAdapter(adapter);
    }

    @Override
    public void onCarClick(Car car) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putString("licence_plate" , car.getLicense_plate());
        bundle.putString("brand" , String.valueOf(car.getBrand()));
        bundle.putString("color" , String.valueOf(car.getColor()));
        bundle.putString("model" , String.valueOf(car.getModel()));
        bundle.putString("price" , car.getPrice());
        bundle.putInt("photo" , car.getPhoto());

        intent = new Intent(MainActivity.this, DetailsCar.class);
        intent.putExtra("datos" , bundle);
        startActivity(intent);
    }

    public void restartActivity(){
        Intent mIntent = getIntent();
        finish();
        startActivity(mIntent);
    }
}