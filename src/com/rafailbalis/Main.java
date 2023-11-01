package com.rafailbalis;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Main extends Application {

    CountryForm countryForm;

    CityForm cityForm;
    MenuBar menuBar;

    @Override
    public void start(Stage stage) {
        setUserAgentStylesheet(STYLESHEET_MODENA);

        Menu menuCountries = new Menu("_Manage");
        MenuItem ItemCountries = new MenuItem("Countries");
        ItemCountries.setOnAction(e-> clickCountry());
        ItemCountries.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        MenuItem ItemCities = new MenuItem("Cities");
        ItemCities.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        ItemCities.setOnAction(e-> clickCity());
        MenuItem ItemLang = new MenuItem("Languages");
        ItemLang.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        menuCountries.getItems().addAll(ItemCountries,ItemCities,ItemLang);

        Menu MenuDiag = new Menu("_Diagrams");

        MenuItem Item1 = new MenuItem("Countries per Continent");
        MenuItem Item2 = new MenuItem("Cities per Country");
        MenuItem Item3 = new MenuItem("Population Distribution");
        MenuItem Item4 = new MenuItem("Religion Distribution");
        MenuDiag.getItems().addAll(Item1, Item2,new SeparatorMenuItem(), Item3, Item4);

        Menu menuHelp = new Menu("_Help");
        MenuItem ItemContents = new MenuItem("Contents");
        MenuItem ItemAbout = new MenuItem("About");
        menuHelp.getItems().addAll(ItemContents, new SeparatorMenuItem(), ItemAbout);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuCountries, MenuDiag, menuHelp);


        HBox topPane = new HBox();
        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getChildren().add(menuBar);
        topPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        ImageView img = new ImageView(new Image("C:\\Users\\joker\\OneDrive\\Εικόνες\\LOGO-YB ΜΑΤΡΩΖΟΣ 500Χ500.jpg"));
        HBox bottomPane = new HBox();
        bottomPane.getChildren().add(img);
        bottomPane.setPrefHeight(500);

        VBox pane = new VBox(topPane, bottomPane);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setTitle("Countries in our World");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-500)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-500)/2);
        stage.setWidth(500);
        stage.setHeight(500);


        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void clickCountry () {
        countryForm = new CountryForm();
    }

    public void clickCity () {
        cityForm = new CityForm();
    }
}