package stackQueue.stackThreadPoolNalesnikarnia;

import stackQueue.NoPancakeException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainStackThreadPoolNalesnickarnia {
    public static void main(String[] args) {
        System.out.println();

        Nalesnickarnia nalesnickarnia = new Nalesnickarnia();

        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        do {
            System.out.println();
//            System.out.println("Type: 't' - take a pancake, 'q' - quit");

            String linia = scanner.nextLine();


            if (linia.equalsIgnoreCase("t")){
                try {
                    Nalesnick nalesnick = nalesnickarnia.takeNalesnickFromTheStack();
                    System.err.println("You have taken: " + nalesnick);
                    if (Duration.between(nalesnick.getDateOfCreation(), LocalDateTime.now()).getSeconds() > 30) {
                        System.err.println("Pancake is cold!");
                    }
                    System.err.println("Number of pancakes: " + nalesnickarnia.numberOfPancakes());
                    System.err.println("Type: 't' - take a pancake, 'q' - quit");
                } catch (NoPancakeException e) {
                    System.err.println("There are no pancakes! We are hungry!!!");
                    System.err.println("Type: 't' - take a pancake, 'q' - quit");
                }
            } else if (linia.equalsIgnoreCase("q")){
                System.err.println("Quit.");
                isWorking = false;
                nalesnickarnia.setFlag(false);
                nalesnickarnia.getExecutorService().shutdown();
            }
        } while (isWorking);
    }
}
