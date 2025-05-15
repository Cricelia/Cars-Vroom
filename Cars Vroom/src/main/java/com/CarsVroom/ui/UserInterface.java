package com.CarsVroom.ui;
import com.CarsVroom.data.DealershipFileManager;
import com.CarsVroom.model.Dealership;
import com.CarsVroom.model.Vehicle;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    public void display() {
        init();
        // menu loop, scanner input, switch/case goes here eventually
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        // print each vehicle
    }

    public void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
}
