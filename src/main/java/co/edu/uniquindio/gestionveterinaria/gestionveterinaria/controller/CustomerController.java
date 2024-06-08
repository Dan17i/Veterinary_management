package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.controller;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto.CustomerDto;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.factory.ModelFactory;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;

import java.util.List;

public class CustomerController {
    private ModelFactory modelFactory;

    public CustomerController() {
        modelFactory = ModelFactory.getInstance();

    }


    public List<CustomerDto> getCustomerList() {
        return modelFactory.getCustomerList();
    }
}
