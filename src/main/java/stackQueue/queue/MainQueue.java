package stackQueue.queue;

import stackQueue.Pancake;

import java.util.*;

public class MainQueue {
    public static void main(String[] args) {

        System.out.println();

        Pancake quark2 = new Pancake("Quark World", new ArrayList<>(Arrays.asList("Quark", "Sugar", "milk")), 10.50);
        Pancake peanutButter2 = new Pancake("Peanut Butter World", new ArrayList<>(Arrays.asList("Peanut butter", "Sugar", "milk")), 12.10);
        Pancake cream2 = new Pancake("Cream World", new ArrayList<>(Arrays.asList("Cream", "Sugar", "milk")), 14.20);
        Pancake choco2 = new Pancake("Choco World", new ArrayList<>(Arrays.asList("Chocolate", "Sugar", "milk")), 16.10);

        LinkedList<Pancake> pancakeQueue = new LinkedList<>(); // kolejka nie posiada implementacji jakiejs specjalnej klasy, ponieważ LinkedList to kolejka; łatwo coś dodać na początek i na koniec
        // metody:
        // pop
        // put
        // push - wpycha element na początek kolejki, equivalent addFirs
        // offer

        pancakeQueue.addLast(quark2);
        pancakeQueue.addLast(peanutButter2);
        pancakeQueue.addLast(cream2);
        pancakeQueue.addLast(choco2);

        for (Pancake pancake : pancakeQueue) {
            System.out.println(pancake);
        }

        System.out.println();
        Pancake jam = new Pancake("Jam World", new ArrayList<>(Arrays.asList("Jam", "Sugar", "milk")), 16.10);

        pancakeQueue.addFirst(jam);

        for (Pancake pancake : pancakeQueue) {
            System.out.println(pancake);
        }

        System.out.println();
        System.out.println();

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        integerList.forEach(System.out::println);

        System.out.println();
        integerList.add(0, 0);

        integerList.forEach(System.out::println);

    }
}
