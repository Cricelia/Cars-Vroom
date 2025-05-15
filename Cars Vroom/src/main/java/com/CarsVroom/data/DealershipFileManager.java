package com.CarsVroom.data;

import com.CarsVroom.model.Dealership;
import com.CarsVroom.model.Vehicle;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        File file = new File("src/main/java/com/CarsVroom/data/inventory.csv");
        Dealership dealership = null;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = bf.readLine();
            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);

            }
            String vehicleLine;
            while ((vehicleLine = bf.readLine()) != null) {

                String[] vehicleParts = vehicleLine.split("\\|");
                if (vehicleParts.length == 8) {
                    int vin = Integer.parseInt(vehicleParts[0]);
                    int year = Integer.parseInt(vehicleParts[1]);
                    String make = vehicleParts[2];
                    String model = vehicleParts[3];
                    String vehicleType = vehicleParts[4];
                    String color = vehicleParts[5];
                    int odometer = Integer.parseInt(vehicleParts[6]);
                    double price = Double.parseDouble(vehicleParts[7]);


                    Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    if(dealership != null) {
                        dealership.addVehicle(v);
                    }

                } else {
                    System.out.println("Invalid line format - " + vehicleLine);
                }
            }
            bf.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format - " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

        public void saveDealership(Dealership dealership) {
        // left blank for now
    }
}
