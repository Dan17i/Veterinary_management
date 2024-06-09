package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model;

import java.util.ArrayList;
import java.util.List;

public class Veterinary {
    private final String nameVeterinary = "Arca";

    private List<Customer> customerList;

    public Veterinary() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }


    public boolean addCustomer(Customer newCustomer) {
        if (newCustomer != null && !customerExists(newCustomer.getDni())){
            customerList.add(newCustomer);
            return true;
        }
        return false;
    }

    private boolean customerExists(String dni) {
        for (Customer customer : customerList) {
            if (customer.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }

    public boolean deleteCustomer(Customer customerSelected) {
        if (customerSelected != null) {
            return customerList.removeIf(customerDto -> customerDto.getDni().equals(customerSelected.getDni()));
        }
        return false;
    }

}
