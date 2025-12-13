package com.example.legocollection;

public class LegoSet {
    private int id;
    private String name;
    private String theme;
    private int pieces;
    private double price;

    public LegoSet(int id, String name, String theme, int pieces, double price) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.pieces = pieces;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public int getPieces() {
        return pieces;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LegoSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", pieces=" + pieces +
                ", price=" + price +
                '}';
    }
}
