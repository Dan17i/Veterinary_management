package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.controller;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.factory.ModelFactory;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;

import java.util.List;

public class CustomerController {
    private ModelFactory modelFactory;

    public CustomerController() {
        modelFactory = ModelFactory.getInstance();

    }

    public List<Customer> getCustomerList() {
        return modelFactory.getCustomerList();
    }

    public boolean createCustomer(Customer customer) {
        return modelFactory.createCustomer(customer);
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        return modelFactory.removeCustomer(selectedCustomer);
    }

    public boolean upDateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        return modelFactory.upDateCustomer(selectedCustomer, customerUpdate);
    }
}
