package com.example.legocollection;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<LegoSet> table;
    private TextField nameField, themeField, piecesField, priceField;
    private LegoController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new LegoController(new LegoRepository());
        
        TableColumn<LegoSet, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(50);

        TableColumn<LegoSet, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(200);

        TableColumn<LegoSet, String> themeCol = new TableColumn<>("Theme");
        themeCol.setCellValueFactory(new PropertyValueFactory<>("theme"));
        themeCol.setPrefWidth(150);

        TableColumn<LegoSet, Integer> piecesCol = new TableColumn<>("Pieces");
        piecesCol.setCellValueFactory(new PropertyValueFactory<>("pieces"));
        piecesCol.setPrefWidth(100);

        TableColumn<LegoSet, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setPrefWidth(100);

        table = new TableView<>();
        table.getColumns().addAll(idCol, nameCol, themeCol, piecesCol, priceCol);

        nameField = new TextField();
        nameField.setPromptText("Lego Set Name");

        themeField = new TextField();
        themeField.setPromptText("Theme (e.g., Star Wars, City)");

        piecesField = new TextField();
        piecesField.setPromptText("Number of Pieces");

        priceField = new TextField();
        priceField.setPromptText("Price");

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addLegoSet());

        Button updateBtn = new Button("Update");
        updateBtn.setOnAction(e -> updateLegoSet());

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> deleteLegoSet());

        Button clearBtn = new Button("Clear");
        clearBtn.setOnAction(e -> clearFields());

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(10));

        formGrid.add(new Label("Name:"), 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(new Label("Theme:"), 0, 1);
        formGrid.add(themeField, 1, 1);
        formGrid.add(new Label("Pieces:"), 0, 2);
        formGrid.add(piecesField, 1, 2);
        formGrid.add(new Label("Price:"), 0, 3);
        formGrid.add(priceField, 1, 3);

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(addBtn, updateBtn, deleteBtn, clearBtn);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(formGrid, buttonBox, table);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                populateFields(newVal);
            }
        });

        refreshTable();

        Scene scene = new Scene(mainLayout, 700, 500);
        primaryStage.setTitle("Lego Collection Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addLegoSet() {
        try {
            LegoSet legoSet = createLegoSetFromFields();
            controller.addLegoSet(legoSet);
            refreshTable();
            clearFields();
            showAlert("Success", "Lego set added successfully!", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void updateLegoSet() {
        LegoSet selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a Lego set to update", Alert.AlertType.WARNING);
            return;
        }

        try {
            LegoSet updatedSet = createLegoSetFromFields();
            controller.updateLegoSet(selected.getId(), updatedSet);
            refreshTable();
            clearFields();
            showAlert("Success", "Lego set updated successfully!", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void deleteLegoSet() {
        LegoSet selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a Lego set to delete", Alert.AlertType.WARNING);
            return;
        }

        controller.deleteLegoSet(selected.getId());
        refreshTable();
        clearFields();
        showAlert("Success", "Lego set deleted successfully!", Alert.AlertType.INFORMATION);
    }

    private LegoSet createLegoSetFromFields() {
        String name = nameField.getText().trim();
        String theme = themeField.getText().trim();
        String piecesText = piecesField.getText().trim();
        String priceText = priceField.getText().trim();

        if (name.isEmpty() || theme.isEmpty() || piecesText.isEmpty() || priceText.isEmpty()) {
            throw new IllegalArgumentException("All fields must be filled!");
        }

        int pieces = Integer.parseInt(piecesText);
        double price = Double.parseDouble(priceText);

        return new LegoSet(0, name, theme, pieces, price);
    }

    private void populateFields(LegoSet legoSet) {
        nameField.setText(legoSet.getName());
        themeField.setText(legoSet.getTheme());
        piecesField.setText(String.valueOf(legoSet.getPieces()));
        priceField.setText(String.valueOf(legoSet.getPrice()));
    }

    private void clearFields() {
        nameField.clear();
        themeField.clear();
        piecesField.clear();
        priceField.clear();
        table.getSelectionModel().clearSelection();
    }

    private void refreshTable() {
        table.getItems().clear();
        table.getItems().addAll(controller.getAllLegoSets());
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}