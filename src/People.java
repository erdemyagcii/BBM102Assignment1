import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class People {
    private String personID;
    private String name;
    private int weight;
    private int height;
    private int dateOfBirth;
    private int age;
    private int gainedCalorie;
    private int burnedCalorie;
    private double dailyCalorieNeeds;
    private String gender;
    static ArrayList<People> people = new ArrayList<>();
    static LinkedHashSet<People> people2 = new LinkedHashSet<>();

    static void ownMethod() throws IOException {
        File peopleTxt = new File("people.txt");
        FileReader rPeopleTxt = new FileReader(peopleTxt);
        BufferedReader bRPeopleTxt = new BufferedReader(rPeopleTxt);
        String line;
        String[] lineList;
        while((line = bRPeopleTxt.readLine()) != null){
            lineList = line.split("\t");
            String personID = lineList[0];
            String name = lineList[1];
            int weight = Integer.parseInt(lineList[3]);
            int height = Integer.parseInt(lineList[4]);
            int dateOfBirth = Integer.parseInt(lineList[5]);
            String gender = lineList[2];
            People.people.add(new People(personID, name, weight, height, dateOfBirth, gender));
        }
        bRPeopleTxt.close();
    }

    People(String personID,String name, int weight,int height,int dateOfBirth, String gender){
        this.personID = personID;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.age = 2022 - this.getDateOfBirth();
        this.gender = gender;
        if(this.gender.equals("male")){
            this.dailyCalorieNeeds =  66 + (13.75 * this.getWeight()) + (5 * getHeight()) - (6.8 * this.getAge());
        }
        else if(this.gender.equals("female")) {
            this.dailyCalorieNeeds =  665 + (9.6 * this.getWeight()) + (1.7 * getHeight()) - (4.7 * this.getAge());
        }
    }

    public String getPersonID() {
        return personID;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public int getDateOfBirth() {
        return dateOfBirth;
    }
    public int getAge() {
        return age;
    }
    public int getGainedCalorie() {
        return gainedCalorie;
    }
    public void setGainedCalorie(int gainedCalorie) {
        this.gainedCalorie = gainedCalorie;
    }
    public int getBurnedCalorie() {
        return burnedCalorie;
    }
    public void setBurnedCalorie(int burnedCalorie) {
        this.burnedCalorie = burnedCalorie;
    }
    public double getDailyCalorieNeeds() {
        return dailyCalorieNeeds;
    }

}
