package stackQueue.stack;

import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {

        System.out.println();

        // stack - LIFO
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        System.out.println();
        integerStack.forEach(System.out::println);

        integerStack.add(2, 5);

        System.out.println();
        while (!integerStack.empty()) {
            // dopóki nie jest pusty (stos)
            // wypisz następny element i ściagnij go ze stosu
            System.out.println(integerStack.pop());
        }
    }
}
