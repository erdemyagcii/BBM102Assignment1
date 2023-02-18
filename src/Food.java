import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Food {
    private String foodID;
    private String nameOfFood;
    private int calorieCount;
    static ArrayList<Food> foods = new ArrayList<>();

    Food(String foodID, String nameOfFood, int calorieCount){
        this.foodID = foodID;
        this.nameOfFood = nameOfFood;
        this.calorieCount = calorieCount;
    }

    static void ownMethod() throws IOException {
        File foodTxt = new File("food.txt");
        FileReader rFoodTxt = new FileReader(foodTxt);
        BufferedReader bRFoodTxt = new BufferedReader(rFoodTxt);
        String line;
        String[] lineList;
        while((line = bRFoodTxt.readLine()) != null){
            lineList = line.split("\t");
            String foodID = lineList[0];
            String nameOfFood = lineList[1];
            int calorieCount = Integer.parseInt(lineList[2]);
            Food.foods.add(new Food(foodID,nameOfFood, calorieCount));
        }
        bRFoodTxt.close();
    }

    public String getFoodID() { return foodID;
    }
    public String getNameOfFood() {
        return nameOfFood;
    }
    public int getCalorieCount() {
        return calorieCount;
    }
}
