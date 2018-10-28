import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class AutomaticSave extends TimerTask {

    @Override
    public void run() {
        for(Mieszkaniec mieszkaniec: Holder.mieszkancy){
            appendStrToFile("odp.txt", mieszkaniec.getMiasto()+";");
            appendStrToFile("odp.txt", mieszkaniec.getImieNazwisko()+";");
            appendStrToFile("odp.txt", mieszkaniec.getPesel()+";"+System.lineSeparator());
        }
        Holder.mieszkancy = new ArrayList<>();
    }

    public static void appendStrToFile(String fileName,
                                       String str)
    {
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }
}
