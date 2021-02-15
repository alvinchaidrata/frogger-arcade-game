package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Info extends Main {

    public void playInfo(Stage primaryStage){
        background = new MyStage();
        Scene scene  = new Scene(background,550,800);
        Font font = Font.font("Courier New", FontWeight.BOLD, 20);
        Button backButton = new Button("BACK");
        backButton.setLayoutX(180);
        backButton.setLayoutY(650);
        backButton.setMaxSize(200,50);
        backButton.setMinSize(200,50);
        backButton.setFont(font);
        backButton.setStyle("" +
                "-fx-base: #000000; " +
                "-fx-text-fill: #FFFFFF; " +
                "-fx-border-width: 2px; " +
                "-fx-border-color: #FFFFFF");


        BackgroundImage infoback = new BackgroundImage("file:src/images/froggerInfo.png");
        background.add(infoback);
        background.getChildren().addAll(backButton);
        background.start();
        primaryStage.setScene(scene);
        primaryStage.show();

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Menu menuPage = new Menu();
                menuPage.mainMenu(primaryStage);
            }
        });
    }
}
