/*
 * Author: Jack Keller
 * Section: CS 1181L-06
 * Date: 10/14/2017
 * Project 2
 */
package keller_project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Jack Keller
 */
public class Keller_Project2 extends Application {

    ArrayList<Media> library = new ArrayList<>();
    ObservableList<Media> listContents = FXCollections.observableArrayList(library);

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void init() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("library.bin")));
            library = (ArrayList<Media>) ois.readObject();
        } catch (IOException e) {
            // System.err.println("Caught IOException: " + e.getMessage());
        } catch (ClassNotFoundException e1) {
            // System.err.println("Caught ClassNotFoundException: " + e1.getMessage());
        }

        listContents = FXCollections.observableArrayList(library);
        Collections.sort(listContents, Media.MediaTitleComparator);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        // The list of media items
        
        ListView<Media> listView = new ListView(listContents);

        HBox interactiveArea = new HBox();
        VBox addMedia = new VBox();

        // The title label and text field
        
        HBox addTitle = new HBox();
        Label title = new Label("Title:     ");
        TextField titleTF = new TextField();
        addTitle.getChildren().addAll(title, titleTF);
        addTitle.setSpacing(5);

        // The format label and text field
        
        HBox addFormat = new HBox();
        Label format = new Label("Format: ");
        TextField formatTF = new TextField();
        addFormat.getChildren().addAll(format, formatTF);
        addFormat.setSpacing(5);

        // The add button
        
        HBox addRemove = new HBox();
        Button addButton = new Button("ADD");
        addButton.setOnAction((ActionEvent e) -> {
            if (titleTF.getText().length() == 0) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Title Error");
                alert.setContentText("Please enter a title for the new media item.");

                alert.showAndWait();
            } else if (formatTF.getText().length() == 0) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Format Error");
                alert.setContentText("Please enter a format for the new media item.");

                alert.showAndWait();
            } else {
                int exists = 1;
                Media newMedia = new Media(titleTF.getText(), (formatTF.getText()));
                for (Media m : listContents) {
                    if (newMedia.getTitle().compareTo(m.getTitle()) == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Same Title Error");
                        alert.setContentText("A media item with that title already exists.");

                        alert.showAndWait();
                        exists = 0;
                    }
                }

                if (exists == 1) {
                    library.add(newMedia);
                    listContents.add(newMedia);
                    Collections.sort(listContents, Media.MediaTitleComparator);
                    listView.refresh();
                }

            }
        });

        // The remove button
        
        Button removeButton = new Button("REMOVE");
        removeButton.setOnAction((ActionEvent event) -> {
            Media toRemove = listView.getSelectionModel().getSelectedItem();
            if (toRemove == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Media Error");
                alert.setContentText("Please choose a media item to remove.");

                alert.showAndWait();
            } else {
                library.remove(toRemove);
                listContents.remove(toRemove);
                Collections.sort(listContents, Media.MediaTitleComparator);
                listView.refresh();
            }
        });

        // The add and remove box 
        
        addRemove.getChildren().addAll(addButton, removeButton);
        addRemove.setSpacing(120);
        addMedia.getChildren().addAll(addTitle, addFormat, addRemove);
        String cssLayout = "-fx-border-color: black;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 2;\n"
                + "-fx-border-style: solid;\n";
        addMedia.setStyle(cssLayout);

        addMedia.setSpacing(10);
        addMedia.setPadding(new Insets(5, 5, 5, 5));

        // The loanee label and text field
        
        VBox loanBox = new VBox();
        HBox loaneeBox = new HBox();
        Label loanee = new Label("Loaned To: ");
        TextField loaneeTF = new TextField();
        loaneeBox.getChildren().addAll(loanee, loaneeTF);

        // The date label and date picker
        
        HBox dateBox = new HBox();
        Label date = new Label("Loaned On: ");
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datePicker.getValue();
            }
        });
        dateBox.getChildren().addAll(date, datePicker);

        loanBox.setSpacing(10);

        HBox loanButtons = new HBox();

        // The loan button
        
        Button loanButton = new Button("LOAN");
        loanButton.setOnAction((ActionEvent event) -> {
            Media toLoan = listView.getSelectionModel().getSelectedItem();
            if (datePicker.getValue() == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Date Error");
                alert.setContentText("Please choose a date the media item was loaned out.");

                alert.showAndWait();
            } else if (loaneeTF.getText().length() == 0) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Loanee Error");
                alert.setContentText("Please choose a loanee the media item was loaned to.");

                alert.showAndWait();
            } else if (toLoan == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Media Error");
                alert.setContentText("Please choose the media item to loan out.");

                alert.showAndWait();
            } else if (toLoan.getLoaned()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Already Loaned Error");
                alert.setContentText("That media item is already loaned out.");

                alert.showAndWait();
            } else {
                toLoan.loan(loaneeTF.getText(), datePicker.getValue());
                listView.refresh();
            }
        });
        
        // The return button

        Button returnButton = new Button("RETURN");
        returnButton.setOnAction((ActionEvent event) -> {
            Media toReturn = listView.getSelectionModel().getSelectedItem();
            if (toReturn == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Media Error");
                alert.setContentText("Please choose the media item to return.");

                alert.showAndWait();
            } else if (!toReturn.getLoaned()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not Loaned Error");
                alert.setContentText("That media item isn't loaned out.");

                alert.showAndWait();
            } else {
                toReturn.loanReturn();
                listView.refresh();
            }
        });

        // The loan box put together
        
        loanButtons.getChildren().addAll(loanButton, returnButton);
        loanButtons.setSpacing(160);
        loanBox.getChildren().addAll(loaneeBox, dateBox, loanButtons);

        loanBox.setPadding(new Insets(5, 5, 5, 5));
        String cssLayout2 = "-fx-border-color: black;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 2;\n"
                + "-fx-border-style: solid;\n";
        loanBox.setStyle(cssLayout2);

        // Putting the entire lower area together besides the sort buttons
        
        interactiveArea.getChildren().addAll(addMedia, loanBox);

        // The sort buttons
        
        HBox sortButtons = new HBox();
        
        final ToggleGroup group = new ToggleGroup();

        // The sort by title button
        
        RadioButton sortName = new RadioButton("Sort by Title");
        sortName.setOnAction((ActionEvent event) -> {
            if (listContents.isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setHeaderText("Empty Library");
                alert.setContentText("There are no items to sort.");

                alert.showAndWait();
            } else {
                Collections.sort(listContents, Media.MediaTitleComparator);
                listView.refresh();
            }
        });
        
        sortName.setToggleGroup(group);
        sortName.setSelected(true);

        // The sort by date button
        
        RadioButton sortDate = new RadioButton("Sort by Date Loaned");
        sortDate.setOnAction((ActionEvent event) -> {
            if (listContents.isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setHeaderText("Empty Library");
                alert.setContentText("There are no items to sort.");

                alert.showAndWait();
            } else {
                Collections.sort(listContents, Media.MediaDateComparator);
                listView.refresh();
            }
        });
        
        sortDate.setToggleGroup(group);

        // The buttons put together
        
        sortButtons.getChildren().addAll(sortName, sortDate);
        sortButtons.setSpacing(165);
        sortButtons.setPadding(new Insets(5, 5, 5, 100));

        // Putting everything together
        
        root.getChildren().addAll(listView, interactiveArea, sortButtons);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Collection");
        primaryStage.show();

    }

    @Override
    public void stop() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("library.bin")));
            oos.writeObject(library);
            oos.close();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

}
