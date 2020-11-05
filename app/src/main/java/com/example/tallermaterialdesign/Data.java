package com.example.tallermaterialdesign;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Car> cars = new ArrayList();

    public static void save(Car c){
        cars.add(c);
    }

    public static ArrayList<Car> get(){
        return cars;
    }
}
