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


}
