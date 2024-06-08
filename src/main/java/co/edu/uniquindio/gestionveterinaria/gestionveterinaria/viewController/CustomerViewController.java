package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.viewController;

import java.net.URL;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.controller.CustomerController;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto.CustomerDto;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerViewController {

    CustomerController customerController;
    ObservableList<CustomerDto> customerList = FXCollections.observableArrayList();
    CustomerDto customerSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btbRemove;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<CustomerDto> tblCustomer;

    @FXML
    private TableColumn<CustomerDto, String> tcAddress;

    @FXML
    private TableColumn<CustomerDto, String> tcDNI;

    @FXML
    private TableColumn<CustomerDto, String> tcEmail;

    @FXML
    private TableColumn<CustomerDto, String> tcName;

    @FXML
    private TableColumn<CustomerDto, String> tcPetAge;

    @FXML
    private TableColumn<CustomerDto, String> tcPetName;

    @FXML
    private TableColumn<CustomerDto, String> tcPetRace;

    @FXML
    private TableColumn<CustomerDto, String> tcPhoneNumber;

    @FXML
    private TableColumn<CustomerDto, String> tcRegistrationDate;

    @FXML
    private TableColumn<CustomerDto, String> tcSpecies;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPetAge;

    @FXML
    private TextField txtPetName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtRace;

    @FXML
    private TextField txtSpecies;

    @FXML
    void onAdd(ActionEvent event) {
        addCustomer();

    }


    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectCustomer();

    }



    @FXML
    void onRemove(ActionEvent event) {

    }

    @FXML
    void onUpdate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        customerController = new CustomerController();
        initView();
        setupFilter();

    }

    private void initView() {
        initDataBinding();
        getCustomerList();
        tblCustomer.getItems().clear();
        tblCustomer.setItems(customerList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name()));
        tcAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().address()));
        tcDNI.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dni()));
        tcPhoneNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().phoneNumber()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcPetName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().petName()));
        tcPetAge.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().petAge())));
        tcPetRace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().race()));
        tcSpecies.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().species()));
        tcRegistrationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().registrationDate()));

    }

    private void getCustomerList() {
        customerList.addAll(customerController.getCustomerList());
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<CustomerDto> originalList = customerController.getCustomerList();
            ObservableList<CustomerDto> filteredList = filteredList(originalList, newValue);
            tblCustomer.setItems(filteredList);
        });
    }

    private ObservableList<CustomerDto> filteredList(List<CustomerDto> originalList, String searchText) {
        List<CustomerDto> filteredList = new ArrayList<>();
        for (CustomerDto customerDto : originalList) {
            if (searchFindsCustomer(customerDto, searchText))
                filteredList.add(customerDto);
        }

        return FXCollections.observableList(filteredList);
    }

    private void listenerSelection() {
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            customerSelected = newSelection;
            showInformation(customerSelected);
        });
    }

    private void showInformation(CustomerDto customerSelected) {
        if (customerSelected != null) {
            txtAddress.setText(customerSelected.address());
            txtName.setText(customerSelected.name());
            txtPhoneNumber.setText(customerSelected.phoneNumber());
            txtDNI.setText(customerSelected.dni());
            txtEmail.setText(customerSelected.email());
            txtPetName.setText(customerSelected.petName());
            txtPetAge.setText(String.valueOf(customerSelected.petAge()));
            txtRace.setText(customerSelected.race());
            txtSpecies.setText(customerSelected.species());
        }
    }

    private boolean searchFindsCustomer(CustomerDto customerDto, String searchText) {
        return (customerDto.dni().toLowerCase().contains(searchText.toLowerCase()));

    }

    private void deselectCustomer() {
        tblCustomer.getSelectionModel().clearSelection();
        customerSelected = null;
    }

    private void addCustomer() {
        if (validateForm()) {

        }
    }

    private void clearData() {
        txtPhoneNumber.setText("");
        txtName.setText("");
        txtSpecies.setText("");
        txtRace.setText("");
        txtPetAge.setText("");
        txtDNI.setText("");
        txtSpecies.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtPetName.setText("");
        txtFilter.setText("");

    }

    private boolean validateForm() {
        return !txtAddress.getText().isEmpty()
                && !txtDNI.getText().isEmpty()
                && !txtEmail.getText().isEmpty()
                && !txtSpecies.getText().isEmpty()
                && !txtPetName.getText().isEmpty()
                && !txtPetAge.getText().isEmpty()
                && !txtRace.getText().isEmpty()
                && !txtName.getText().isEmpty()
                && !txtPhoneNumber.getText().isEmpty()
                && !txtSpecies.getText().isEmpty();
    }
    private void refreshTables() {
        customerList.clear();
        tblCustomer.setItems(customerList);
        getCustomerList();
    }
}
