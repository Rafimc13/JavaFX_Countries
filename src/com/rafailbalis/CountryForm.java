package com.rafailbalis;

import com.rafailbalis.AutoCompleteComboBoxListener;
import com.rafailbalis.Country;
import com.rafailbalis.EnumFormState;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.time.Year;
import java.time.YearMonth;

public class CountryForm {
    Stage stage;
    Label lbCode3, lbName, lbContinent, lbRegion,
            lbSurfArea, lbIndYear, lbPopulation,
            lbLifeExp, lbGNP, lbLocalName, lbGovForm,
            lbHeadofState, lbCapital, lbCode2;

    Button btnNew, btnEdit, btnDelete;
    Button btnSave, btnCancel2;


    TextField txtCode3, txtName, txtRegion,
            txtSurfArea, txtIndYear, txtPopulation,
            txtLifeExp, txtGNP, txtLocalName, txtGovForm,
            txtHeadofState, txtCapital, txtCode2;
    ComboBox<String> comboContinent;

    ListView<Country> lvCountries;

    EnumFormState FormState;


    HBox hBoxAddEditDel, hBoxSaveCancel;
    private Country aruba, afghanistan, angola, anguilla;


    public CountryForm() {

        aruba = new Country("ABW", "Aruba", "North America",
                "Caribbean", 193.0, null, 103000L,
                78.4, 828.0, 793.0, "Aruba",
                "Nonmetropolitan Territory of the Netherlands",
                "Beatrix", 129, "AW");
        afghanistan = new Country("AFG", "Afghanistan", "Asia",
                "Southern and Central Asia", 652090.0, 1919, 22720000L,
                45.9, 5976.0, null, "Afganistan",
                "Islamic Emirate",
                "Mohammad Omar", 1, "AF");
        angola = new Country("AGO", "Angola", "Central Africa",
                "Southern and Central Asia", 1246700.0, 1975, 12878000L,
                38.3, 6648.0, 7984.0, "Angola",
                "Republic",
                "Jose Eduardo dos Santos", 56, "AO");
        anguilla = new Country("AIA", "Anguilla", "North America",
                "Caribbean", 96.0, null, 8000L,
                76.1, 63.2, null, "Anguilla",
                "Dependent Territory of the UK",
                "Elisabeth II", 62, "AI");

//        show();
//    }


//    public void show() {
        lbCode3 = new Label("Code:");
        lbName = new Label("Name:");
        lbContinent = new Label("Continent:");
        lbRegion = new Label("Region:");
        lbSurfArea = new Label("Surface Area:");
        lbIndYear = new Label("Independence Year:");
        lbPopulation = new Label("Population:");
        lbLifeExp = new Label("Life Expectancy:");
        lbGNP = new Label("GNP:");
        lbLocalName = new Label("Local Name:");
        lbGovForm = new Label("Government Form:");
        lbHeadofState = new Label("Head of State:");
        lbCapital = new Label("Capital:");
        lbCode2 = new Label("Code2:");

        txtCode3 = new TextField();
        txtName = new TextField();
        comboContinent = new ComboBox<String>();
        comboContinent.getItems().addAll("Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America");
        comboContinent.setEditable(true);
        new AutoCompleteComboBoxListener<>(comboContinent);
        txtRegion = new TextField();
        txtSurfArea = new TextField();
        txtIndYear = new TextField();
        txtPopulation = new TextField();
        txtLifeExp = new TextField();
        txtGNP = new TextField();
        txtLocalName = new TextField();
        txtGovForm = new TextField();
        txtHeadofState = new TextField();
        txtCapital = new TextField();
        txtCode2 = new TextField();


        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(5));
        mainPane.setHgap(3);
        mainPane.setVgap(5);
        mainPane.setAlignment(Pos.TOP_CENTER);

        mainPane.add(lbCode3, 1, 0);
        GridPane.setHalignment(lbCode3, HPos.RIGHT);
        GridPane.setValignment(lbCode3, VPos.CENTER);
        mainPane.add(txtCode3, 2, 0);
        GridPane.setHalignment(txtCode3, HPos.RIGHT);
        GridPane.setValignment(txtCode3, VPos.CENTER);

        mainPane.add(lbName, 1, 1);
        GridPane.setHalignment(lbName, HPos.RIGHT);
        GridPane.setValignment(lbName, VPos.CENTER);
        mainPane.add(txtName, 2, 1);
        GridPane.setHalignment(txtName, HPos.RIGHT);
        GridPane.setValignment(txtName, VPos.CENTER);

