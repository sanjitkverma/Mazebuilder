package com.company;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javax.swing.*;

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        String x;
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox bottomButton = new HBox();
        MyHandler myHandler = new MyHandler();
        x = JOptionPane.showInputDialog(null,"What is N, the dimension of the grid?");

        if (x.isEmpty()) {
            System.exit(0);
        }
        else {
            for (int i = 0; i < Integer.parseInt(x); i++) {
                for (int j = 0; j < Integer.parseInt(x); j++) {
                    Button C = new Button();
                    C.setStyle("-fx-background-color: blue; -fx-border-width: 2px; -fx-border-color: grey;");
                    C.setOnAction(myHandler);
                    C.setPrefHeight(40);
                    C.setPrefWidth(40);
                    getColorChar(C);
                    gridPane.add(C, i, j);
                }
            }
        }

        Scene newscene = new Scene(borderPane, 350, 350);
        primaryStage.setTitle("Maze Builder");
        gridPane.setAlignment(Pos.CENTER);
        bottomButton.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottomButton);
        borderPane.setCenter(gridPane);

        Button save = new Button("Save");
        Button exit = new Button("Exit");

        save.setOnAction(myHandler);
        exit.setOnAction(myHandler);

        bottomButton.getChildren().add(exit);
        bottomButton.getChildren().add(save);
        primaryStage.setScene(newscene);
        primaryStage.show();
    }

    private char getColorChar(Button b ) {
        if (b.getStyle().indexOf("blue") > -1) {
            return '0';
        }
        else if (b.getStyle().indexOf("white") > -1) {
            return '1';
        }
        else if (b.getStyle().indexOf("green") > -1) {
            return 'S';
        }
        else {
            return 'E';
        }
    }
    public class MyHandler implements EventHandler<ActionEvent> {
        public void handle( ActionEvent e) {

            Button A = (Button) e.getSource();
            if (A.getText().equals("Save")) {
            }
            else if (A.getText().equals("Exit")) {
            }
            else {
                char val = getColorChar(A);
                if (val == '0') {  //the button is currently blue so change it to white
                    A.setStyle("-fx-background-color: white;");
                }
                else if (val == '1') {
                    A.setStyle("-fx-background-color: #41806c; -fx-border-width: 2px; -fx-border-color: grey;");
                }
                else if (val == 'S') {
                    A.setStyle("-fx-background-color: #ff7316; -fx-border-width: 2px; -fx-border-color: grey;");
                }
                else {
                    A.setStyle("-fx-background-color: #253cff; -fx-border-width: 2px; -fx-border-color: grey;");
                }
            }
        }
    }
}
