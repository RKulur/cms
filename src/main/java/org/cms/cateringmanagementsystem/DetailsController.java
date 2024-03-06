package org.cms.cateringmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailsController {
    private String customerName;
    private String customerPhoneNo;
    private String customerAddress;

    @FXML
    private TextField name;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextField address;
    @FXML
    private TextField noOfPlates;

    private boolean checkIfEmpty(TextField textField){
        return textField.getText().isEmpty();
    }
    private String getMessageIfEmpty(TextField name, TextField phoneNo, TextField address, TextField noOfPlates){
        StringBuilder message = new StringBuilder();
        if(!checkIfEmpty(name) && !checkIfEmpty(phoneNo) && !checkIfEmpty(address) && !checkIfEmpty(noOfPlates)){
            return message.toString();
        }
        message.append("Please fill the values of ");
        if(checkIfEmpty(name)){
            message.append("(NAME) ");
        }
        if(checkIfEmpty(phoneNo)){
            message.append("(PHONE NUMBER) ");
        }
        if(checkIfEmpty(address)){
            message.append("(ADDRESS) ");
        }
        if(checkIfEmpty(noOfPlates)){
            message.append("(NUMBER OF PLATES) ");
        }
        return message.toString();
    }

    private String getMessageIfIncorrectPhoneNumber(TextField phoneNo){
        StringBuilder message = new StringBuilder();
        try{
            Long.parseLong(phoneNo.getText());
        }catch (NumberFormatException e){
            message.append("Invalid (PHONE NUMBER)");
            return message.toString();
        }
        if(phoneNo.getText().length() < 10){
            message.append("(PHONE NUMBER) should be 10 digits");
        }
        return message.toString();
    }

    private String getMessageForHandlingNumberOfPlates(TextField noOfPlates){
        StringBuilder message = new StringBuilder();
        int num = 0;
        try{
            num = Integer.parseInt(noOfPlates.getText());
        }catch (NumberFormatException e){
            message.append("Enter integer values in \"Number of plates\"");
            return message.toString();
        }
        if(num < 50){
            message.append("Minimum number of plates are 50");
        }
        if(num > 500){
            message.append("Maximum number of plates are 500");
        }
        return message.toString();
    }

    private boolean handleForm(TextField name, TextField phoneNo, TextField address, TextField noOfPlates) {
        StringBuilder message = new StringBuilder();
        message.append(getMessageIfEmpty(name, phoneNo, address, noOfPlates));
        message.append("\n");
        message.append(getMessageIfIncorrectPhoneNumber(phoneNo));
        message.append("\n");
        message.append(getMessageForHandlingNumberOfPlates(noOfPlates));
        boolean messageIsEmpty = message.toString().trim().isEmpty();
        if(messageIsEmpty){
            return true;
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Something is wrong in the form");
        alert.setContentText(message.toString());
        alert.showAndWait();
        return false;
    }

    public void switchToSelection(MouseEvent event) throws IOException {
        boolean isFormValid = handleForm(name, phoneNo, address, noOfPlates);
        if(isFormValid) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selection.fxml"));
            Parent root = loader.load();
            SelectionController selectionController = loader.getController();
            selectionController.setCustomerDetails(name.getText(), phoneNo.getText(), address.getText(), Integer.parseInt(noOfPlates.getText()));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