        mainPane.add(lbContinent, 1, 2);
        GridPane.setHalignment(lbContinent, HPos.RIGHT);
        GridPane.setValignment(lbContinent, VPos.CENTER);
        mainPane.add(comboContinent, 2, 2);
        GridPane.setHalignment(comboContinent, HPos.LEFT);
        GridPane.setValignment(comboContinent, VPos.CENTER);

        mainPane.add(lbRegion, 1, 3);
        GridPane.setHalignment(lbRegion, HPos.RIGHT);
        GridPane.setValignment(lbRegion, VPos.CENTER);
        mainPane.add(txtRegion, 2, 3);
        GridPane.setHalignment(txtRegion, HPos.RIGHT);
        GridPane.setValignment(txtRegion, VPos.CENTER);

        mainPane.add(lbSurfArea, 1, 4);
        GridPane.setHalignment(lbSurfArea, HPos.RIGHT);
        GridPane.setValignment(lbSurfArea, VPos.CENTER);
        mainPane.add(txtSurfArea, 2, 4);
        GridPane.setHalignment(txtSurfArea, HPos.RIGHT);
        GridPane.setValignment(txtSurfArea, VPos.CENTER);

        mainPane.add(lbIndYear, 1, 5);
        GridPane.setHalignment(lbIndYear, HPos.RIGHT);
        GridPane.setValignment(lbIndYear, VPos.CENTER);
        mainPane.add(txtIndYear, 2, 5);
        GridPane.setHalignment(txtIndYear, HPos.RIGHT);
        GridPane.setValignment(txtIndYear, VPos.CENTER);

        mainPane.add(lbPopulation, 1, 6);
        GridPane.setHalignment(lbPopulation, HPos.RIGHT);
        GridPane.setValignment(lbPopulation, VPos.CENTER);
        mainPane.add(txtPopulation, 2, 6);
        GridPane.setHalignment(txtPopulation, HPos.RIGHT);
        GridPane.setValignment(txtPopulation, VPos.CENTER);

        mainPane.add(lbLifeExp, 1, 7);
        GridPane.setHalignment(lbLifeExp, HPos.RIGHT);
        GridPane.setValignment(lbLifeExp, VPos.CENTER);
        mainPane.add(txtLifeExp, 2, 7);
        GridPane.setHalignment(txtLifeExp, HPos.RIGHT);
        GridPane.setValignment(txtLifeExp, VPos.CENTER);

        mainPane.add(lbGNP, 1, 8);
        GridPane.setHalignment(lbGNP, HPos.RIGHT);
        GridPane.setValignment(lbGNP, VPos.CENTER);
        mainPane.add(txtGNP, 2, 8);
        GridPane.setHalignment(txtGNP, HPos.RIGHT);
        GridPane.setValignment(txtGNP, VPos.CENTER);

        mainPane.add(lbLocalName, 1, 9);
        GridPane.setHalignment(lbLocalName, HPos.RIGHT);
        GridPane.setValignment(lbLocalName, VPos.CENTER);
        mainPane.add(txtLocalName, 2, 9);
        GridPane.setHalignment(txtLocalName, HPos.RIGHT);
        GridPane.setValignment(txtLocalName, VPos.CENTER);

        mainPane.add(lbGovForm, 1, 10);
        GridPane.setHalignment(lbGovForm, HPos.RIGHT);
        GridPane.setValignment(lbGovForm, VPos.CENTER);
        mainPane.add(txtGovForm, 2, 10);
        GridPane.setHalignment(txtGovForm, HPos.RIGHT);
        GridPane.setValignment(txtGovForm, VPos.CENTER);

        mainPane.add(lbHeadofState, 1, 11);
        GridPane.setHalignment(lbHeadofState, HPos.RIGHT);
        GridPane.setValignment(lbHeadofState, VPos.CENTER);
        mainPane.add(txtHeadofState, 2, 11);
        GridPane.setHalignment(txtHeadofState, HPos.RIGHT);
        GridPane.setValignment(txtHeadofState, VPos.CENTER);

        mainPane.add(lbCapital, 1, 12);
        GridPane.setHalignment(lbCapital, HPos.RIGHT);
        GridPane.setValignment(lbCapital, VPos.CENTER);
        mainPane.add(txtCapital, 2, 12);
        GridPane.setHalignment(txtCapital, HPos.RIGHT);
        GridPane.setValignment(txtCapital, VPos.CENTER);

