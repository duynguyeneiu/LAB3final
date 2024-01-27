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
public class PartTimeEmployee extends Employee {
  private double workingHour;
private double payRate;

    public PartTimeEmployee() {
       
    }

    public PartTimeEmployee(double workingHour, double payRate, String id, String name, int yearBirth, String address, String phone) {
        super(id, name, yearBirth, address, phone);
        this.workingHour = workingHour;
        this.payRate = payRate;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(double workingHour) {
        this.workingHour = workingHour;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    @Override
    public void InputEmployee() {
        super.InputEmployee();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee Working Hour:");
        workingHour=sc.nextDouble();
         System.out.print("Enter Employee Pay Rate:");
        payRate=sc.nextDouble();
    }
    
    @Override
    public void GetInfor() {
         System.out.println(getId()+"-"+getName()+"- Birth:"+getYearBirth()+"-Address:"+getAddress()+"-Phone:"+getPhone()+"-Working Hour:"+workingHour+"-Pay Rate:"+payRate);
    }

    @Override
    public double GetPayment() {
        return payRate*workingHour;
    }
    
}