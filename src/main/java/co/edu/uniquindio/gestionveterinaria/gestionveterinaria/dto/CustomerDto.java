package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Pet;

import java.time.LocalDate;

public record CustomerDto(
        String name,
        String address,
        String email,
        String phoneNumber,
        String dni,
        String petName,
        String race,
        int petAge,
        String species,
        String registrationDate
) {
    public Customer toCustomer() {
        Pet pet = new Pet();
        pet.setName(this.petName());
        pet.setSpecies(this.species());
        pet.setRace(this.race());
        pet.setAge(this.petAge());
        return new Customer(this.name(), this.address(), this.email(), this.phoneNumber(), this.dni(), pet, LocalDate.parse(this.registrationDate()));
    }

    public static CustomerDto fromCustomer(Customer customer) {
        return new CustomerDto(
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getDni(),
                customer.getPet().getName(),
                customer.getPet().getRace(),
                customer.getPet().getAge(),
                customer.getPet().getSpecies(),
                customer.getRegistrationDate().toString()
        );
    }

}