        mainPane.add(lbCode2, 1, 13);
        GridPane.setHalignment(lbCode2, HPos.RIGHT);
        GridPane.setValignment(lbCode2, VPos.CENTER);
        mainPane.add(txtCode2, 2, 13);
        GridPane.setHalignment(txtCode2, HPos.RIGHT);
        GridPane.setValignment(txtHeadofState, VPos.CENTER);


        btnSave = new Button("Save");
        btnSave.setOnAction(e-> {
            if (validateForm()) {
                System.out.println("Validate: OK");
                if (FormState == EnumFormState.EDIT) {
                    Country c = lvCountries.getSelectionModel().getSelectedItem();
                    save_form(c);
                    FormState = EnumFormState.VIEW;
                    changeState(FormState, c);
                }
                else if (FormState == EnumFormState.ADD) {
                    Country c = new Country();
                    save_form(c);
                    FormState = EnumFormState.VIEW;
                    lvCountries.getItems().add(c);
                    lvCountries.getSelectionModel().select(c);
                    changeState(FormState, c);
                }
            }
        });


        btnCancel2 = new Button("Cancel");
        btnCancel2.setOnAction(e -> {
            FormState = EnumFormState.VIEW;
            changeState(FormState, lvCountries.getSelectionModel().getSelectedItem());
        });


        hBoxSaveCancel = new HBox();
        hBoxSaveCancel.getChildren().addAll(btnSave, btnCancel2);
        hBoxSaveCancel.setSpacing(5);
        hBoxSaveCancel.setAlignment(Pos.CENTER_LEFT);
        mainPane.add(hBoxSaveCancel, 2, 17);
        GridPane.setColumnSpan(hBoxSaveCancel, 1);

