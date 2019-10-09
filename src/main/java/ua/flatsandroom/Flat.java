package ua.flatsandroom;

public class Flat {
    private String area;
    private String address;
    private double square;
    private int numberOfRooms;
    private double price;

    public Flat() {
    }

    public Flat(String area, String address, double square, int numberOfRooms, double price) {
        this.area = area;
        this.address = address;
        this.square = square;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                '}';
    }
}
