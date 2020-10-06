package Country_69loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries meac = new ManageEastAsiaCountries();
        List<EastAsiaCountries> list = new ArrayList<EastAsiaCountries>();

        while (true) {
            meac.printMenu();
            int n = meac.getChoice();
            switch (n) {
                case 1:
                    meac.add(list);
                    break;
                case 2:
                    meac.display(list);
                    break;
                case 3:
                    meac.search(list);
                    break;
                case 4:
                    meac.sortbyName(list);
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }

}
