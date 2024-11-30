package com.example.ormcw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import com.example.ormcw.bo.BOFactory;
import com.example.ormcw.bo.custom.UserBO;
import com.example.ormcw.entity.User;
import com.example.ormcw.util.PasswordUtil;
import com.example.ormcw.util.Regex;

public class PasswordChangeController {
    @FXML
    private TextField txtCurrentPassword;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);


    @FXML
    void btnSaveChangesOnAction(ActionEvent event) {
        User user = userBO.searchUserbyName(txtUserName.getText());
        String password =  txtCurrentPassword.getText();

        switch (isValied()){
            case 0: if (user != null) {
                String userName = user.getUserName();
                String dbPassword = user.getPassword();
                boolean isPassCorrect = PasswordUtil.verifyPassword(password, dbPassword);
                if (isPassCorrect) {
                    String newpassword  = txtNewPassword.getText();
                    String hashPass = PasswordUtil.hashPassword(newpassword);
                    boolean isPasswordUpdated = userBO.updateUserPassword(hashPass,userName);
                    if (isPasswordUpdated) {
                        new Alert(Alert.AlertType.ERROR,"Password updated successfully").show();
                    }else{
                        new Alert(Alert.AlertType.ERROR,"Password not updated successfully").show();
                    }

                }else {
                    new Alert(Alert.AlertType.ERROR,"Current Password not correct").show();
                }

            }else{
                new Alert(Alert.AlertType.ERROR,"User not found.").show();
            }
                break;

            case 1:
                new Alert(Alert.AlertType.ERROR,"Invalid user name").show();
                break;

            case 2:
                new Alert(Alert.AlertType.ERROR,"Invalid current password").show();
                break;

            case 3:
                new Alert(Alert.AlertType.ERROR,"Invalid new password").show();
                break;


        }


    }


    @FXML
    void txtCurrPassOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(com.example.ormcw.util.TextField.PASSWORD,txtCurrentPassword);
    }

    @FXML
    void txtNameOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(com.example.ormcw.util.TextField.NAME,txtUserName);
    }

    @FXML
    void txtNewPassOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(com.example.ormcw.util.TextField.PASSWORD,txtNewPassword);
    }

    public int isValied(){
        if (!Regex.setTextColor(com.example.ormcw.util.TextField.NAME,txtUserName)) return 1;
        if (!Regex.setTextColor(com.example.ormcw.util.TextField.PASSWORD,txtCurrentPassword)) return 2;
        if (!Regex.setTextColor(com.example.ormcw.util.TextField.PASSWORD,txtNewPassword)) return 3;

        return 0;
    }


}
