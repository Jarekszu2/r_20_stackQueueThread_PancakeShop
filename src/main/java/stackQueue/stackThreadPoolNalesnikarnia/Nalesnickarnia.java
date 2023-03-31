package stackQueue.stackThreadPoolNalesnikarnia;

import lombok.Data;
import stackQueue.NoPancakeException;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Nalesnickarnia {

    // pula wątkąw reprezentuje 3 pracowników
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private NalesnickCreator[] creators;

    private Stack<Nalesnick> nalesnickStack = new Stack<>();

    private boolean flag = true;

    // tworzę pusty konstruktor i startuję w nim wszystkie wątki
    public Nalesnickarnia() {
        creators = new NalesnickCreator[3]; // stworzona jest tablica 3 x null
        // w pętli wypełniamy tablicę
        for (int i = 0; i < 2; i++) {
            // w komórkę tablicy wstawiam nowy element (kreatora), który ma pracować dla tego obiektu (naleśnikarni), który go stworzył (this)
            // jestem wewnątrz naleśnikarni i ją przekazuję do kreatora (this)
            creators[i] = new NalesnickCreator(this, "Nr " + (i +1));
            executorService.submit(creators[i]);
        }
        // dodaję jeden element "z ręki"
        NalesnickCreator nalesnickCreator_2 = new NalesnickCreator(this, "Ziutek");
        creators[2] = nalesnickCreator_2;
        executorService.submit(creators[2]);

        SomehowNewThread_Zegar somehowNewThread_zegar = new SomehowNewThread_Zegar(this, "Maniek");
        executorService.submit(somehowNewThread_zegar);
    }

    public void createNalesnick(List<String> skladniki) {
        System.out.println("Creating of a new pancake.");
        System.out.println("Type: 't' - take a pancake, 'q' - quit");
        System.out.println();
        nalesnickStack.push(new Nalesnick(skladniki));
    }

    public Nalesnick takeNalesnickFromTheStack() throws NoPancakeException {
        if (nalesnickStack.empty()) {
            throw new NoPancakeException("Stos jest pusty. Nie ma naleśników.");
        }
        return nalesnickStack.pop();
    }

    public int numberOfPancakes(){
        return nalesnickStack.size();
    }
}
