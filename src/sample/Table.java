package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Table extends HBox
{
    ArrayList<Person> persons = new ArrayList<>();
    ArrayList<Person> persons1 = new ArrayList<>();
    VBox fname = new VBox();
    VBox sname = new VBox();
    VBox age = new VBox();
    VBox points = new VBox();
    Button fname_button = new Button("FIRST NAME");
    Button sname_button = new Button("SECOND NAME");
    Button age_button = new Button("    AGE    ");
    Button points_button = new Button("   POINTS   ");
    Button save = new Button("SAVE AS PNG");

    Boolean fname_button_b = false;
    Boolean sname_button_b = false;
    Boolean age_button_b = false;
    Boolean points_button_b = false;

    public Table(ArrayList<Person> persons)
    {
        this.persons = persons;
        fname_button.setOnAction(e ->
        {
            if(fname_button_b)
            {
                persons1 = persons.stream().sorted(Comparator.comparing(Person::getFname)).collect(Collectors.toCollection(ArrayList::new));
                fname_button_b = !fname_button_b;
                draw();
            }
            else
            {
                persons1 = persons.stream().sorted(Comparator.comparing(Person::getFname).reversed()).collect(Collectors.toCollection(ArrayList::new));
                fname_button_b = !fname_button_b;
                draw();
            }
        });

        sname_button.setOnAction(e ->
        {
            if(sname_button_b)
            {
                persons1 = persons.stream().sorted(Comparator.comparing(Person::getSname)).collect(Collectors.toCollection(ArrayList::new));
                sname_button_b = !sname_button_b;
                draw();
            }
            else
            {
                persons1 = persons.stream().sorted(Comparator.comparing(Person::getSname).reversed()).collect(Collectors.toCollection(ArrayList::new));
                sname_button_b = !sname_button_b;
                draw();
            }
        });

        age_button.setOnAction(e ->
        {
            if(age_button_b)
            {
                persons1 = persons.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toCollection(ArrayList::new));
                age_button_b = !age_button_b;
                draw();
            }
            else
            {
                persons1 = persons.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).collect(Collectors.toCollection(ArrayList::new));
                age_button_b = !age_button_b;
                draw();
            }

        });

        points_button.setOnAction(e ->
        {
            if(points_button_b)
            {
                persons1 = persons.stream().sorted(Comparator.comparingInt(Person::getPoints)).collect(Collectors.toCollection(ArrayList::new));
                points_button_b = !points_button_b;
                draw();
            }
            else
            {
                persons1 = persons.stream().sorted(Comparator.comparingInt(Person::getPoints).reversed()).collect(Collectors.toCollection(ArrayList::new));
                points_button_b = !points_button_b;
                draw();
            }
        });

        save.setOnAction(e ->
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
            File file = fileChooser.showSaveDialog(null);
            if(file != null)
            {
                try
                {

                    WritableImage image = snapshot(new SnapshotParameters(), null);
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        fname.getChildren().add(fname_button);
        sname.getChildren().add(sname_button);
        age.getChildren().add(age_button);
        points.getChildren().add(points_button);

        getChildren().add(fname);
        getChildren().add(sname);
        getChildren().add(age);
        getChildren().add(points);

        getChildren().add(save);


    }
    public void draw()
    {
        fname.getChildren().clear();
        sname.getChildren().clear();
        age.getChildren().clear();
        points.getChildren().clear();

        fname.getChildren().add(fname_button);
        sname.getChildren().add(sname_button);
        age.getChildren().add(age_button);
        points.getChildren().add(points_button);

        for(Person p: persons1)
        {
            fname.getChildren().add(new Label(p.getFname()));
            sname.getChildren().add(new Label(p.getSname()));
            age.getChildren().add(new Label(String.valueOf(p.getAge())));
            points.getChildren().add(new Label(String.valueOf(p.getPoints())));
        }
    }
}
