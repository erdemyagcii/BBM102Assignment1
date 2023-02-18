import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Commands {
    static ArrayList<String[]> commands = new ArrayList<>();
    static void ownMethod() throws IOException {
        File commandTxt = new File(Main.path);
        FileReader rCommandTxt = new FileReader(commandTxt);
        BufferedReader bRCommandTxt = new BufferedReader(rCommandTxt);
        String line;
        String[] lineList;
        while ((line = bRCommandTxt.readLine()) != null) {
            lineList = line.split("\t");
            commands.add(lineList);
        }
        bRCommandTxt.close();
    }
}
