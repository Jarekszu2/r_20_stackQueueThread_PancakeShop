package stackQueue.stackThreadPoolNalesnikarnia;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Nalesnick {

    private List<String> skladniki;

    private LocalDateTime dateOfCreation;

    public Nalesnick(List<String> skladniki) {
        this.skladniki = skladniki;
        this.dateOfCreation = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Nalesnick{" +
                "skladniki=" + skladniki +
                '}';
    }
}
