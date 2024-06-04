package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String dni;
    private Pet pet;
    private LocalDate registrationDate;

    public Customer(String name, String address, String email, String phoneNumber, String dni, Pet pet, LocalDate registrationDate) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
        this.pet = pet;
        this.registrationDate = registrationDate;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public Pet getPet() {
        return pet;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
