import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sport {
    private String sportID;
    private String nameOfSport;
    private int calorieBurned;
    static ArrayList<Sport> sports = new ArrayList<>();

    Sport(String sportID,  String nameOfSport, int calorieBurned){
        this.sportID = sportID;
        this.nameOfSport = nameOfSport;
        this.calorieBurned = calorieBurned;
    }

    static void ownMethod() throws IOException {
        File sportTxt = new File("sport.txt");
        FileReader rSportTxt = new FileReader(sportTxt);
        BufferedReader bRSportTxt = new BufferedReader(rSportTxt);
        String line;
        String[] lineList;
        while((line = bRSportTxt.readLine()) != null){
            lineList = line.split("\t");
            String sportID = lineList[0];
            String nameOfSport = lineList[1];
            int calorieBurned = Integer.parseInt(lineList[2]);
            Sport.sports.add( new Sport(sportID, nameOfSport, calorieBurned));
        }
        bRSportTxt.close();
    }

    public String getSportID() {
        return sportID;
    }
    public String getNameOfSport() {
        return nameOfSport;
    }
    public int getCalorieBurned() {
        return calorieBurned;
    }

}
