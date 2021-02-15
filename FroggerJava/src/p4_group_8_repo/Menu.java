package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Menu extends Main {
    public void mainMenu(Stage primaryStage){
        background = new MyStage();
        Scene scene  = new Scene(background,550,800);

        Font font = Font.font("Courier New", FontWeight.BOLD, 20);

        Button startButton = new Button("START");
        startButton.setLayoutX(180);
        startButton.setLayoutY(400);
        startButton.setMaxSize(200,50);
        startButton.setMinSize(200,50);
        startButton.setFont(font);
        startButton.setStyle("" +
                "-fx-base: #000000; " +
                "-fx-text-fill: #FFFFFF; " +
                "-fx-border-width: 2px; " +
                "-fx-border-color: #FFFFFF");

        Button infoButton = new Button("INFO");
        infoButton.setLayoutX(180);
        infoButton.setLayoutY(500);
        infoButton.setMaxSize(200,50);
        infoButton.setMinSize(200,50);
        infoButton.setFont(font);
        infoButton.setStyle("" +
                "-fx-base: #000000; " +
                "-fx-text-fill: #FFFFFF; " +
                "-fx-border-width: 2px; " +
                "-fx-border-color: #FFFFFF");

        BackgroundImage menuback = new BackgroundImage("file:src/images/froggerMainMenu.png");
        background.add(menuback);
        background.getChildren().addAll(startButton);
        background.getChildren().addAll(infoButton);
        background.start();
        primaryStage.setScene(scene);
        primaryStage.show();

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Game gameSession = new Game();
                gameSession.playGame(primaryStage);
            }
        });

        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Info infoPage = new Info();
                infoPage.playInfo(primaryStage);
            }
        });
    }
}
