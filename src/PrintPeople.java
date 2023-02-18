import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintPeople {
    People person;
    PrintPeople(People person){
        this.person = person;
    }

    void PrintPerson() throws IOException {
        File monitoringTxt = new File("monitoring.txt");
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, true);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        double result = ((this.person.getGainedCalorie() - this.person.getBurnedCalorie()) - this.person.getDailyCalorieNeeds());
        String word;
        if(result < 0){
            int result2 = (int) (Math.round((-1) * result));
            word = String.valueOf((-1) * result2);
        }
        else{
            int result2 = (int) Math.round(result);
            word = String.valueOf(Math.round(result2));
            word = "+" + word;
        }
        bWMonitoringTxt.write(this.person.getName()  + "\t" + this.person.getAge() + "\t" + ((int) Math.round(this.person.getDailyCalorieNeeds())) + "kcal\t" + this.person.getGainedCalorie() + "kcal\t" + this.person.getBurnedCalorie() + "kcal\t" + word + "kcal\n");
        bWMonitoringTxt.write("***************\n");
        bWMonitoringTxt.close();
    }
}
