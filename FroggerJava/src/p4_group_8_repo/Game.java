package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Game extends Main{
    Highscore hiscore = new Highscore();


    public void playGame(Stage primaryStage){
        background = new MyStage();
        Scene scene  = new Scene(background,550,800);

        BackgroundImage froggerback = new BackgroundImage("file:src/images/froggerGameBackground.png");
        background.add(froggerback);

        Font font = Font.font("Courier New", FontWeight.BOLD, 15);

        Button resetButton = new Button("R");
        resetButton.setLayoutX(500);
        resetButton.setLayoutY(20);
        resetButton.setMaxSize(40,40);
        resetButton.setMinSize(40,40);
        resetButton.setFont(font);
        resetButton.setStyle("" +
                "-fx-base: #000000; " +
                "-fx-text-fill: #FFFFFF; " +
                "-fx-border-width: 0.5px; " +
                "-fx-border-color: #FFFFFF");

        background.add(new Log("file:src/images/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("file:src/images/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("file:src/images/log3.png", 150, 440, 166, 0.75));
        background.add(new Log("file:src/images/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/images/logs.png", 300, 400, 276, -2));
        background.add(new Log("file:src/images/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("file:src/images/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("file:src/images/log3.png", 150, 490, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));

        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));

        background.add(new End(12,96));
        background.add(new End(125,96));
        background.add(new End(245,96));
        background.add(new End(365,96));
        background.add(new End(485,96));

        animal = new Animal("file:src/images/froggerUp.png");
        background.add(animal);

        background.add(new Obstacle("file:src/images/truck1"+"Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/images/truck1"+"Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/images/truck1"+"Right.png", 600, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/images/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/images/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/images/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/images/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/images/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/images/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/images/car1Left.png", 500, 490, -5, 50, 50));

        background.add(new Digit(0, 30, 450, 25));

        background.getChildren().addAll(resetButton);
        background.start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();

        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                reset(primaryStage);
            }
        });
    }

    /**
     * Creating game timer
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    try{
                        hiscore.setScore(animal.getPoints());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    hiscore.getScore();

                }
            }
        };
    }

    /**
     * function to start game
     */
    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    /**
     * function to stop timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * function to restart the current game session
     * @param primaryStage
     */
    public void reset(Stage primaryStage){
        background.stopMusic();
        stop();
        background.stop();
        playGame(primaryStage);
    }

    /**
     * function to display the score in the game screen
     * @param n current points
     */
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 450 - shift, 25));
            shift+=30;
        }
    }


}