        lvCountries = new ListView<>();
        lvCountries.getItems().addAll(aruba, afghanistan, angola, anguilla);
        lvCountries.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    loadForm(newValue);
                    System.out.println(newValue);
                });

        mainPane.add(lvCountries, 0, 0);
        GridPane.setRowSpan(lvCountries, mainPane.getRowCount() + 1);
        GridPane.setHalignment(lvCountries, HPos.LEFT);


        btnNew = new Button();
        btnNew.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\add35.png")));
        btnNew.setPrefWidth(lvCountries.getWidth() / 3 - 3);
        btnNew.setOnAction(e -> {
            FormState = EnumFormState.ADD;
            changeState(FormState, null);
        });

        btnEdit = new Button();
        btnEdit.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\edit35.png")));
        btnEdit.setPrefWidth(lvCountries.getWidth() / 3 - 3);
        btnEdit.setOnAction(e -> {
            FormState = EnumFormState.EDIT;
            changeState(FormState, lvCountries.getSelectionModel().getSelectedItem());
        });

        btnDelete = new Button();
        btnDelete.setGraphic(new ImageView(new Image("C:\\Users\\joker\\IdeaProjects\\JavaFX_Countries\\src\\com\\rafailbalis\\del35.png")));
        btnDelete.setPrefWidth(lvCountries.getWidth() / 3 - 3);
        btnDelete.setOnAction(e -> {
            MessageOKCancel m = new MessageOKCancel("Are you sure?", "Warning");
            boolean response = m.getResponse();
            if (response) {
                lvCountries.getItems().remove(lvCountries.getSelectionModel().getSelectedItem());
                if (lvCountries.getItems().size() > 0) {
                    lvCountries.getSelectionModel().select(0);
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

        // the scene
        Scene scene = new Scene(mainPane);
        scene.heightProperty().addListener(
                (observable, oldValue, newValue) -> {
                    mainPane.setPrefHeight(scene.getHeight());
                    lvCountries.setPrefHeight(scene.getHeight());
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

        lvCountries.getSelectionModel().select(0);
        FormState = EnumFormState.VIEW;
        changeState(FormState, lvCountries.getSelectionModel().getSelectedItem());

        stage.show();
    }

    public boolean validateForm() {
        String errors = "";
            String Code3 = txtCode3.getText();
        if (Code3.length() != 3) {
            errors += "Code must be exactly 3 characters\n";
        }
//        if (Code3.isBlank()) {
//            errors += "Code3 can't be empty\n";
//        }
        String name = txtName.getText();
        if (name.length() > 52) {
            errors += "Name can't exceed 52 characters\n";
        }
        if (name.isBlank()) {
            errors += "Name can't be empty\n";
        }
        String Continent = comboContinent.getValue();
        if (!comboContinent.getItems().contains(Continent)) {
            errors += "Continent must be a valid Value\n";
        }
        String region = txtRegion.getText();
        if (region.length() > 26) {
            errors += "Region can't exceed 26 characters\n";
        }
        if (region.isBlank()) {
            errors += "Region can't be empty\n";
        }
        Double surfaceArea = null;
        try {
            surfaceArea = Double.valueOf(txtSurfArea.getText());
        } catch (NumberFormatException b) {
            errors += "Surface Area must be a number\n";
        }
        Integer IndependenceYear = null;
        try {
            IndependenceYear = Integer.valueOf(txtIndYear.getText());
            int CurrentYear = YearMonth.now().getYear();
            if (IndependenceYear > CurrentYear) {
                errors += "Independence can't exceed the current year\n";
            }
        } catch (NumberFormatException b) {
            if (txtIndYear.getText().length() > 0) {
                errors += "Independence Year must be a number\n";
            }
        }
        Long population = null;
        try {
            population = Long.valueOf(txtPopulation.getText());
            if (population<0 || population>10000000000L)
                errors += "Invalid Population\n";
        } catch (NumberFormatException ob) {
            errors += "Population must be a number\n";
        }
        Double LifeExpectancy=null;
        try {
            LifeExpectancy = Double.valueOf(txtLifeExp.getText());
        } catch (NumberFormatException b) {
            if (txtLifeExp.getText().length()!=0) {
                errors += "Life Expectancy must be a number\n";
            }
        }
        Double GNP = null;
        try {
            GNP = Double.valueOf(txtGNP.getText());
        } catch (NumberFormatException b) {
            if (txtGNP.getText().length() != 0) {
                errors += "GNP must be a Double number\n";
            }
        }
        String LocalName = txtLocalName.getText();
        if (LocalName.length() > 45) {
            errors += "Local Name can't exceed 45 characters\n";
        }
        if (LocalName.isBlank()) {
            errors += "Local Name can't be empty\n";
        }
        String GovForm = txtGovForm.getText();
        if (GovForm.length() > 45) {
            errors += "Government Form can't exceed 45 characters\n";
        }
        if (GovForm.isBlank()) {
            errors += "Government Form can't be empty\n";
        }
        String HeadOfState = txtHeadofState.getText();
        if (HeadOfState.length() > 60) {
            errors += "Head of State can't exceed 60 characters\n";
        }
        Integer Capital = null;
        try {
            Capital = Integer.valueOf(txtCapital.getText());
        } catch (NumberFormatException b) {
            if (txtCapital.getText().length()!=0) {
                errors += "Capital must be a number\n";
            }
        }
        String Code2 = txtCode2.getText();
        if (Code2.length() != 2) {
            errors += "Code2 must be exactly two numbers\n";
        }
        if (Code2.isBlank()) {
            errors += "Code2 can't be empty\n";
        }
        if (errors.length()>0) {
            boolean response;
            MessageOKCancel m = new MessageOKCancel(errors, "ERRORS");
            response = m.getResponse();
            System.out.println(response);
            return false;
        } else {
            String output =
                    "code3: " + Code3+ "\n" +
                            "name: " + name + "\n" +
                            "continent: " + Continent + "\n" +
                            "region: " + region + "\n" +
                            "surface area: " + surfaceArea + "\n" +
                            "independence year: " + IndependenceYear + "\n" +
                            "population: " + population + "\n" +
                            "life expectancy: " + LifeExpectancy + "\n" +
                            "GNP: " + GNP + "\n" +
                            "local name: " + LocalName + "\n" +
                            "government form: " + GovForm + "\n" +
                            "head of state: " + HeadOfState + "\n" +
                            "capital: " + Capital + "\n" +
                            "code2: " + Code2 + "\n";
            System.out.println(output);
            return true;
        }
    }

    public void loadForm(Country c) {
        txtCode3.setText(c.getCode());
        txtName.setText(c.getName());
        comboContinent.setValue(c.getContinent());
        txtRegion.setText(c.getRegion());
        txtSurfArea.setText(c.getSurfaceArea().toString());
        txtIndYear.setText(c.getIndepYear() == null ? "" : c.getIndepYear().toString());
        txtPopulation.setText(c.getPopulation().toString());
        txtLifeExp.setText(c.getLifeExpectancy() == null ? "" : c.getLifeExpectancy().toString());
        txtGNP.setText(c.getGNP() == null ? "" : c.getGNP().toString());
        txtLocalName.setText(c.getLocalName());
        txtGovForm.setText(c.getGovernmentForm());
        txtHeadofState.setText(c.getHeadOfState() == null ? "" : c.getHeadOfState());
        txtCapital.setText(c.getCapital() == null ? "" : c.getCapital().toString());
        txtCode2.setText(c.getCode2());
    }

    public void save_form(Country c) {
        c.setCode(txtCode3.getText());
        c.setName(txtName.getText());
        c.setContinent(comboContinent.getValue());
        c.setRegion(txtRegion.getText());
        c.setSurfaceArea(Double.valueOf(txtSurfArea.getText()));
        c.setIndepYear(txtIndYear.getText().equals("") ? null : Integer.valueOf(txtIndYear.getText()));
        c.setPopulation(Long.valueOf(txtPopulation.getText()));
        c.setLifeExpectancy(txtLifeExp.getText().equals("") ? null : Double.valueOf(txtLifeExp.getText()));
        c.setGNP(txtGNP.getText().equals("") ? null : Double.valueOf(txtGNP.getText()));
        c.setLocalName(txtLocalName.getText());
        c.setGovernmentForm(txtGovForm.getText());
        c.setHeadOfState(txtHeadofState.getText().equals("") ? null : txtHeadofState.getText());
        c.setCapital(txtCapital.getText().equals("") ? null : Integer.valueOf(txtCapital.getText()));
        c.setCode2(txtCode2.getText());
    }


    public void changeState(EnumFormState fs, Country c) {
        switch (fs) {
            case ADD:
                txtCode3.setEditable(true);
                txtName.setEditable(true);
                comboContinent.setEditable(true);
                txtRegion.setEditable(true);
                txtSurfArea.setEditable(true);
                txtIndYear.setEditable(true);
                txtPopulation.setEditable(true);
                txtLifeExp.setEditable(true);
                txtGNP.setEditable(true);
                txtLocalName.setEditable(true);
                txtGovForm.setEditable(true);
                txtHeadofState.setEditable(true);
                txtCapital.setEditable(true);
                txtCode2.setEditable(true);

                txtCode3.setText("");
                txtName.setText("");
                comboContinent.setValue("");
                txtRegion.setText("");
                txtSurfArea.setText("");
                txtIndYear.setText("");
                txtPopulation.setText("");
                txtLifeExp.setText("");
                txtGNP.setText("");
                txtLocalName.setText("");
                txtGovForm.setText("");
                txtHeadofState.setText("");
                txtCapital.setText("");
                txtCode2.setText("");

                lvCountries.setDisable(true);
                hBoxSaveCancel.setVisible(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;

            case EDIT:
                txtCode3.setEditable(true);
                txtName.setEditable(true);
                comboContinent.setEditable(true);
                txtRegion.setEditable(true);
                txtSurfArea.setEditable(true);
                txtIndYear.setEditable(true);
                txtPopulation.setEditable(true);
                txtLifeExp.setEditable(true);
                txtGNP.setEditable(true);
                txtLocalName.setEditable(true);
                txtGovForm.setEditable(true);
                txtHeadofState.setEditable(true);
                txtCapital.setEditable(true);
                txtCode2.setEditable(true);

                loadForm(c);

                lvCountries.setDisable(true);
                hBoxSaveCancel.setVisible(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;

            case VIEW:
                txtCode3.setEditable(false);
                txtName.setEditable(false);
                comboContinent.setEditable(false);
                txtRegion.setEditable(false);
                txtSurfArea.setEditable(false);
                txtIndYear.setEditable(false);
                txtPopulation.setEditable(false);
                txtLifeExp.setEditable(false);
                txtGNP.setEditable(false);
                txtLocalName.setEditable(false);
                txtGovForm.setEditable(false);
                txtHeadofState.setEditable(false);
                txtCapital.setEditable(false);
                txtCode2.setEditable(false);

                loadForm(c);

                lvCountries.setDisable(false);
                hBoxSaveCancel.setVisible(false);
                btnNew.setDisable(false);
                btnEdit.setDisable(false);
                btnDelete.setDisable(false);
                break;

        }
    }
}