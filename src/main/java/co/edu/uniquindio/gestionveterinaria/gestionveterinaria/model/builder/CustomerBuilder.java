package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.builder;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Pet;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.services.IBuilder;

import java.time.LocalDate;

public class CustomerBuilder implements IBuilder {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String dni;
    private Pet pet;
    private LocalDate registrationDate;


    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public CustomerBuilder setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public CustomerBuilder setPet(Pet pet) {
        this.pet = pet;
        return this;
    }

    public CustomerBuilder setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }


    @Override
    public Customer build() {
        return new Customer(name, address, email, phoneNumber, dni, pet, registrationDate);
    }
}
