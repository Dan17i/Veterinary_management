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

    public boolean createCustomer(Customer newCustomer) {
        Customer customerFound = getCustomer(newCustomer.getDni());

        if (customerFound == null) {
            getCustomerList().add(newCustomer);
            return true;
        }

        return false;
    }

    private Customer getCustomer(String dni) {
        for (Customer customer : getCustomerList()) {
            if (customer.getDni().equalsIgnoreCase(dni)) {
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        if (selectedCustomer != null) {
            int index = customerList.indexOf(selectedCustomer);
            if (index != -1) {
                customerList.remove(index);
                return true;
            }
        }
        return false;
    }

    public boolean upDateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        int index = customerList.indexOf(selectedCustomer);
        if (index != -1) {
            customerList.set(index, customerUpdate);
            return true;
        }
        return false;
    }
}
