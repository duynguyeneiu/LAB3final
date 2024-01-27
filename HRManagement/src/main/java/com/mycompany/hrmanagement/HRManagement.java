/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hrmanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author LAPTOPVTC.VN
 */
public class HRManagement {

    public static ArrayList<FullTimeEmployee> fullTime = new ArrayList<>();
    public static ArrayList<PartTimeEmployee> partTime = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FullTimeEmployee fu1= new FullTimeEmployee(40, "001", "Duy", 2003, "q1", "151515");
        fullTime.add(fu1);
        FullTimeEmployee fu2= new FullTimeEmployee(50, "002", "Hoang", 2005, "q12", "1717171");
        fullTime.add(fu2);
        FullTimeEmployee fu3= new FullTimeEmployee(50, "001", "Hung", 2005, "q2", "2345678");
        fullTime.add(fu3);
        PartTimeEmployee pa1= new PartTimeEmployee(10, 7, "001", "Huy", 1999, "q6", "2929292");
        partTime.add(pa1);
        PartTimeEmployee pa2= new PartTimeEmployee(10, 9, "005", "Minh", 2015, "q7", "567893");
        partTime.add(pa2);
        PartTimeEmployee pa3= new PartTimeEmployee(10, 9, "006", "Linh", 2015, "q2", "234567");
        partTime.add(pa3);
        int command;
        do {
            System.out.println("1. Add Full-time Employee \n"
                    + "2. Add Part-time Employee \n"
                    + "3. Show all Full-time Employee\n"
                    + "4. Show all Part-time Employee\n"
                    + "5. Show all Employee\n"
                    + "6. Search Employee by Id\n"
                    + "7. Delete Employee by Id\n"
                    + "8. Edit Employee information by Id\n"
                    + "9. Search Employee by payment\n"
                    + "10. Sort Full-time Employee and Part-Time employee in ascending order by age, payment.\n"
                    + "11. Exit \n"
                    + "Enter a command number:");
            command = sc.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Add Full-time Employee");
                    AddFullTimeEmployee(fullTime);
                    break;
                case 2:
                    System.out.println("Add Part-time Employee ");
                    AddPartTimeEmployee(partTime);
                    break;
                case 3:
                    System.out.println("Show all Full-time Employee");
                    ShowFullTimeEmployee(fullTime);
                    break;
                case 4:
                    System.out.println("Show all Part-time Employee");
                    ShowPartTimeEmployee(partTime);
                    break;
                case 5:
                    System.out.println("Show all Employee");
                    ShowAllEmployee(fullTime, partTime);
                    break;
                case 6:
                    System.out.println("Search Employee by Id");
                    SearchEmployee(fullTime, partTime);
                    break;
                case 7:
                    System.out.println("Delete Employee by Id");
                    DeleteEmployee(fullTime, partTime);
                    break;
                case 8:
                    System.out.println("Edit Employee information by Id");
                    EditEmployeeInformation(fullTime, partTime);
                    break;
                case 9:
                    System.out.println("Search Employee by payment");
                    SearchEmployeeByPayment(fullTime, partTime);
                    break;
                case 10:
                   
                    System.out.println("Sort Full-time Employee and Part-Time employee in ascending order by age, payment");
                    SortEmployeeByAgeAndPayment(fullTime, partTime);
                    break;
                case 11:
                    break;

            }
        } while (command != 11);
    }

    public static void AddFullTimeEmployee(ArrayList<FullTimeEmployee> fulltime) {
        FullTimeEmployee full = new FullTimeEmployee();
        full.InputEmployee();
        fulltime.add(full);
    }

    public static void AddPartTimeEmployee(ArrayList<PartTimeEmployee> partTime) {
        PartTimeEmployee part = new PartTimeEmployee();
        part.InputEmployee();
        partTime.add(part);
    }

    public static void ShowFullTimeEmployee(ArrayList<FullTimeEmployee> fullTime) {
        for (FullTimeEmployee full : fullTime) {
            full.GetInfor();
        }
    }

    public static void ShowPartTimeEmployee(ArrayList<PartTimeEmployee> partTime) {
        for (PartTimeEmployee part : partTime) {
            part.GetInfor();
        }
    }

    public static void ShowAllEmployee(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        for (FullTimeEmployee full : fullTime) {
            full.GetInfor();
        }
        for (PartTimeEmployee part : partTime) {
            part.GetInfor();
        }
    }

    public static void SearchEmployee(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        System.out.print("Enter Employee ID:");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < Math.max(fullTime.size(), partTime.size()); i++) {
            if (i < fullTime.size() && fullTime.get(i).getId().equals(id)) {
                fullTime.get(i).GetInfor();
                flag = true;
            }
            if (i < partTime.size() && partTime.get(i).getId().equals(id)) {
                partTime.get(i).GetInfor();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No employee with ID " + id + " was found");
        }
    }

    public static void DeleteEmployee(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        System.out.print("Enter Employee ID:");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < Math.max(fullTime.size(), partTime.size()); i++) {
            if (i < fullTime.size() && fullTime.get(i).getId().equals(id)) {
                fullTime.remove(i);
                flag = true;
            }
            if (i < partTime.size() && partTime.get(i).getId().equals(id)) {
                partTime.remove(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No employee with ID " + id + " was found");
        } else {
            System.out.println("Successfully removed employee with id " + id);
        }

    }

    public static void EditEmployeeInformation(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        System.out.print("Enter Employee ID:");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;
        for (FullTimeEmployee full : fullTime) {
            if (full.getId().equals(id)) {
                flag = true;
                int command;
                do {
                    System.out.println("1.Change Name\n"
                            + "2.Change Year of Birth\n"
                            + "3.Change Address\n"
                            + "4.Change Phone Number\n"
                            + "5.Change Salary\n"
                            + "6.Finish\n"
                            + "Enter a command:");
                    command = sc.nextInt();
                    switch (command) {
                        case 1:
                            System.out.print("Enter new Name:");
                            sc.nextLine();
                            String newName = sc.nextLine();
                            full.setName(newName);
                            break;
                        case 2:
                            System.out.print("Enter new Year of Birth:");
                            sc.nextLine();
                            int newYearBirth = sc.nextInt();
                            full.setYearBirth(newYearBirth);
                            break;
                        case 3:
                            System.out.print("Enter new Address:");
                            sc.nextLine();
                            String newAddress = sc.nextLine();
                            full.setAddress(newAddress);
                            break;
                        case 4:
                            System.out.print("Enter new Phone Number:");
                            sc.nextLine();
                            String newPhone = sc.nextLine();
                            full.setPhone(newPhone);
                            break;
                        case 5:
                            System.out.print("Enter new Salary:");
                            sc.nextLine();
                            double newSalary = sc.nextDouble();
                            full.setSalary(newSalary);
                            break;
                        case 6:
                            break;
                    }
                } while (command != 6);
            }

        }
        for (PartTimeEmployee part : partTime) {
            if (part.getId().equals(id)) {
                flag = true;
                int command;
                do {
                    System.out.println("1.Change Name\n"
                            + "2.Change Year of Birth\n"
                            + "3.Change Address\n"
                            + "4.Change Phone Number\n"
                            + "5.Change Working Hour\n"
                            + "6.Change Pay Rate\n"
                            + "7. Finish"
                            + "Enter a command:");
                    command = sc.nextInt();
                    switch (command) {
                        case 1:
                            System.out.print("Enter new Name:");
                            sc.nextLine();
                            String newName = sc.nextLine();
                            part.setName(newName);
                            break;
                        case 2:
                            System.out.print("Enter new Year of Birth:");
                            sc.nextLine();
                            int newYearBirth = sc.nextInt();
                            part.setYearBirth(newYearBirth);
                            break;
                        case 3:
                            System.out.print("Enter new Address:");
                            sc.nextLine();
                            String newAddress = sc.nextLine();
                            part.setAddress(newAddress);
                            break;
                        case 4:
                            System.out.print("Enter new Phone Number:");
                            sc.nextLine();
                            String newPhone = sc.nextLine();
                            part.setPhone(newPhone);
                            break;
                        case 5:
                            System.out.print("Enter new Working Hour:");
                            sc.nextLine();
                            double newWorkingHour = sc.nextDouble();
                            part.setWorkingHour(newWorkingHour);
                            break;
                        case 6:
                            System.out.print("Enter new Pay Rate:");
                            sc.nextLine();
                            double newPayRate = sc.nextDouble();
                            part.setPayRate(newPayRate);
                            break;
                        case 7:
                            break;
                    }
                } while (command != 7);
            }
        }

        if (!flag) {
            System.out.println("No employee with ID " + id + " was found");
        } else {
            System.out.println("Successfully edited employee's information with id " + id);
        }

    }

    public static void SearchEmployeeByPayment(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        System.out.println("Enter a range of payment:");
        System.out.print("From:");
        double from = sc.nextDouble();
        System.out.print("To:");
        double to = sc.nextDouble();
        boolean flag = false;
        for (FullTimeEmployee full : fullTime) {
            if (full.GetPayment() >= from && full.GetPayment() <= to) {
                flag = true;
                full.GetInfor();
            }
        }
        for (PartTimeEmployee part : partTime) {
            if (part.GetPayment() >= from && part.GetPayment() <= to) {
                flag = true;
                part.GetInfor();
            }
        }
        if (!flag) {
            System.out.println("There are not any employee with payment in the range");
        }
    }

    public static void SortEmployeeByAgeAndPayment(ArrayList<FullTimeEmployee> fullTime, ArrayList<PartTimeEmployee> partTime) {
        Comparator<FullTimeEmployee> compare = new Comparator<FullTimeEmployee>() {
            @Override
            public int compare(FullTimeEmployee o1, FullTimeEmployee o2) {
                if (o1.getYearBirth() - o2.getYearBirth() > 0) {
                    return -1;
                } else if (o1.getYearBirth() - o2.getYearBirth() == 0) {
                    if (o1.GetPayment() - o2.GetPayment() > 0) {
                        return 1;
                    } else if (o1.getYearBirth() - o2.getYearBirth() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }
            }

        };
        Comparator<PartTimeEmployee> comparepart = new Comparator<PartTimeEmployee>() {
            @Override
            public int compare(PartTimeEmployee o1, PartTimeEmployee o2) {
                if (o1.getYearBirth() - o2.getYearBirth() > 0) {
                    return -1;
                } else if (o1.getYearBirth() - o2.getYearBirth() == 0) {
                    if (o1.GetPayment() - o2.GetPayment() > 0) {
                        return 1;
                    } else if (o1.getYearBirth() - o2.getYearBirth() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }
            }
        };
        fullTime.sort(compare);
        partTime.sort(comparepart);
        System.out.println("Fulltime Employee in ascending order by age");
        for (FullTimeEmployee full : fullTime) {
            full.GetInfor();
        }
        System.out.println("Parttime Employee in ascending order by age");
        for (PartTimeEmployee part : partTime) {
            part.GetInfor();
        }
    }

}
