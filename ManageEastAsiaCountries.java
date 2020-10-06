/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Country_69loc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;

public class ManageEastAsiaCountries {


    //check code
    public String getCode(List<EastAsiaCountries> list) {
        Scanner sc = new Scanner(System.in);
        String countryCode;
        do {
            boolean exist = false;
            System.out.print("Enter country Code: ");
            countryCode = sc.nextLine();
            if (countryCode.trim().length() == 0) {
                continue;
            }
            for (EastAsiaCountries a : list) {
                if (a.getCountryCode().equalsIgnoreCase(countryCode)) {
                    exist = true;
                }
            }
            if (exist == true) {
                continue;
            } else {
                break;
            }
        } while (true);
        return countryCode;

    }

    //check string
    public String getContryName() {
        Scanner sc = new Scanner(System.in);
        String countryName = "";
        do {
            System.out.print("Enter country name: ");
            countryName = sc.nextLine();
            if (countryName.trim().length() == 0) {
                continue;
            }
            break;
        } while (true);
        return countryName;
    }

    //check string
    public String getTerrain() {
        Scanner sc = new Scanner(System.in);
        String terrian = "";
        do {
            System.out.print("Enter terrain: ");
            terrian = sc.nextLine();
            if (terrian.trim().length() == 0) {
                continue;
            }
            break;
        } while (true);
        return terrian;
    }

    //get double
    public double getArea() {
        double n = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter country Area : ");
                n = Double.parseDouble(sc.nextLine());
                if (n < 0) {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Oop ! Enter again: ");
                continue;
            }
            break;
        } while (true);
        return n;
    }

    //check nhap tu 1 - 5
    public int getChoice() {
        int n = -1;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter your choice: ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0 || n > 5) {
                    System.out.print("Input choice 1-5: ");
                }
            } catch (Exception e) {
                System.out.println("Oop ! Enter again: ");
                continue;
            }
            break;
        } while (true);
        return n;
    }

    public void printMenu() {
        System.out.println("\n1.Enter the information for 11 countries in Southeast Asia");
        System.out.println("2. Display already information.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
    }

    public void add(List<EastAsiaCountries> list) {
        System.out.println("1.Enter the information for 11 countries in Southeast Asia:");
        String code = getCode(list);
        String name = getContryName();
        double area = getArea();
        String terrain = getTerrain();
        ////moi thu deu ok
        EastAsiaCountries asia = new EastAsiaCountries(code, name, area, terrain);
        list.add(asia);
    }

    public void display(List<EastAsiaCountries> list) {
        double total =0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            total = total + list.get(i).getTotalArea();
        }
        System.out.println("Total: "+total);
    }

    public void search(List<EastAsiaCountries> list) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        String countryName = getContryName(); //nhap country can tim

        for (int i = 0; i < list.size(); i++) {
            //if countryname = 1 countryname bat ki trong list
            if (countryName.equalsIgnoreCase(list.get(i).getCountryName())) {
                System.out.println("found: ");
                System.out.println(list.get(i).toString());
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Not found: ");
        }

    }

    public void sortbyName(List<EastAsiaCountries> list) {
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });

        //sap xep list tang dan theo countryName  //anphabet --> lao, vietnam, cam
        //---> cam, lao , vietnam
        System.out.println("Assending: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

}
