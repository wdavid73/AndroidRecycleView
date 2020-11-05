package com.example.tallermaterialdesign;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.CarViewHolder>{

    private ArrayList<Car> cars;
    private OnCarClickListener clickListener;

    public AdapterCar(ArrayList<Car> cars, OnCarClickListener clickListener){
        this.cars = cars;
        this.clickListener = clickListener;
    }

    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(
                parent.getContext()
        ).inflate(R.layout.item_car,parent,false);
        return new CarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        final Car car = cars.get(position);
        holder.photo.setImageResource(car.getPhoto());
        holder.licence_plate.setText(car.getLicense_plate());
        holder.brand.setText(String.valueOf(car.getBrand()));
        holder.color.setText(String.valueOf(car.getColor()));
        holder.model.setText(String.valueOf(car.getModel()));
        holder.price.setText(String.valueOf(car.getPrice()));

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onCarClick(car);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView photo;
        private TextView licence_plate;
        private TextView brand;
        private TextView model;
        private TextView color;
        private TextView price;
        private View v;

        public CarViewHolder(View itemView){
            super(itemView);
            v = itemView;
            photo =  v.findViewById(R.id.car_image);
            licence_plate = v.findViewById(R.id.lblLicense_Plate);
            brand = v.findViewById(R.id.lblBrand);
            color = v.findViewById(R.id.lblColor);
            model = v.findViewById(R.id.lblModel);
            price = v.findViewById(R.id.lblPrice);
        }
    }

    public interface OnCarClickListener{
        void onCarClick(Car car);
    }
}
