import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("odp.txt");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        TimerTask timerTask = new AutomaticSave();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*3000);

        while(true){
            Mieszkaniec mieszkaniec = new Mieszkaniec();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Podaj miasto: ");
            mieszkaniec.setMiasto(keyboard.nextLine());
            System.out.println("Podaj imie i nazwisko");
            mieszkaniec.setImieNazwisko(keyboard.nextLine());
            System.out.println("Podaj pesel");
            mieszkaniec.setPesel(keyboard.nextLine());
            Holder.mieszkancy.add(mieszkaniec);
        }
    }
}
