import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Eating {
    People person;
    Food food;
    int numberOfPortions;
    Eating(People person, Food food, int numberOfPortions) {
        this.person = person;
        this.food = food;
        this.numberOfPortions = numberOfPortions;
    }

    void Eat() throws IOException {
        File monitoringTxt = new File("monitoring.txt");
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, true);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        this.person.setGainedCalorie((this.person.getGainedCalorie()) + (this.food.getCalorieCount() * this.numberOfPortions));
        People.people2.add(this.person);
        bWMonitoringTxt.write(this.person.getPersonID() + "\t" + "has\ttaken\t" + (this.food.getCalorieCount() * this.numberOfPortions) + "kcal\tfrom\t" + this.food.getNameOfFood() + "\n");
        bWMonitoringTxt.write("***************\n");
        bWMonitoringTxt.close();
    }
}
