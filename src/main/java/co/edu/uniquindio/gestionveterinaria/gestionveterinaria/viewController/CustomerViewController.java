package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.viewController;

import java.net.URL;


import java.time.LocalDate;
import java.util.*;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.controller.CustomerController;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto.CustomerDto;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Pet;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CustomerViewController {

    CustomerController customerController;
    ObservableList<CustomerDto> customerList = FXCollections.observableArrayList();
    CustomerDto customerSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    /*
     * Tabla para mostrar los datos de los clientes.
     */
    @FXML
    private TableView<CustomerDto> tblCustomer;

    /*
     * Columna para mostrar la dirección del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcAddress;

    /*
     * Columna para mostrar el DNI del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcDNI;

    /*
     * Columna para mostrar el correo electrónico del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcEmail;

    /*
     * Columna para mostrar el nombre del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcName;

    /*
     * Columna para mostrar la edad de la mascota del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcPetAge;

    /*
     * Columna para mostrar el nombre de la mascota del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcPetName;

    /*
     * Columna para mostrar la raza de la mascota del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcPetRace;

    /*
     * Columna para mostrar el número de teléfono del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcPhoneNumber;

    /*
     * Columna para mostrar la fecha de registro del cliente.
     */
    @FXML
    private TableColumn<CustomerDto, String> tcRegistrationDate;

    /*
     * Columna para mostrar la especie de la mascota del cliente.
     */
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
        deleteCustomer();


    }

    @FXML
    void onUpdate(ActionEvent event) {
        updateCustomer();

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
        /*
         * Asocia las propiedades de las columnas de la tabla con los datos de los clientes.
         * Cada columna de la tabla se llena con las propiedades correspondientes de los objetos CustomerDto.
         */
        tcName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name()));
        tcAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().address()));
        tcDNI.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dni()));
        tcPhoneNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().phoneNumber()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcPetName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().petName()));
        tcPetAge.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().petAge() + " " + "años")));
        tcPetRace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().race()));
        tcSpecies.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().species()));
        tcRegistrationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().registrationDate()));
    }

    private void getCustomerList() {
        /*
         * Añade todos los clientes obtenidos del controlador a la lista de clientes.
         * Esto asegura que la lista local de clientes se mantenga actualizada con los datos del controlador.
         */
        customerList.addAll(customerController.getCustomerList());
    }

    private void setupFilter() {
        /*
         * Configura el filtro para la lista de clientes basado en el texto de búsqueda.
         * Cada vez que el texto del filtro cambia, se actualiza la lista de clientes mostrada en la tabla.
         */
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<CustomerDto> originalList = customerController.getCustomerList();
            ObservableList<CustomerDto> filteredList = filteredList(originalList, newValue);
            tblCustomer.setItems(filteredList);
        });
    }

    private ObservableList<CustomerDto> filteredList(List<CustomerDto> originalList, String searchText) {
        /*
         * Filtra la lista original de clientes basándose en el texto de búsqueda.
         * Solo los clientes cuyo DNI contiene el texto de búsqueda serán incluidos en la lista filtrada.
         */
        List<CustomerDto> filteredList = new ArrayList<>();
        for (CustomerDto customerDto : originalList) {
            if (searchFindsCustomer(customerDto, searchText))
                filteredList.add(customerDto);
        }
        return FXCollections.observableList(filteredList);
    }

    private void listenerSelection() {
        /*
         * Añade un listener para la selección de elementos en la tabla de clientes.
         * Cuando se selecciona un cliente en la tabla, se muestra su información en los campos correspondientes.
         */
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            customerSelected = newSelection;
            showInformation(customerSelected);
        });
    }

    private void showInformation(CustomerDto customerSelected) {
        /*
         * Muestra la información del cliente seleccionado en los campos correspondientes.
         * Si un cliente está seleccionado, sus datos se muestran en los campos del formulario.
         */
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
        /*
         * Verifica si el texto de búsqueda se encuentra en el DNI del cliente.
         * La búsqueda no distingue entre mayúsculas y minúsculas.
         */
        return (customerDto.dni().toLowerCase().contains(searchText.toLowerCase()) ||
                customerDto.petName().toLowerCase().contains(searchText.toLowerCase()) ||
                customerDto.name().toLowerCase().contains(searchText.toLowerCase()));
    }

    private void deselectCustomer() {
        /*
         * Deselecciona el cliente seleccionado en la tabla.
         * Esto limpia la selección actual y establece customerSelected a null.
         */
        tblCustomer.getSelectionModel().clearSelection();
        customerSelected = null;
    }

    private void addCustomer() {
        /*
         * Añade un nuevo cliente si el formulario es válido.
         * Si la validación es exitosa, se crea un nuevo cliente y se agrega a través del controlador.
         * Luego, se muestra un mensaje de éxito o error basado en el resultado de la operación.
         */
        if (validateForm()) {
            Customer newCustomer = buildDataCustomer();
            boolean success = customerController.addCustomer(newCustomer);
            if (success) {
                showMessage("Notificación Usuario", "Cliente agregado", "El cliente ha sido agregado exitosamente", Alert.AlertType.INFORMATION);
                clearData();
                refreshTables();
            } else {
                showMessage("Notificación Usuario", "Cliente no agregado", "Error al agregar al cliente", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Notificación Usuario", "Datos inválidos", "Por favor complete todos los campos", Alert.AlertType.WARNING);
        }
    }

    private void deleteCustomer() {
        /*
         * Elimina el cliente seleccionado del sistema.
         * Si hay un cliente seleccionado en la tabla, se muestra un cuadro de diálogo de confirmación
         * para confirmar la eliminación. Si el usuario confirma la eliminación, el cliente seleccionado
         * se elimina del sistema utilizando el CustomerController.
         */
        if(customerSelected !=null) {
            boolean confirmation = showConfirmationMessage("¿ Está seguro de eliminar el usuario" +" "+ txtName.getText()+" ?");
            if (confirmation) {
                Customer customer = buildDataCustomer();
                boolean success = customerController.deleteCustomer(customer);
                if (success){
                    customerList.remove(customerSelected);
                    showMessage("Notificación Usuario", "Usuario eliminado con éxito", "El usuario fue eliminado exitosamente", Alert.AlertType.INFORMATION);
                    clearData();
                }else {
                    showMessage("Notificación Usuario", "Error al eliminar",
                            "No se pudo eliminar el usuario", Alert.AlertType.ERROR);
                }
            }
        }else{
            showMessage("Notificación Usuario", "Ningún Usuario Seleccionado",
                    "Debe seleccionar un usuario para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void updateCustomer() {
        if (customerSelected != null) {
           Customer customer = customerSelected.toCustomer();
           Customer customerUpdate = buildDataCustomer();
           boolean success = customerController.updateCustomer(customer, customerUpdate);
           if (success) {
               int index = customerList.indexOf(customerSelected);
               if (index != -1) {
                   CustomerDto updateDto = CustomerDto.fromCustomer(customerUpdate);
                   customerList.set(index, updateDto);
                   refreshTables();
               }
               showMessage("Notificación Cliente", "Cliente actualizado",
                       "El cliente ha sido actualizado con éxito", Alert.AlertType.INFORMATION);
               clearData();
           } else {
               showMessage("Error", "Actualización fallida",
                       "No se pudo actualizar el cliente.", Alert.AlertType.ERROR);
           }

        } else {
            showMessage("Error", "Selección requerida",
                    "Debe seleccionar un cliente para actualizar.", Alert.AlertType.WARNING);
        }
    }

    private Customer buildDataCustomer() {
        /*
         * Construye un objeto Customer con los datos del formulario.
         * Recoge los datos de las mascotas y del cliente para crear un nuevo objeto Customer.
         */
        Pet pet = new Pet();
        pet.setName(txtPetName.getText());
        pet.setSpecies(txtSpecies.getText());
        pet.setRace(txtRace.getText());
        pet.setAge(Integer.parseInt(txtPetAge.getText()));
        String name = txtName.getText();
        String email = txtEmail.getText();
        String dni = txtDNI.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String address = txtAddress.getText();
        return new Customer(name, address, email, phoneNumber, dni, pet, LocalDate.now());
    }

    private void clearData() {
        /*
         * Limpia los campos del formulario.
         * Esto prepara el formulario para la entrada de un nuevo cliente.
         */
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
        /*
         * Valida que todos los campos del formulario no estén vacíos.
         * Si todos los campos contienen datos, retorna true; de lo contrario, false.
         */
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
        /*
         * Refresca la tabla de clientes.
         * Limpia la lista actual y la vuelve a llenar con los datos actualizados del controlador.
         */
        customerList.clear();
        tblCustomer.setItems(customerList);
        getCustomerList();
    }

    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        /*
         * Muestra un mensaje al usuario.
         * Crea y muestra una alerta con el título, encabezado y contenido especificados.
         */
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean showConfirmationMessage(String message){
        /*
         * Muestra un cuadro de diálogo de confirmación con el mensaje proporcionado.
         * @param message El mensaje a mostrar en el cuadro de diálogo de confirmación.
         * @return true si el usuario elige "Aceptar", false si elige "Cancelar".
         */
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(message);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
