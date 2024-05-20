package main;

import java.util.Scanner;

import eddll.DoubleLinearList;
import eddll.Node;

public class Main {
    public static void main(String[] args) {
        DoubleLinearList list = new DoubleLinearList();

        Scanner in = new Scanner(System.in);

        int id = 0;

        while (id >= 0) {
            System.out.print("informations: ");
            id = in.nextInt();

            if (id < 0) {
                break;
            }

            list.add(new Node(id + "", new Integer(id)));
            list.append(new Node(id + "", new Integer(id)));
        }
        in.close();
        list.show();

        System.out.println("\nremoving with remove...\n");
        list.remove();
        list.show();

        System.out.println("\nremoving with pop...\n");
        list.pop();
        list.show();
    }
}
