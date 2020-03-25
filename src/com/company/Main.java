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
import java.util.Scanner;

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        Scanner x = new Scanner(System.in);
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox bottomButton = new HBox();
        MyHandler myHandler = new MyHandler();
        System.out.println("Walls:Blue    Path:Brown    Entry:Green    Exit:Red");
        System.out.print("What is N, the dimension of the grid (NxN)?:");
        String in = x.nextLine();
        if (in.isEmpty()) {
            System.exit(0);
        }
        else {
            for (int i = 0; i < Integer.parseInt(in); i++) {
                for (int j = 0; j < Integer.parseInt(in); j++) {
                    Button C = new Button();
                    C.setStyle("-fx-background-color: blue; -fx-border-width: 2px; -fx-border-color: black;");
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

    public char getColorChar(Button C ) {
        if (C.getStyle().indexOf("blue") > -1) {
            return '0';
        }
        else if (C.getStyle().indexOf("white") > -1) {
            return '1';
        }
        else if (C.getStyle().indexOf("green") > -1) {
            return '2';
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
                System.exit(0);
            }
            else {
                char val = getColorChar(A);
                if (val == '0') {
                    A.setStyle("-fx-background-color: white;");
                }
                //PATH
                else if (val == '1') {
                    A.setStyle("-fx-background-color: #806f61; -fx-border-width: 2px; -fx-border-color: grey;");
                }
                //ENTRY
                else if (val == '2') {
                    A.setStyle("-fx-background-color: #00ff07; -fx-border-width: 2px; -fx-border-color: grey;");
                }
                //EXIT
                else {
                    A.setStyle("-fx-background-color: #ff0002; -fx-border-width: 2px; -fx-border-color: grey;");
                }
            }
        }
    }
}
