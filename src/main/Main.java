package main;

import java.util.Scanner;

import eddll.DoubleLinearList;
import eddll.Node;
import eddll.MergeDoubleLinearList;

public class Main {
    public static void main(String[] args) {
        DoubleLinearList list = new DoubleLinearList();

        Scanner in = new Scanner(System.in);

        double id = 0;

        while (true) {

            System.out.print("informations: ");
            id = in.nextDouble();

            if (id < 0) {
                break;
            }

            list.append(new Node(id + "", new Double(id)));
        }

        Object[] array = list.invArray();

        for(int indx = 0; indx < array.length; indx++){
            System.out.println(array[indx]);
        }

        System.out.println("\nItens list:");
        list.showAsc();

        in.close();
    }
}
