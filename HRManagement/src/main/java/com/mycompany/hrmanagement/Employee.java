/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrmanagement;

import java.util.Scanner;

/**
 *
 * @author LAPTOPVTC.VN
 */
public abstract class Employee {
    private String id;
    private String name;
    private int yearBirth;
    private String address;
    private String phone;

    public Employee() {
    }

    public Employee(String id, String name, int yearBirth, String address, String phone) {
        this.id = id;
        this.name = name;
        this.yearBirth = yearBirth;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void InputEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id:");
        id = sc.nextLine();
        System.out.print("Enter Employee Name:");
        name = sc.nextLine();
        sc.nextLine();
        System.out.print("Enter Employee Years Of Birth:");
        yearBirth = sc.nextInt();
        System.out.print("Enter Employee Address:");
        address = sc.nextLine();
        System.out.print("Enter Employee Phone Number:");
        phone = sc.nextLine();

    }
//  System.out.println(id + "-" + name + "-" + yearBirth + "-" + address + "-" + phone);
    public abstract void GetInfor() ;
    public abstract double GetPayment();
    
      
    
}

