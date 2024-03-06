package org.cms.cateringmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CMSController {

    private List<Item> beverages = new ArrayList<>();
    private List<Item> rotiItems = new ArrayList<>();
    private List<Item> nonVeg = new ArrayList<>();
    private List<Item> veg = new ArrayList<>();
    private List<Item> dessert = new ArrayList<>();

    @FXML
    private VBox slNo;

    @FXML
    private VBox itemDescription;

    @FXML
    private VBox itemAmount;

    @FXML
    private Text totalAmount;
    @FXML
    private Text noOfPlates;
    @FXML
    private Text grandTotal;

    @FXML
    private VBox addressBox;
    private String customerName ;
    private String customerAddress;
    private String customerPhNo ;

    private int numOfPlates;
    @FXML
    private HBox hBoxHavingButton;

    public void setCustomerDetails(String cName, String cPhoneNo, String cAddress, int numOfPlates){
        this.customerName = cName;
        this.customerAddress = cAddress;
        this.customerPhNo = cPhoneNo;
        this.numOfPlates = numOfPlates;
    }

    private List<Item> checkedItems = new ArrayList<>();
    public void setCheckedItems(List<Item> cItems){
        checkedItems = new ArrayList<>(cItems);
    }
    public void switchToDetails(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("details.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Text newText(String str){
        return new Text(str);
    }
    public void addEstimate(){
        Iterator<Node> iterator = hBoxHavingButton.getChildren().iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setOnMouseClicked(null);
                iterator.remove();
            }
        }
        addressBox.getChildren().add(newText(customerName));
        addressBox.getChildren().add(newText(customerPhNo));
        addressBox.getChildren().add(newText(customerAddress));

        int serialNo = 0;
        double totalAm = 0d;
        System.out.println(checkedItems.size());
        for(Item checkedItem : checkedItems){
            slNo.getChildren().add(newText(String.valueOf(++serialNo)));
            itemDescription.getChildren().add(newText(checkedItem.getItemName()));
            itemAmount.getChildren().add(newText(checkedItem.getItemPrice() + "/-"));
            totalAm = totalAm + checkedItem.getItemPrice();
        }

       totalAmount.setText(totalAm + "/-");
        noOfPlates.setText(String.valueOf(numOfPlates));
        double gTotal = totalAm * numOfPlates;
        grandTotal.setText(String.valueOf(gTotal));


    }

}