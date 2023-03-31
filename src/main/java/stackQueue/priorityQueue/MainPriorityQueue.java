package stackQueue.priorityQueue;

import stackQueue.Pancake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MainPriorityQueue {
    public static void main(String[] args) {

        System.out.println();

        // list - priorityQueue - FIFO

        Pancake quark = new Pancake("Quark World", new ArrayList<>(Arrays.asList("Quark", "Sugar")), 10.50);
        Pancake peanutButter = new Pancake("Peanut Butter World", new ArrayList<>(Arrays.asList("Peanut butter", "Sugar")), 12.10);
        Pancake cream = new Pancake("Cream World", new ArrayList<>(Arrays.asList("Cream", "Sugar")), 14.20);
        Pancake choco = new Pancake("Choco World", new ArrayList<>(Arrays.asList("Chocolate", "Sugar")), 16.10);

        // kolekcja samosortująca (bardzo szybko) - nie trzeba sortować, ponieważ ma zoptymalizowane umieszczanie elementów w kolekcji
//        PriorityQueue<Pancake> pancakePriorityQueue = new PriorityQueue<Pancake>(); // jak nie określimy zasady porównywalności elementów w kolejce to będzie rzucany exception
        PriorityQueue<Pancake> pancakePriorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Pancake::getPrice).reversed());
        pancakePriorityQueue.add(quark);
        pancakePriorityQueue.add(peanutButter);
        pancakePriorityQueue.add(cream);
        pancakePriorityQueue.add(choco);

        for (Pancake pancake : pancakePriorityQueue) {
            System.out.println(pancake);
        }

        System.out.println();
        System.out.println("Iteracja ok.");

        // priority priorityQueue - nie da się wyciagać elementów ze środka kolekcja ani jej przeiterować, żeby była zachowana rzeczywista kolejność, ponieważ elementy nie są przechowywane w kolejności, w której będą wyciągane
        // dlatego jeżeli chcemy wyciągać to robimy pętlę
//        while (!pancakePriorityQueue.isEmpty()) {
//            System.out.println(pancakePriorityQueue.poll());
//        }

        System.out.println();
        System.out.println("Zabieramy jednego.");
        Pancake theFirst = pancakePriorityQueue.poll();
        System.out.println(theFirst);
//        System.out.println(pancakePriorityQueue.poll());

        System.out.println();
        System.out.println("Jeszcze raz.");

        while (!pancakePriorityQueue.isEmpty()) {
            System.out.println(pancakePriorityQueue.poll());
        }
    }
}
