/*
 * Author: Jack Keller
 * Section: CS 1181L-06
 * Date: 12/09/2017
 * Project 4
 */
package keller_project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;

/**
 *
 * @author Jack Keller
 */
public class Keller_Project4 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        VBox sortAlg = new VBox();

        Label sorting = new Label("Sorting Alogrithm");

        final ToggleGroup group1 = new ToggleGroup();

        RadioButton selectionS = new RadioButton("Selection");
        RadioButton bubbleS = new RadioButton("Bubble");
        RadioButton insertionS = new RadioButton("Insertion");
        RadioButton quickS = new RadioButton("Quick");

        selectionS.setToggleGroup(group1);
        bubbleS.setToggleGroup(group1);
        insertionS.setToggleGroup(group1);
        quickS.setToggleGroup(group1);

        selectionS.setSelected(true);

        sortAlg.getChildren().addAll(sorting, selectionS, bubbleS, insertionS, quickS);
        sortAlg.setSpacing(5);
        sortAlg.setPadding(new Insets(5, 5, 5, 5));
        sortAlg.setStyle("-fx-border-color: black;\n"
                + "-fx-border-insets: 4;\n"
                + "-fx-border-width: 2;\n"
                + "-fx-border-style: solid;\n");

        VBox inputType = new VBox();

        Label input = new Label("Input Type");

        final ToggleGroup group2 = new ToggleGroup();

        RadioButton sorted = new RadioButton("Already Sorted");
        RadioButton reverse = new RadioButton("Reverse Order");
        RadioButton random = new RadioButton("Random");

        sorted.setToggleGroup(group2);
        reverse.setToggleGroup(group2);
        random.setToggleGroup(group2);

        sorted.setSelected(true);

        inputType.getChildren().addAll(input, sorted, reverse, random);
        inputType.setSpacing(5);
        inputType.setPadding(new Insets(5, 5, 5, 5));
        inputType.setStyle("-fx-border-color: black;\n"
                + "-fx-border-insets: 4;\n"
                + "-fx-border-width: 2;\n"
                + "-fx-border-style: solid;\n");

        VBox sizes = new VBox();
        HBox inputSize = new HBox();
        HBox blockSize = new HBox();

        Label inputS = new Label("Input Size");
        TextField inputTF = new TextField();

        inputSize.getChildren().addAll(inputS, inputTF);
        inputSize.setSpacing(5);

        Label blockS = new Label("Block Size");
        TextField blockTF = new TextField();

        blockSize.getChildren().addAll(blockS, blockTF);
        blockSize.setSpacing(5);

        sizes.getChildren().addAll(inputSize, blockSize);
        sizes.setSpacing(5);
        sizes.setPadding(new Insets(5, 5, 5, 5));
        sizes.setStyle("-fx-border-color: black;\n"
                + "-fx-border-insets: 4;\n"
                + "-fx-border-width: 2;\n"
                + "-fx-border-style: solid;\n");

        Button goB = new Button("GO");
        goB.setMaxWidth(Double.MAX_VALUE);
        goB.setPadding(new Insets(5, 5, 5, 5));
        goB.setOnAction((ActionEvent event) -> {
            if (checkValid(inputTF, blockTF, group1, group2)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Missing or Incorrect Inputs");
                alert.setContentText("Please make sure all fields are filled out correctly.");

                alert.showAndWait();

            } else {
                int arraySize = Integer.parseInt(inputTF.getText());
                int blockNum = Integer.parseInt(blockTF.getText());
                int blockCount = (int) Math.floor((double) arraySize / blockNum);

                int[] arr = createArray(arraySize, sorted, reverse);
                char selection = checkSelection(selectionS, bubbleS, insertionS, quickS);

                long start = System.currentTimeMillis();

                threading(arr, selection, blockNum, blockCount);

                long end = System.currentTimeMillis();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Threaded Sorting");
                alert.setHeaderText("Finished");
                alert.setContentText("Sort completed in " + (end - start) + " ms");

                alert.showAndWait();
            }
        });

        root.getChildren().addAll(sortAlg, inputType, sizes, goB);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Threaded Sorting");
        primaryStage.show();

    }

    public static boolean checkValid(TextField input, TextField block, ToggleGroup group1, ToggleGroup group2) {
        try {
            int arraySize = Integer.parseInt(input.getText());
            int blockNum = Integer.parseInt(block.getText());
        } catch (NumberFormatException e) {
            return true;
        }
        if (input.getText().length() == 0) {
            return true;
        } else if (block.getText().length() == 0) {
            return true;
        } else if (group1.getSelectedToggle() == null) {
            return true;
        } else if (group2.getSelectedToggle() == null) {
            return true;
        }
        return false;
    }

    public static int[] createArray(int size, RadioButton sorted, RadioButton reverse) {
        int[] arr = new int[size];
        Random randomNum = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNum.nextInt(100);
        }

        if (sorted.isSelected()) {
            Arrays.sort(arr);
        } else if (reverse.isSelected()) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }

        return arr;
    }

    public static char checkSelection(RadioButton selection, RadioButton bubble, RadioButton insertion, RadioButton quick) {
        if (selection.isSelected()) {
            return 's';
        } else if (bubble.isSelected()) {
            return 'b';
        } else if (insertion.isSelected()) {
            return 'i';
        } else {
            return 'q';
        }
    }

    public static void threading(int[] arr, char selection, int blockNum, int blockCount) {
        ArrayList<SortingThread> sorters = new ArrayList<>();
        
        for (int i = 0; i < blockCount; i++) {
            sorters.add(new SortingThread(selection, Arrays.copyOfRange(arr, i * blockNum, (i + 1) * blockNum)));
        }

        if (arr.length % blockNum != 0) {
            sorters.add(new SortingThread(selection, Arrays.copyOfRange(arr, (arr.length / blockNum) * blockNum, arr.length)));
        }
        
        for(SortingThread s : sorters) {
            s.start();
        }
        
        for(SortingThread s : sorters) {
            try {
                s.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Keller_Project4.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        Queue<int[]> q = new LinkedList();
        for(SortingThread s : sorters) {
            q.offer(s.getArr());
        }
        
        while(q.size() > 1) {
            ArrayList<MergeSort> mergers = new ArrayList();
            while(q.size() > 1) {
                MergeSort m = new MergeSort(q.poll(),q.poll());
                m.start();
                mergers.add(m);
            }
            for(MergeSort m : mergers) {
                try {
                    m.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Keller_Project4.class.getName()).log(Level.SEVERE, null, ex);
                }
                q.offer(m.getOutput());
            }
        }
        
        System.out.println(Arrays.toString(q.peek()));
    }

}
