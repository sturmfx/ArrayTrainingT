package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Person> persons = new ArrayList<>();
        for(int i = 0; i < 20; i++)
        {
            persons.add(RES.getPerson(18,60,61,100));
        }
        Table table = new Table(persons);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(table, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
