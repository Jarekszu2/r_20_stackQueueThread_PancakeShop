package stackQueue.stackNalesnikarnia;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Nalesnik {

    private List<String> skladniki;

    private LocalDateTime czasStworzenia;

    public Nalesnik(List<String> skladniki) {
        this.skladniki = skladniki;
        this.czasStworzenia = LocalDateTime.now();
    }
}
