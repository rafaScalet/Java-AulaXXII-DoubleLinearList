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

            list.append(new Node(id + "", new Integer(id)));
        }
        
        System.out.println("\nItens list:");
        list.show();

        System.out.print("\nType a item for delete:");
        list.delete(in.nextInt());

        System.out.println("\nUpdated list:");
        list.show();

        // System.out.print("\nItem for delete: ");
        // list.delete(in.nextInt());

        // in.close();
        // list.show();

        in.close();
    }
}
