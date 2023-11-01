package com.rafailbalis;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CityForm {
    Stage stage;

    Label lbName, lbCountry, lbDistinct, lbPopulation;
    TextField txtName, txtDistinct, txtPopulation;
    ComboBox <String> comboCountry;

    ListView <City> lvCities;

    Button btnNew, btnEdit, btnDelete;

    Button btnSave, btnCancel2;

    EnumFormState FormState;

    HBox hBoxSaveCancel;
    HBox hBoxAddEditDel;

    private City kabul, qandahar, herat, mazarelsharif;

    public CityForm() {

        kabul = new City("Kabul", "Afghanistan", "Kabol", 1780000L);
        qandahar = new City("Qandahar", "Afghanistan", "Qandahar", 237500L);
        herat = new City("Herat", "Afghanistan", "Herat", 186800L);
        mazarelsharif = new City("Mazar-e-Sharif", "Afghanistan", "Balkh", 731200L);

        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(5));
        mainPane.setHgap(3);
        mainPane.setVgap(5);
        mainPane.setAlignment(Pos.TOP_CENTER);


        lbName = new Label("Name");
        lbCountry = new Label("Country");
        lbDistinct = new Label("Distinct");
        lbPopulation = new Label("Population");

        txtName = new TextField();
        comboCountry = new ComboBox<>();
        comboCountry.getItems().addAll("Aruba", "Afghanistan", "Angola", "Anguilla");
        comboCountry.setEditable(true);
        new AutoCompleteComboBoxListener<>(comboCountry);
        txtDistinct = new TextField();
        txtPopulation = new TextField();

        mainPane.add(lbName, 1,0);
        GridPane.setHalignment(lbName, HPos.RIGHT);
        GridPane.setValignment(lbName, VPos.CENTER);
        mainPane.add(txtName, 2, 0);
        GridPane.setHalignment(txtName, HPos.LEFT);
        GridPane.setValignment(txtName, VPos.CENTER);

        mainPane.add(lbCountry, 1,1);
        GridPane.setHalignment(lbCountry, HPos.RIGHT);
        GridPane.setValignment(lbCountry, VPos.CENTER);
        mainPane.add(comboCountry, 2, 1);
        GridPane.setHalignment(comboCountry, HPos.LEFT);
        GridPane.setValignment(comboCountry, VPos.CENTER);

        mainPane.add(lbDistinct, 1,2);
        GridPane.setHalignment(lbDistinct, HPos.RIGHT);
        GridPane.setValignment(lbDistinct, VPos.CENTER);
        mainPane.add(txtDistinct, 2, 2);
        GridPane.setHalignment(txtDistinct, HPos.LEFT);
        GridPane.setValignment(txtDistinct, VPos.CENTER);

        mainPane.add(lbPopulation, 1,3);
        GridPane.setHalignment(lbPopulation, HPos.RIGHT);
        GridPane.setValignment(lbPopulation, VPos.CENTER);
        mainPane.add(txtPopulation, 2, 3);
        GridPane.setHalignment(txtPopulation, HPos.LEFT);
        GridPane.setValignment(txtPopulation, VPos.CENTER);

        btnSave = new Button("Save");
        btnSave.setOnAction(e-> {
            if (validateForm()) {
                System.out.println("Validate: OK");
                if (FormState == EnumFormState.EDIT) {
                    City c = lvCities.getSelectionModel().getSelectedItem();
                    save_form(c);
                    FormState = EnumFormState.VIEW;
                    changeState(FormState, c);
                }
                else if (FormState == EnumFormState.ADD) {
                    City c = new City();
                    save_form(c);
                    FormState = EnumFormState.VIEW;
                    lvCities.getItems().add(c);
                    lvCities.getSelectionModel().select(c);
                    changeState(FormState, c);
                }
            }
        });


        btnCancel2 = new Button("Cancel");
        btnCancel2.setOnAction(e -> {
            FormState = EnumFormState.VIEW;
            changeState(FormState, lvCities.getSelectionModel().getSelectedItem());
        });

        hBoxSaveCancel = new HBox();
        hBoxSaveCancel.getChildren().addAll(btnSave, btnCancel2);
        hBoxSaveCancel.setSpacing(5);
        hBoxSaveCancel.setAlignment(Pos.CENTER_LEFT);
        mainPane.add(hBoxSaveCancel, 2, 5);
        GridPane.setColumnSpan(hBoxSaveCancel, 1);

        lvCities = new ListView<>();
        lvCities.getItems().addAll(kabul, qandahar,herat, mazarelsharif);
        lvCities.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    loadForm(newValue);
                    System.out.println(newValue);
                });

        mainPane.add(lvCities, 0, 0);
        GridPane.setRowSpan(lvCities, mainPane.getRowCount() + 1);
        GridPane.setHalignment(lvCities, HPos.LEFT);

        btnNew = new Button();
        btnNew.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\add35.png")));
        btnNew.setPrefWidth(lvCities.getWidth() / 3 - 3);
        btnNew.setOnAction(e -> {
            FormState = EnumFormState.ADD;
            changeState(FormState, null);
        });

        btnEdit = new Button();
        btnEdit.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\edit35.png")));
        btnEdit.setPrefWidth(lvCities.getWidth() / 3 - 3);
        btnEdit.setOnAction(e -> {
            FormState = EnumFormState.EDIT;
            changeState(FormState, lvCities.getSelectionModel().getSelectedItem());
        });

        btnDelete = new Button();
        btnDelete.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\del35.png")));
        btnDelete.setPrefWidth(lvCities.getWidth() / 3 - 3);
        btnDelete.setOnAction(e -> {
            MessageOKCancel m = new MessageOKCancel("Are you sure?", "Warning");
            boolean response = m.getResponse();
            if (response) {
                lvCities.getItems().remove(lvCities.getSelectionModel().getSelectedItem());
                if (lvCities.getItems().size() > 0) {
                    lvCities.getSelectionModel().select(0);
                } else {
                    FormState = EnumFormState.ADD;
                    changeState(FormState, null);
                }
            }
        });

        hBoxAddEditDel = new HBox();
        hBoxAddEditDel.setSpacing(5);
        hBoxAddEditDel.getChildren().addAll(btnNew, btnEdit, btnDelete);
        hBoxAddEditDel.setAlignment(Pos.CENTER);
        mainPane.add(hBoxAddEditDel, 0, mainPane.getRowCount() + 1);


        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPrefWidth(200);
        col0.setHalignment(HPos.LEFT);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);

        Region rEmpty = new Region();
        mainPane.add(rEmpty, 3, 0);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.SOMETIMES);

        mainPane.getColumnConstraints().addAll(col0, col1, col2, col3);


        Scene scene = new Scene(mainPane);
        scene.heightProperty().addListener(
                (observable, oldValue, newValue) -> {
                    mainPane.setPrefHeight(scene.getHeight());
                    lvCities.setPrefHeight(scene.getHeight());
                });
        scene.widthProperty().addListener(
                (observable, oldValue, newValue) -> {
                    mainPane.setPrefWidth(scene.getWidth());
//                    System.out.println(mainPane.getWidth());
//                    System.out.println(scene.getWidth());
//                    System.out.println(mainPane.getColumnConstraints().get(0).getPrefWidth());
                });

        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Country");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth() - 700) / 2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight() - 600) / 2);
        stage.setWidth(700);
        stage.setHeight(600);
        stage.initModality(Modality.APPLICATION_MODAL);

        lvCities.getSelectionModel().select(0);
        FormState = EnumFormState.VIEW;
        changeState(FormState, lvCities.getSelectionModel().getSelectedItem());

        stage.show();

    }
    public boolean validateForm () {
        String errors = "";
        if (txtName.getText().length() > 35) {
            errors += "Name can't exceed 35 characters\n";
        }
        if (txtName.getText().isBlank()) {
            errors += "Name can't be empty\n";
        }
        String Country = comboCountry.getValue();
        if (!comboCountry.getItems().contains(Country)) {
            errors += "Country must be a valid Value\n";
        }
        if (txtDistinct.getText().length() > 35) {
            errors += "Distinct can't exceed 35 characters\n";
        }
        if (txtDistinct.getText().isBlank()) {
            errors += "Distinct can't be empty\n";
        }
        Long population = null;
        try {
            population = Long.valueOf(txtPopulation.getText());
            if (population < 0 || population > 1000000000L)
                errors += "Invalid Population\n";
        } catch (NumberFormatException ob) {
            errors += "Population must be a number\n";
        }
        if (errors.length() > 0) {
            boolean response;
            MessageOKCancel m = new MessageOKCancel(errors, "ERRORS");
            response = m.getResponse();
            System.out.println(response);
            return false;
        } else {
            String output =
                    "name: " + txtName.getText() + "\n" +
                            "Country: " + comboCountry.getValue() + "\n" +
                            "Distinct: " + txtDistinct.getText() + "\n" +
                            "Population: " + txtPopulation.getText() + "\n";
            System.out.println(output);
            return true;
        }
    }
    public void loadForm(City c) {
        txtName.setText(c.getName());
        txtDistinct.setText(c.getDistinct());
        comboCountry.setValue(c.getCountry());
        txtPopulation.setText(c.getPopulation().toString());
    }

    public void save_form(City c) {
        c.setName(txtName.getText());
        c.setCountry(comboCountry.getValue());
        c.setDistinct(txtDistinct.getText());
        c.setPopulation(Long.valueOf(txtPopulation.getText()));
    }
    public void changeState(EnumFormState fs, City c) {
        switch (fs) {
            case ADD:
                txtName.setEditable(true);
                comboCountry.setEditable(true);
                txtDistinct.setEditable(true);
                txtPopulation.setEditable(true);


                txtName.setText("");
                comboCountry.setValue("");
                txtDistinct.setText("");
                txtPopulation.setText("");

                lvCities.setDisable(true);
                hBoxSaveCancel.setVisible(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;

            case EDIT:
                txtName.setEditable(true);
                comboCountry.setEditable(true);
                txtDistinct.setEditable(true);
                txtPopulation.setEditable(true);

                loadForm(c);

                lvCities.setDisable(true);
                hBoxSaveCancel.setVisible(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;

            case VIEW:
                txtName.setEditable(false);
                comboCountry.setEditable(false);
                txtDistinct.setEditable(false);
                txtPopulation.setEditable(false);

                loadForm(c);

                lvCities.setDisable(false);
                hBoxSaveCancel.setVisible(false);
                btnNew.setDisable(false);
                btnEdit.setDisable(false);
                btnDelete.setDisable(false);
                break;
        }
    }



}
