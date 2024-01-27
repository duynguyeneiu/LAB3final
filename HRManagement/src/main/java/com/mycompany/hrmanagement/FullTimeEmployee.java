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
public class FullTimeEmployee extends Employee {
    private double salary;
    public FullTimeEmployee() {
  
    }

    public FullTimeEmployee(double salary, String id, String name, int yearBirth, String address, String phone) {
        super(id, name, yearBirth, address, phone);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public void InputEmployee(){
        super.InputEmployee();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee Salary:");
        salary=sc.nextDouble();
    }
    @Override
    public void GetInfor() {
        System.out.println(getId()+"-"+getName()+"- Birth:"+getYearBirth()+"-Address:"+getAddress()+"-Phone:"+getPhone()+"-Salary:"+salary);
    }

    @Override
    public double GetPayment() {
     return salary;
    }
    
}