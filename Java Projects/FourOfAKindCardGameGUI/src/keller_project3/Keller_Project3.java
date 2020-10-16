/*
 * Author: Jack Keller
 * Section: CS 1181L-06
 * Date: 11/04/2017
 * Project 3
 */
package keller_project3;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jack Keller
 */
public class Keller_Project3 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DiscardPile discard = new DiscardPile();

        char status = 'n';

        Player p1 = new Player("Player");
        Player ai = new Player("The Computer");

        String suit = "Hearts";

        DrawPile deck = new DrawPile();

        for (int i = 0; i < 4; i++) {
            Card toAdd1 = deck.drawFromDeck();
            p1.AddToHand(toAdd1);
            Card toAdd2 = deck.drawFromDeck();
            ai.AddToHand(toAdd2);
        }

        if (p1.checkStatus() == 'p') {
            playerWinner(primaryStage, p1);
        } else if (ai.checkStatus() == 'p') {
            computerWinner(primaryStage, ai);
        }

        VBox root = new VBox();

        Label infoArea = new Label("It is your turn. You must draw from the deck.");

        Label discarded = new Label();
        discarded.setText("Discard Pile: Empty");

        Label handLabel = new Label("Your Hand:");

        ObservableList<Card> listContents = FXCollections.observableArrayList(p1.getHand());
        ListView<Card> listView = new ListView(listContents);

        HBox choiceButtons = new HBox();
        Button drawPileB = new Button("Draw From Deck");
        drawPileB.setOnAction((ActionEvent event) -> {
            if (p1.getTurn()) {
                if (deck.getDeck().isEmpty()) {
                    deck.shuffleDeck(discard.getDiscard());
                    discard.clearDiscard();
                }

                Card toAdd = deck.drawFromDeck();

                p1.AddToHand(toAdd);
                listContents.add(toAdd);
                listView.refresh();
                p1.changeTurn();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Do That");
                alert.setHeaderText("You Already Drew");
                alert.setContentText("You must discard a card and wait until your next turn.");

                alert.showAndWait();
            }
        });
        Button discardPileB = new Button("Draw From Discard Pile");
        discardPileB.setOnAction((ActionEvent event) -> {
            if (discard.getDiscard().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Do That");
                alert.setHeaderText("Empty Discard Pile");
                alert.setContentText("The discard pile is empty so you must draw from the deck.");

                alert.showAndWait();
            } else {
                if (p1.getTurn()) {
                    Card toAdd = discard.drawFromDiscard();

                    p1.AddToHand(toAdd);
                    listContents.add(toAdd);
                    listView.refresh();
                    if (discard.getDiscard().isEmpty()) {
                        discarded.setText("Discard Pile: Empty");
                    } else {
                        discarded.setText("Discard Pile: " + discard.view().toString());
                    }
                    p1.changeTurn();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cannot Do That");
                    alert.setHeaderText("You Already Drew");
                    alert.setContentText("You must discard a card and wait until your next turn.");

                    alert.showAndWait();
                }
            }
        });

        choiceButtons.getChildren().addAll(drawPileB, discardPileB);
        choiceButtons.setSpacing(30);
        choiceButtons.setPadding(new Insets(0, 0, 0, 30));

        HBox discardButton = new HBox();
        Button discardB = new Button("Discard the Selected Card");
        discardB.setOnAction((ActionEvent event) -> {
            Card toRemove = listView.getSelectionModel().getSelectedItem();
            if (toRemove == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cannot Do That");
                alert.setHeaderText("No Card Selected");
                alert.setContentText("Please select a card from your hand to discard.");

                alert.showAndWait();
            } else {
                if (p1.getTurn()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cannot Do That");
                    alert.setHeaderText("Haven't Drawn Yet");
                    alert.setContentText("Please draw from the deck or discard pile.");

                    alert.showAndWait();
                } else {
                    discard.addToDiscard(toRemove);
                    listContents.remove(toRemove);
                    p1.removeFromHand(toRemove);
                    listView.refresh();
                    discarded.setText("Discard Pile: " + discard.view().toString());
                    infoArea.setText("You have discarded " + toRemove.toString() + ".");

                    if (p1.checkStatus() == 'p') {
                        playerWinner(primaryStage, p1);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Computer's Turn");
                        alert.setHeaderText("Wait Your Turn");
                        alert.setContentText("The Computer will take its turn now.");

                        alert.showAndWait();

                        Random rand = new Random();
                        int num = rand.nextInt(2);
                        int hand = rand.nextInt(5);

                        if (num == 0) {
                            Card toAdd = deck.drawFromDeck();
                            ai.AddToHand(toAdd);

                            Card remove = ai.getHand().get(hand);
                            ai.removeFromHand(remove);
                            discard.addToDiscard(remove);

                            discarded.setText("Discard Pile: " + discard.view().toString());
                            infoArea.setText("The Computer drew from the deck and discarded " + remove.toString() + ".");

                        } else {
                            if (discard.getDiscard().isEmpty()) {
                                if (deck.getDeck().isEmpty()) {
                                    deck.shuffleDeck(discard.getDiscard());
                                    discard.clearDiscard();
                                }
                                Card toAdd = deck.drawFromDeck();
                                ai.AddToHand(toAdd);

                                Card remove = ai.getHand().get(hand);
                                ai.removeFromHand(remove);
                                discard.addToDiscard(remove);

                                discarded.setText("Discard Pile: " + discard.view().toString());
                                infoArea.setText("The Computer drew from the deck and discarded " + remove.toString() + ".");
                            } else {
                                Card toAdd = discard.drawFromDiscard();
                                ai.AddToHand(toAdd);

                                Card remove = ai.getHand().get(hand);
                                ai.removeFromHand(remove);
                                discard.addToDiscard(remove);

                                discarded.setText("Discard Pile: " + discard.view().toString());
                                infoArea.setText("The Computer drew from the discard and discarded " + remove.toString() + ".");
                            }
                        }

                        if (ai.checkStatus() == 'p') {
                            computerWinner(primaryStage, ai);
                        }

                        p1.changeTurn();
                    }
                }
            }
        });

        discardButton.getChildren().addAll(discardB);
        discardButton.setPadding(new Insets(0, 0, 0, 100));

        root.getChildren().addAll(discarded, handLabel, listView, choiceButtons, discardButton, infoArea);
        root.setSpacing(15);
        root.setPadding(new Insets(5, 5, 5, 5));

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Four of a Kind");
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> Platform.exit());

    }

    public void playerWinner(Stage primaryStage, Player p1) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner Winner");
        alert.setHeaderText("You Win!");
        alert.setContentText("You collected four " + p1.getHand().get(0).getValue() + "s!");

        alert.showAndWait();
        primaryStage.close();
    }

    public void computerWinner(Stage primaryStage, Player ai) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Better Luck Next Time");
        alert.setHeaderText("The Computer Has Won!");
        alert.setContentText("They collected four " + ai.getHand().get(0).getValue() + "s!");

        alert.showAndWait();
        primaryStage.close();
    }
}
