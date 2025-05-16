package com.CarsVroom.ui;
import com.CarsVroom.data.DealershipFileManager;
import com.CarsVroom.model.Dealership;
import com.CarsVroom.model.Vehicle;

import java.util.ArrayList;


public class UserInterface {
    private Dealership dealership;
    private DisplayHelper displayHelper;

    public void display() {
        init();

        // menu loop, scanner input, switch/case goes here eventually

        DisplayHelper helper = new DisplayHelper(dealership);
        int choice = 0;
        switch (choice) {
            case 1 -> helper.processGetAllVehicles();
            case 2 -> helper.processGetByPrice();
            case 3 -> helper.processGetByMakeModel();
            case 4 -> helper.processGetByYear();
            case 5 -> helper.processGetByColor();
            case 6 -> helper.processGetByMileage();
            case 7 -> helper.processGetByType();
            case 8 -> helper.processAddVehicle();
            case 9 -> helper.processRemoveVehicle();
            case 10 -> helper.processQuit();


        }

    }
    private void init() {
            DealershipFileManager fileManager = new DealershipFileManager();
            this.dealership = fileManager.getDealership();
            this.displayHelper = new DisplayHelper(dealership);
        }

        private void displayVehicles (ArrayList < Vehicle > vehicles) {
            // print each vehicle
        }

        public void processAllVehiclesRequest () {
            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            displayVehicles(vehicles);
        }
    }
