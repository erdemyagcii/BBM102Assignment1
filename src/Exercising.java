import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercising {
    People person;
    Sport sport;
    int sportDuration;
    Exercising(People person, Sport sport, int sportDuration){
        this.person = person;
        this.sport = sport;
        this.sportDuration = sportDuration;
    }

    void Exercise() throws IOException {
        File monitoringTxt = new File("monitoring.txt");
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, true);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        this.person.setBurnedCalorie((this.person.getBurnedCalorie()) + ((this.sport.getCalorieBurned() * this.sportDuration) / 60));
        People.people2.add(this.person);
        bWMonitoringTxt.write(this.person.getPersonID() + "\t" + "has\tburned\t" + ((this.sport.getCalorieBurned() * this.sportDuration) / 60) + "kcal\tthanks to\t" + this.sport.getNameOfSport() + "\n");
        bWMonitoringTxt.write("***************\n");
        bWMonitoringTxt.close();
    }
}
