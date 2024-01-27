/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cdstore;

import java.util.Scanner;

/**
 *
 * @author LAPTOPVTC.VN
 */
public class CD {
    private String id;
    private String collection;
    private String type;
    private String title;
    private double price;
    private int year;

    public CD() {
    }

    public CD(String id, String collection, String type, String title, double price, int year) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void InputCD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CD id:");
        id = sc.nextLine();
        System.out.print("1:game 2:movie 3:music\n" + "Enter kind of collection:");
        int col = sc.nextInt();
        if (col == 1) {
            collection = "game";
        } else if (col == 2) {
            collection = "movie";
        } else if (col == 3) {
            collection = "music";
        }

        System.out.print("1:audio 2:video \n" + "Enter type of CD:");
        int typ = sc.nextInt();
        if (typ == 1) {
            type = "audio";
        } else if (typ == 2) {
            type = "video";
        }
        sc.nextLine();
        System.out.print("Enter CD title:");
        title = sc.nextLine();
        System.out.print("Enter CD price:");
        price = sc.nextDouble();
        System.out.print("Enter CD year:");
        year = sc.nextInt();
    }

    public void OutputCD() {
        System.out.println(id + "-" + collection + "-" + type + "-" + title + "-" + price + "-" + year);
    }

} 

