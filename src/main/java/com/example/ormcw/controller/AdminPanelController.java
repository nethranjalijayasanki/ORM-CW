package com.example.ormcw.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class AdminPanelController {
    @FXML
    private AnchorPane childRootNode;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label lblDate;


    public void initialize() throws IOException {
        AnchorPane dashRootNode = FXMLLoader.load(this.getClass().getResource("/com/example/ormcw/dashboard.fxmll"));
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        navigateTo("/com/example/ormcw/dashboard.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        AnchorPane loadNode = null;
        try {
            loadNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/com/example/ormcw/login-page.fxml")));
            Scene scene = new Scene(loadNode);
            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login form");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnProgramsOnAction(ActionEvent event) {
        navigateTo("/com/example/ormcw/programForm.fxml");
    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {
        navigateTo("/com/example/ormcw/enrollment.fxml");
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {
        navigateTo("/com/example/ormcw/passwordChange.fxml");
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        navigateTo("/com/example/ormcw/studentForm.fxml");
    }


    void navigateTo(String path){
        AnchorPane dashRootNode = null;
        try {
            dashRootNode = FXMLLoader.load(this.getClass().getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);
    }

    private void setDateTime() {
        LocalDate now = LocalDate.now();
        lblDate.setText(String.valueOf(now));
        /*LocalTime now1 = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        lblOrderTime.setText(String.valueOf(now1));*/

    }


}
