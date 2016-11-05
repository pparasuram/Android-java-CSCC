package com.prakash.exam_02_2;

/**
 * Created by PARASUP on 11/1/2016.
 */
class Building {
    String address;

    Building(String address) {
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Address:" + address);
    }
}
class House extends Building {
    private Integer noResidents;

    public House(Integer residents, String address) {
        super(address);
        noResidents = residents;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Residents: " + noResidents);
    }
}


public class Main {
    public static void main(String[] args) {
        Building building = new Building("123 Main St.");
        building.displayInfo();
        House house = new House(4, "456 High St.");
        house.displayInfo();
    }
}
