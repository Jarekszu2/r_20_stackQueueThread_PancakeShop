package stackQueue.stackThreadPoolNalesnikarnia;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NalesnickCreator implements Runnable{

    private static final String[] SKLADNIKI = new String[] {
            "nutella",
            "jam",
            "banana",
            "strawberry",
            "raspberry",
            "cream",
            "sugar",
            "quark",
            "chicken",
            "steak",
            "cheese",
            "bolognese",
            "pomodore",
            "choco"
    };

    // przekazujemy referencje do obiektu, gdzie będzie wykorzystywany, żeby mógł skorzystać z metod tego obiektu
    private Nalesnickarnia nalesnickarnia;

    private String name;

    public NalesnickCreator(Nalesnickarnia nalesnickarnia, String name) {
        this.nalesnickarnia = nalesnickarnia;
        this.name = name;
    }

    @Override
    public void run() {
        while (nalesnickarnia.numberOfPancakes() <= 20){
            if (nalesnickarnia.numberOfPancakes() == 20){
                System.err.println("Store is full.");
                System.err.println(name + " - I have a break.");
                System.err.println("Type: 't' - take a pancake, 'q' - quit");
                System.out.println();
                break;
            }

            System.out.println("There are " + nalesnickarnia.numberOfPancakes() + " pancakes, less than 20. " + name + " - I do my work.");

            // losowo ustalam ilość składników naleśnika
            int numberOfIngredients = new Random().nextInt(6) + 1;

            // losuję składnik ze SKLADNIKI i dodaję do ingredients
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < numberOfIngredients; i++) {
                ingredients.add(SKLADNIKI[new Random().nextInt(SKLADNIKI.length)]);
            }

            // tworzę zadanego naleśnika i odkładam go na stos
            nalesnickarnia.createNalesnick(ingredients);

            // czas potrzebny na wykonanie 1-go naleśnika
            try {
                Thread.sleep(new Random().nextInt(5000) + 1);
            } catch (InterruptedException e) {
                System.out.println("Somebody interrupted my work.");
            }
        }
    }
}
