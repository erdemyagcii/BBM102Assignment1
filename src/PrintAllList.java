import java.io.*;

public class PrintAllList {
    void printList() throws IOException {
        File monitoringTxt = new File("monitoring.txt");
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, true);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        for(People i: People.people2) {
            double result = (i.getGainedCalorie() - i.getBurnedCalorie()) - (i.getDailyCalorieNeeds());
            String word;
            if(result < 0){
                result = Math.round((-1) * result);
                int result2;
                result2 = ((int) result) * (-1);
                word = String.valueOf(result2);
            }
            else{
                word = String.valueOf((int) Math.round(result));
                word = "+" + word;

            }
            if((i.getGainedCalorie() != 0) || (i.getBurnedCalorie() != 0)) {
                bWMonitoringTxt.write(i.getName() + "\t" + i.getAge() + "\t" + ((int) Math.round(i.getDailyCalorieNeeds())) + "kcal\t" + i.getGainedCalorie() + "kcal\t" + i.getBurnedCalorie() + "kcal\t" + word + "kcal\n");
            }
        }
        bWMonitoringTxt.write("***************\n");
        bWMonitoringTxt.close();
    }
}
