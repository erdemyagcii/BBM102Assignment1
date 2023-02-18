import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PrintWarn {

    void warn() throws IOException {
        boolean key = false;
        File monitoringTxt = new File("monitoring.txt");
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, true);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        for(People i: People.people2) {
            double result = (((i.getGainedCalorie()) - i.getBurnedCalorie()) - i.getDailyCalorieNeeds());
            if((result > 0) && ((i.getGainedCalorie() != 0))){
                result = (int) Math.round(result);
                bWMonitoringTxt.write(i.getName() + "\t" + i.getAge() + "\t" + ((int) Math.round(i.getDailyCalorieNeeds())) + "\t" + i.getGainedCalorie() + "\t" + i.getBurnedCalorie() + "\t" + "+" + ((int) result) + "kcal\n");
                key = true;
            }
        }
        if(key != true){
            bWMonitoringTxt.write("there\tis\tno\tsuch\tperson\n");
        }
        bWMonitoringTxt.write("***************\n");
        bWMonitoringTxt.close();
    }
}
