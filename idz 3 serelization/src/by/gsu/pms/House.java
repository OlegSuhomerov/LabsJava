package by.gsu.pms;

public class House {
    private int id;
    private int apartmentNumber;
    private int area;
    private int floor;
    private int numberRooms;
    private String street;
    private int lifetime;
    public TypeBuildings typeBuildings;

    public TypeBuildings getTypeBuildings() {
        return typeBuildings;
    }

    public void setTypeBuildings(TypeBuildings typeBuildings) {
        this.typeBuildings = typeBuildings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public String getstreet() {
        return street;
    }

    public void setstreet(String street) {
        street = street;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public House(){

    }

    @Override
    public String toString() {
        return id + ";" + apartmentNumber + ";" + area + ";" + floor + ";" + numberRooms + ";'" + street  +
                ";" + lifetime + ";" + typeBuildings;
    }

    public House(int id, int apartmentNumber, int area, int floor, int numberRooms, String street, int lifetime, TypeBuildings typeBuildings){
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberRooms = numberRooms;
        this.street = street;
        this.lifetime = lifetime;
        this.typeBuildings = typeBuildings;
    }

    public House(int id, int apartmentNumber, int area, int floor, int numberRooms, String street, int lifetime) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberRooms = numberRooms;
        this.street = street;
        this.lifetime = lifetime;
    }
}
