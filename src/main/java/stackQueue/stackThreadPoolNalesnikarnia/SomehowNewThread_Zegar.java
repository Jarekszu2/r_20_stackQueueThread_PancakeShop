package stackQueue.stackThreadPoolNalesnikarnia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
public class SomehowNewThread_Zegar implements Runnable {

    private Nalesnickarnia nalesnickarnia;

    private String name;

    @Override
    public void run() {
        while (nalesnickarnia.isFlag()) {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime localDateTimeLater = localDateTime.plusMinutes(30);

            System.out.println();
            System.err.println("Speaking " + name + ":");
            System.err.println("This is the exact time: " + localDateTime.format(dateTimeFormatter) + " or " + localDateTimeLater.format(dateTimeFormatter) + ".");
            System.out.println();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.err.println("Wake up!");
            }
        }
    }
}
