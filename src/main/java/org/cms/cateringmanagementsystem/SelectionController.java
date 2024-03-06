package org.cms.cateringmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class SelectionController {
    @FXML
    private CheckBox b_limeJuice;
    @FXML
    private CheckBox b_pepperPanaka;
    @FXML
    private CheckBox b_mangoJuice;
    @FXML
    private CheckBox b_chikooMilkshake;
    @FXML
    private CheckBox b_watermelonJuice;
    @FXML
    private CheckBox b_bondaMilkshake;
    @FXML
    private CheckBox b_pistaMilkshake;
    @FXML
    private CheckBox b_sugarcaneJuice;
    @FXML
    private CheckBox r_tandooriNaan;
    @FXML
    private CheckBox r_garlicNaan;
    @FXML
    private CheckBox r_parota;
    @FXML
    private CheckBox r_alooParatha;
    @FXML
    private CheckBox r_butterNaan;
    @FXML
    private CheckBox r_chapati;
    @FXML
    private CheckBox r_rumalRoti;
    @FXML
    private CheckBox r_methiParatha;
    @FXML
    private CheckBox nv_s_greenKebab;
    @FXML
    private CheckBox nv_s_chickenTikka;
    @FXML
    private CheckBox nv_s_chickenGheeroast;
    @FXML
    private CheckBox nv_s_chickenManchurian;
    @FXML
    private CheckBox nv_s_chickenUrval;
    @FXML
    private CheckBox nv_s_chicken65;
    @FXML
    private CheckBox nv_s_chickenLollipop;
    @FXML
    private CheckBox nv_s_chickenSoup;
    @FXML
    private CheckBox nv_s_chickenMasala;
    @FXML
    private CheckBox nv_s_muttonPepperdry;
    @FXML
    private CheckBox nv_s_muttonGheeroast;
    @FXML
    private CheckBox nv_s_muttonSoup;
    @FXML
    private CheckBox nv_s_prawnsChilli;
    @FXML
    private CheckBox nv_s_bangudeTawafry;
    @FXML
    private CheckBox nv_s_prawnsManchurian;
    @FXML
    private CheckBox nv_s_prawnsTandoori;
    @FXML
    private CheckBox nv_s_null;
    @FXML
    private CheckBox nv_s_anjalTawafry;
    @FXML
    private CheckBox nv_s_maruvaiSukka;
    @FXML
    private CheckBox nv_s_bangudeMasalafry;
    @FXML
    private CheckBox nv_r_gheeRice;
    @FXML
    private CheckBox nv_r_jiraRice;
    @FXML
    private CheckBox nv_r_lemonRice;
    @FXML
    private CheckBox nv_r_chickenBiryani;
    @FXML
    private CheckBox nv_r_chickenTikkabiryani;
    @FXML
    private CheckBox nv_r_chickenHydrabadibiryani;
    @FXML
    private CheckBox nv_r_chickenKalmibiryani;
    @FXML
    private CheckBox nv_r_muttonBiryani;
    @FXML
    private CheckBox nv_r_eggBiryani;
    @FXML
    private CheckBox nv_r_whiteRice;
    @FXML
    private CheckBox nv_r_boiledRice;
    @FXML
    private CheckBox nv_r_muttonHydrabadibiryani;
    @FXML
    private CheckBox nv_m_chickenSukka;
    @FXML
    private CheckBox nv_m_chickenTikkamasala;
    @FXML
    private CheckBox nv_m_butterChicken;
    @FXML
    private CheckBox nv_m_muttonSukka;
    @FXML
    private CheckBox nv_m_muttonMasala;
    @FXML
    private CheckBox nv_m_muttonKadai;
    @FXML
    private CheckBox v_s_palya;
    @FXML
    private CheckBox v_s_paneerKebab;
    @FXML
    private CheckBox v_s_paneerGheeroast;
    @FXML
    private CheckBox v_s_mushroomManchurian;
    @FXML
    private CheckBox v_s_gobiChilli;
    @FXML
    private CheckBox v_s_paneerTikka;
    @FXML
    private CheckBox v_s_babycornChilli;
    @FXML
    private CheckBox v_s_tomatoSoup;
    @FXML
    private CheckBox v_s_mushroomSoup;
    @FXML
    private CheckBox v_s_gobiManchurian;
    @FXML
    private CheckBox v_m_paneerGravy;
    @FXML
    private CheckBox v_m_paneerKadai;
    @FXML
    private CheckBox v_m_paneerMasala;
    @FXML
    private CheckBox v_m_mushroomMasala;
    @FXML
    private CheckBox v_m_mushroomKadai;
    @FXML
    private CheckBox v_m_vegMasala;
    @FXML
    private CheckBox v_m_daal;
    @FXML
    private CheckBox v_m_rasam;
    @FXML
    private CheckBox v_r_mushroomBiryani;
    @FXML
    private CheckBox v_r_paneerBiryani;
    @FXML
    private CheckBox d_vanilla;
    @FXML
    private CheckBox d_strawberry;
    @FXML
    private CheckBox d_chocolate;
    @FXML
    private CheckBox d_pineapple;
    @FXML
    private CheckBox d_tendercoconut;
    @FXML
    private CheckBox d_blueberry;
    @FXML
    private CheckBox d_chikku;
    @FXML
    private CheckBox d_butterscotch;

    private List<Item> beverages = new ArrayList<>();
    private List<Item> rotiItems = new ArrayList<>();
    private List<Item> nonVeg = new ArrayList<>();
    private List<Item> veg = new ArrayList<>();
    private List<Item> dessert = new ArrayList<>();

    private String customerName ;
    private String customerAddress;
    private String customerPhNo ;
    private int numOfPlates;
    public void addItems() {
        beverages.add(new Item("b", b_limeJuice, "Lime Juice", 7.00));
        beverages.add(new Item("b", b_pepperPanaka, "Pepper Panaka", 7.00));
        beverages.add(new Item("b", b_mangoJuice, "Mango Juice", 15.00));
        beverages.add(new Item("b", b_chikooMilkshake, "Chikoo Milkshake", 20.00));
        beverages.add(new Item("b", b_watermelonJuice, "Watermelon Juice", 15.00));
        beverages.add(new Item("b", b_bondaMilkshake, "Bonda Milkshake", 30.00));
        beverages.add(new Item("b", b_pistaMilkshake, "Pista Milkshake", 25.00));
        beverages.add(new Item("b", b_sugarcaneJuice, "Sugarcane Juice", 20.00));


        rotiItems.add(new Item("r", r_tandooriNaan, "Tandoori Naan", 25.00));
        rotiItems.add(new Item("r", r_garlicNaan, "Garlic Naan", 30.00));
        rotiItems.add(new Item("r", r_butterNaan, "Butter Naan", 40.00));
        rotiItems.add(new Item("r", r_parota, "Parota", 15.00));
        rotiItems.add(new Item("r", r_chapati, "Chapati", 10.00));
        rotiItems.add(new Item("r", r_rumalRoti, "Rumal Roti", 15.00));
        rotiItems.add(new Item("r", r_alooParatha, "Aloo Paratha", 40.00));
        rotiItems.add(new Item("r", r_methiParatha, "Methi Paratha", 40.00));


        nonVeg.add(new Item("starters", nv_s_greenKebab, "Green Kebab", 40.00));
        nonVeg.add(new Item("starters", nv_s_chickenTikka, "Chicken Tikka", 50.00));
        nonVeg.add(new Item("starters", nv_s_chickenGheeroast, "Chicken Ghee Roast", 45.00));
        nonVeg.add(new Item("starters", nv_s_chickenManchurian, "Chicken Manchurian", 70.00));
        nonVeg.add(new Item("starters", nv_s_chickenUrval, "Chicken Urval", 80.00));
        nonVeg.add(new Item("starters", nv_s_chicken65, "Chicken 65", 70.00));
        nonVeg.add(new Item("starters", nv_s_chickenLollipop, "ChickenLollipop", 80.00));
        nonVeg.add(new Item("starters", nv_s_chickenSoup, "Chicken Soup", 80.00));
        nonVeg.add(new Item("starters", nv_s_chickenMasala, "Chicken Masala", 65.00));
        nonVeg.add(new Item("starters", nv_s_muttonPepperdry, "Mutton Pepper Dry", 120.00));
        nonVeg.add(new Item("starters", nv_s_muttonGheeroast, "Mutton Ghee Roast", 160.00));
        nonVeg.add(new Item("starters", nv_s_muttonSoup, "Mutton Soup", 140.00));
        nonVeg.add(new Item("starters", nv_s_prawnsChilli, "Prawns Chilli", 200.00));
        nonVeg.add(new Item("starters", nv_s_prawnsManchurian, "Prawns Manchurian", 220.00));
        nonVeg.add(new Item("starters", nv_s_prawnsTandoori, "Prawns Tandoori", 240.00));
        nonVeg.add(new Item("starters", nv_s_anjalTawafry, "Anjal Tawa Fry", 100.00));
        nonVeg.add(new Item("starters", nv_s_bangudeMasalafry, "Bangude Masala Fry", 80.00));
        nonVeg.add(new Item("starters", nv_s_bangudeTawafry, "Bangude Tawa Fry", 70.00));
        nonVeg.add(new Item("starters", nv_s_maruvaiSukka, "Maruvai Sukka", 240.00));
        nonVeg.add(new Item("starters", nv_s_null, "Null", 00.00));
        nonVeg.add(new Item("riceItems", nv_r_gheeRice, "Ghee Rice", 50.00));
        nonVeg.add(new Item("riceItems", nv_r_jiraRice, "Jira Rice", 55.00));
        nonVeg.add(new Item("riceItems", nv_r_lemonRice, "Lemon Rice", 30.00));
        nonVeg.add(new Item("riceItems", nv_r_whiteRice, "White Rice", 20.00));
        nonVeg.add(new Item("riceItems", nv_r_boiledRice, "Boiled Rice", 25.00));
        nonVeg.add(new Item("riceItems", nv_r_chickenBiryani, "Chicken Biryani", 70.00));
        nonVeg.add(new Item("riceItems", nv_r_chickenHydrabadibiryani, "Chicken Hydrabadi Biryani", 90.00));
        nonVeg.add(new Item("riceItems", nv_r_chickenKalmibiryani, "Chicken Kalmi Biryani", 90.00));
        nonVeg.add(new Item("riceItems", nv_r_muttonBiryani, "Mutton Biryani", 120.00));
        nonVeg.add(new Item("riceItems", nv_r_eggBiryani, "Egg Biryani", 60.00));
        nonVeg.add(new Item("riceItems", nv_r_muttonHydrabadibiryani, "Mutton Hydrabadi Biryani", 180.00));
        nonVeg.add(new Item("riceItems", nv_r_chickenTikkabiryani, "Chicken Tikka Biryani", 95.00));
        nonVeg.add(new Item("mainCourse", nv_m_chickenSukka, "Chicken Sukka", 90.00));
        nonVeg.add(new Item("mainCourse", nv_m_chickenTikkamasala, "Chicken Tikka Masala", 95.00));
        nonVeg.add(new Item("mainCourse", nv_m_butterChicken, "Butter Chicken", 120.00));
        nonVeg.add(new Item("mainCourse", nv_m_muttonSukka, "Mutton Sukka", 185.00));
        nonVeg.add(new Item("mainCourse", nv_m_muttonKadai, "Mutton Kadai", 200.00));
        nonVeg.add(new Item("mainCourse", nv_m_muttonMasala, "Mutton Masala", 170.00));


        veg.add(new Item("starters", v_s_palya, "Palya", 20.00));
        veg.add(new Item("starters", v_s_paneerKebab, "Paneer Kebab", 30.00));
        veg.add(new Item("starters", v_s_paneerGheeroast, "Paneer Ghee Roast", 40.00));
        veg.add(new Item("starters", v_s_mushroomManchurian, "Mushroom Manchurian", 70.00));
        veg.add(new Item("starters", v_s_gobiChilli, "Gobi Chilli", 60.00));
        veg.add(new Item("starters", v_s_paneerTikka, "Paneer Tikka", 50.00));
        veg.add(new Item("starters", v_s_babycornChilli, "Babycorn Chilli", 90.00));
        veg.add(new Item("starters", v_s_tomatoSoup, "Tomato Soup", 60.00));
        veg.add(new Item("starters", v_s_mushroomSoup, "Mushroom Soup", 70.00));
        veg.add(new Item("starters", v_s_gobiManchurian, "Gobi Manchurian", 60.00));
        veg.add(new Item("riceItems", v_r_mushroomBiryani, "Mushroom Biryani", 80.00));
        veg.add(new Item("riceItems", v_r_paneerBiryani, "Paneer Biryani", 75.00));
        veg.add(new Item("mainCourse", v_m_paneerGravy, "Paneer Gravy", 75.00));
        veg.add(new Item("mainCourse", v_m_paneerKadai, "Paneer Kadai", 85.00));
        veg.add(new Item("mainCourse", v_m_paneerMasala, "Paneer Masala", 70.00));
        veg.add(new Item("mainCourse", v_m_mushroomKadai, "Mushroom Kadai", 95.00));
        veg.add(new Item("mainCourse", v_m_mushroomMasala, "Mushroom Masala", 85.00));
        veg.add(new Item("mainCourse", v_m_vegMasala, "Veg Masala", 55.00));
        veg.add(new Item("mainCourse", v_m_daal, "Daal", 35.00));
        veg.add(new Item("mainCourse", v_m_rasam, "Rasam", 25.00));


        dessert.add(new Item("d", d_vanilla, "Vanilla Icecream", 25.00));
        dessert.add(new Item("d", d_butterscotch, "Butterscotch Icecream", 35.00));
        dessert.add(new Item("d", d_chikku, "Chikku Icecream", 45.00));
        dessert.add(new Item("d", d_blueberry, "Blueberry Icecream", 55.00));
        dessert.add(new Item("d", d_strawberry, "Strawberry Icecream", 55.00));
        dessert.add(new Item("d", d_chocolate, "Chocolate Icecream", 35.00));
        dessert.add(new Item("d", d_pineapple, "Pineapple Icecream", 25.00));
        dessert.add(new Item("d", d_tendercoconut, "Tendercoconut Icecream", 75.00));
    }
    public void checkItems(List<Item> items, List<Item> checkedItems){
        System.out.println("inside check items");
        System.out.println(items.size());
        for(Item item : items){
            if(item.isItemSelected()){
                checkedItems.add(item);
            }
        }
    }
    public void setCustomerDetails(String cName, String cPhoneNo, String cAddress,int noOfPlates){
        customerName = cName;
        customerAddress = cAddress;
        customerPhNo = cPhoneNo;
        numOfPlates = noOfPlates;
    }
    List<Item> checkedItems = new ArrayList<>();
    public void getEstimate(MouseEvent event) throws IOException {
        addItems();
        AtomicBoolean isCancelled = new AtomicBoolean(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Make sure to select the necessary items");
        alert.setContentText("Click on OK if you have selected all the necessary items");
        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.CANCEL){
                isCancelled.set(true);
            }
        });
        if(isCancelled.get()){
            return;
        }
        checkItems(beverages, checkedItems);
        checkItems(rotiItems, checkedItems);
        checkItems(veg, checkedItems);
        checkItems(nonVeg, checkedItems);
        checkItems(dessert, checkedItems);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("estimation.fxml"));
        Parent root = loader.load();
        CMSController cmsController = loader.getController();
        System.out.println(checkedItems.size());
        cmsController.setCheckedItems(checkedItems);
        cmsController.setCustomerDetails(customerName, customerPhNo, customerAddress, numOfPlates);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
