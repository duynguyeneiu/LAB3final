/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cdstore;

/**
 *
 * @author LAPTOPVTC.VN
 */
import java.util.*;
import java.io.*;

public class CDStore {

    public static ArrayList<CD> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int menu;

        CD a = new CD("001", "movie", "video", "duy and his friends", 70, 2003);
        CD b = new CD("002", "game", "video", "duy", 50, 2023);
        list.add(a);
        list.add(b);
        do {
            System.out.print("1. Add CD \n"
                    + "2. Search CD by CD title\n"
                    + "3. Search CDs by collection (game/movie/music)\n"
                    + "4. Search CDs by type (audio/video)\n"
                    + "5. Delete CD by CD Id\n"
                    + "6. Edit CD information by Id\n"
                    + "7. Display all CDs\n"
                    + "8. Sort the CD list ascending by year of release\n"
                    + "9. Exit \n"
                    + "** Enter command number:");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    AddCD(list);
                    break;
                case 2:
                    SearchByTitle(list);
                    break;
                case 3:
                    SearchByCollection(list);
                    break;
                case 4:
                    SearchByType(list);
                    break;
                case 5:
                    DeleteCDByID(list);
                    break;
                case 6:
                    EditCDInformationByID(list);
                    break;
                case 7:
                    DisplayAllCD(list);
                    break;
                case 8:
                    SortCDAscendingByYear(list);
                    break;
                case 9:

                    break;

            }
        } while (menu != 9);
    }

    public static void AddCD(ArrayList<CD> list) {
        System.out.println("Add CD");
        CD cd = new CD();
        cd.InputCD();
        list.add(cd);
    }

    public static void SearchByTitle(ArrayList<CD> list) {
        System.out.println("Search CD by CD title");
        System.out.print("Enter a title:");
        sc.nextLine();
        String name = sc.nextLine();
        boolean flag = false;
        for (CD d : list) {
            if (d.getTitle().equals(name)) {
                flag = true;
                d.OutputCD();
            }
        }
        if (!flag) {
            System.out.println("There is not " + name + " CD");
        }
    }

    public static void SearchByCollection(ArrayList<CD> list) {
        System.out.println("Search CDs by CD collection");
        System.out.print("Enter a collcetion:");
        sc.nextLine();
        String coll = sc.nextLine();
        boolean flag = false;
        for (CD d : list) {
            if (d.getCollection().equals(coll)) {
                flag = true;
                d.OutputCD();
            }
        }
        if (!flag) {
            System.out.println("There are not any " + coll + " CDs");
        }
    }

    public static void SearchByType(ArrayList<CD> list) {
        System.out.println("Search CDs by CD type");
        System.out.print("Enter a type:");
        sc.nextLine();
        String type = sc.nextLine();
        boolean flag = false;
        for (CD d : list) {
            if (d.getType().equals(type)) {
                flag = true;
                d.OutputCD();
            }
        }
        if (!flag) {
            System.out.println("There are not " + type + " CDs");
        }
    }

    public static void DeleteCDByID(ArrayList<CD> list) {
        System.out.println("Delete CD by CD's id");
        System.out.print("Enter an ID:");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;
        for (CD d : list) {
            if (d.getId().equals(id)) {
                flag = true;
                list.remove(d);
                System.out.println("Successfully remove CD with ID:" + id);
            }
        }
        if (!flag) {
            System.out.println("There is not " + id + " CD");
        }
    }

    public static void EditCDInformationByID(ArrayList<CD> list) {
        System.out.println("Change CD's information by CD ID");
        System.out.print("Enter an ID:");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;
        for (CD d : list) {
            if (d.getId().equals(id)) {
                flag = true;
                int edi;
                do {
                    System.out.print(
                            "1:Change Collection\n"
                            + "2:Change Type\n"
                            + "3:Change Title\n"
                            + "4:Change Price\n"
                            + "5:Change Year\n"
                            + "6:Finish Editing\n"
                            + "Enter comand:");
                    edi = sc.nextInt();
                    switch (edi) {
                        case 1:
                            System.out.print("Enter new Collection:");
                            sc.nextLine();
                            String newCollection = sc.nextLine();
                            d.setCollection(newCollection);
                            break;
                        case 2:
                            System.out.print("Enter new Type:");
                            sc.nextLine();
                            String newType = sc.nextLine();
                            d.setType(newType);
                            break;
                        case 3:
                            System.out.print("Enter new Title:");
                            sc.nextLine();
                            String newTitle = sc.nextLine();
                            d.setTitle(newTitle);
                            break;
                        case 4:
                            System.out.print("Enter new Price:");
                            sc.nextLine();
                            Double newPrice = sc.nextDouble();
                            d.setPrice(newPrice);
                            break;
                        case 5:
                            System.out.print("Enter new Year:");
                            sc.nextLine();
                            int newYear = sc.nextInt();
                            d.setYear(newYear);
                            break;
                        case 6:
                            break;

                    }
                } while (edi != 6);

            }
        }
        if (!flag) {
            System.out.println("There is not " + id + " CD");
        } else {
            System.out.println("Successfully edited");
        }
    }

    public static void DisplayAllCD(ArrayList<CD> list) {
        System.out.println("Display all CDs");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).OutputCD();
        }
    }

    public static void SortCDAscendingByYear(ArrayList<CD> list) {
        Comparator<CD> compare = new Comparator<CD>() {
            public int compare(CD a, CD b) {
                if (a.getYear() - b.getYear() > 0) {
                    return 1;
                } else if (a.getYear() - b.getYear() == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        list.sort(compare);
        System.out.println("Display all CDs by ascending year");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).OutputCD();
        }
    }

}