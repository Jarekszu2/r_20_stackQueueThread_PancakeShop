package stackQueue.stackNalesnikarnia;

import lombok.Data;
import stackQueue.NoPancakeException;

import java.util.List;
import java.util.Stack;

@Data
public class Nalesnikarnia {

    private Stack<Nalesnik> nalesniks = new Stack<>();

    public void stworzNalesnika(List<String> skladniki) {
        Nalesnik nalesnik = new Nalesnik(skladniki);
        nalesniks.add(nalesnik);
        System.out.println("Ilość naleśników: " + nalesniks.size());
    }

    public Nalesnik pobierzNalesnikaZeStosu() throws NoPancakeException {
        if (nalesniks.empty()) {
            throw new NoPancakeException("Stos jest pusty. Nie ma naleśników.");
        }
        return nalesniks.pop();
    }
}
