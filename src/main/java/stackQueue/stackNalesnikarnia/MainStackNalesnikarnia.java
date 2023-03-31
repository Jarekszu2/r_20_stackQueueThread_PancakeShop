package stackQueue.stackNalesnikarnia;

import stackQueue.NoPancakeException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class MainStackNalesnikarnia {
    public static void main(String[] args) {

        System.out.println();

        Nalesnikarnia nalesnikarnia = new Nalesnikarnia();

        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        do {
            System.out.println();
            System.out.println("Podaj komendę: dodaj, size, pobierz, quit?");
            String linia = scanner.nextLine();

            if (linia.equalsIgnoreCase("dodaj")) {

                System.out.println("Podaj składniki. Każde nowe slowo oddzielone spacją będzie nowym składnikiem.");
                String linia2 = scanner.nextLine();

                String[] skladniki = linia2.split(" ");

                System.out.println(Arrays.toString(skladniki));

                nalesnikarnia.stworzNalesnika(Arrays.asList(skladniki));

            } else if (linia.equalsIgnoreCase("size")) {
                System.out.println("Ilość naleśników: " + nalesnikarnia.getNalesniks().size());
            } else if (linia.equalsIgnoreCase("pobierz")) {

                try {
                    Nalesnik nalesnik = nalesnikarnia.pobierzNalesnikaZeStosu();
                    System.out.println("Ilość naleśników: " + nalesnikarnia.getNalesniks().size());
                    System.out.println("Pobrałeś: " + nalesnik);
                    // jeśli naleśnik ma więcej niż 10 min to jet zimny
                    if (Duration.between(nalesnik.getCzasStworzenia(), LocalDateTime.now()).getSeconds() > 30) {
                        System.out.println("Zimny :(");
                    }
                } catch (NoPancakeException e) {
                    e.printStackTrace();
                }
            } else if (linia.equalsIgnoreCase("quit")) {
                isWorking = false;
            }
        } while (isWorking);
    }
}
