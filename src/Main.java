import java.io.*;
import java.util.ArrayList;
public class Main {

    static People person = null;
    static Food food = null;
    static Sport sport = null;
    static String path;

    static void determinePerson(String personID) {
        for (People a : People.people) {
            if (personID.equals(a.getPersonID())) {
                Main.person = a;}}}

    static void determineFood(String foodID){
        for(Food a:Food.foods){
            if (foodID.equals(a.getFoodID())){
                Main.food = a;}}}

    static void determineSport(String sportID){
        for(Sport a:Sport.sports){
            if(sportID.equals(a.getSportID())){
                Main.sport = a;}}}

    public static void main(String[] args) throws IOException {
        path = args[0];
        Commands.ownMethod();
        People.ownMethod();
        Food.ownMethod();
        Sport.ownMethod();


        for(String[] i: Commands.commands) {
            if (i[0].equals("printWarn")) {
                PrintWarn printWarn = new PrintWarn();
                printWarn.warn();
            } else if (i[0].equals("printList")) {
                PrintAllList printAllList = new PrintAllList();
                printAllList.printList();
            } else if(i.length == 1) {
                String[] personList = i[0].split("");
                String personID = personList[6] + personList[7] + personList[8] + personList[9] + personList[10];
                determinePerson(personID);
                PrintPeople printPeople = new PrintPeople(Main.person);
                printPeople.PrintPerson();
            }
            else if (i[1].split("")[0].equals("1")) {
                determinePerson(i[0]);
                determineFood(i[1]);
                int numberOfPortions = Integer.parseInt(i[2]);
                Eating eating = new Eating(Main.person, Main.food, numberOfPortions);
                eating.Eat();
            } else{
                determinePerson(i[0]);
                determineSport(i[1]);
                int sportDuration = Integer.parseInt(i[2]);
                Exercising exercising = new Exercising(Main.person, Main.sport, sportDuration);
                exercising.Exercise();
            }
        }
        ArrayList<String> finalList = new ArrayList<>();
        File monitoringTxt = new File("monitoring.txt");
        FileReader rMonitoringTxt = new FileReader(monitoringTxt);
        BufferedReader bRMonitoringTxt = new BufferedReader(rMonitoringTxt);
        String line2;
        while((line2 = bRMonitoringTxt.readLine()) != null){
            finalList.add(line2);
        }
        finalList.remove(finalList.size() - 1);
        FileWriter wMonitoringTxt = new FileWriter(monitoringTxt, false);
        BufferedWriter bWMonitoringTxt = new BufferedWriter(wMonitoringTxt);
        for(int i = 0; i<= (finalList.size()-2); i++){
            bWMonitoringTxt.write(finalList.get(i) + "\n");
        }
        bWMonitoringTxt.write(finalList.get((finalList.size()) - 1));
        bWMonitoringTxt.close();
    }
}
