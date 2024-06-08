package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto;

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

}
