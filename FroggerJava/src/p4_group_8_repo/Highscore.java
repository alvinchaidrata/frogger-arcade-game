package p4_group_8_repo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Highscore {
    public void Highscore(){ }
    public ArrayList<Integer> arr = new ArrayList<Integer>();
    File hiScore = new File ("src/p4_group_8_repo/hiScore.txt");

    /**
     * Creates a sorted high score list and place it into the file
     * @param point player score
     * @throws IOException throws exception
     */
    public void setScore(int points) throws IOException{
        if (hiScore.exists()==false) {
            hiScore.createNewFile();
        }
        for(int i=0;i<10;i++) {
            arr.add(0);
        }
        Scanner scanner = new Scanner(hiScore);
        try {
            while(scanner.hasNextLine()) {
                String scorestr =scanner.nextLine();
                arr.add(Integer.parseInt (scorestr));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        scanner.close();
        if (arr.size()>10) {
            if(points>=arr.get(9)) {
                arr.add(points);
            }
        }else {
            arr.add(points);
        }
        Collections.sort(arr,Collections.reverseOrder());
        FileWriter file = new FileWriter(hiScore);
        BufferedWriter buffer = new BufferedWriter(file);
        PrintWriter writer = new PrintWriter(buffer);{
            for(int i=0;i<10;i++) {
                writer.println(arr.get(i));

            }
            writer.close();
        }
    }

    /**
     * Styling the contents of the array so that its easier to be understood
     * @param array the score array
     * @return String ready to display
     */
    public String display(ArrayList<Integer> array) {

        String sortedscore = new String("Highscore\n1." + array.get(0)+ "\n2." +array.get(1)+ "\n3." +array.get(2)+ "\n4." +array.get(3) +"\n5." +array.get(4)+ "\n6." +array.get(5) +"\n7." +array.get(6)+ "\n8." +array.get(7) +"\n9." +array.get(8)+ "\n10." +array.get(9));
        return sortedscore;

    }

    /**
     * Displaying the High Score List
     */
    public void getScore() {

        try {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("You Have Won The Game!");

            alert.setHeaderText(display(arr));

            alert.setContentText("Highest Possible Score: 850");
            alert.show();
        } catch(Exception e) {

            e.printStackTrace();
        }

    }

}