package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.factory;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.dto.CustomerDto;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Pet;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Veterinary;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.builder.CustomerBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private Veterinary veterinary;

    private ModelFactory() {
        veterinary = new Veterinary();
        initializeData();
    }
    
    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void initializeData() {
        initCustomer();
    }

    private void initCustomer() {

        Pet pet1 = new Pet();
        pet1.setName("Max");
        pet1.setAge(5);
        pet1.setRace("Pitbull");
        pet1.setSpecies("Perro");

        Customer customer1 = new CustomerBuilder()
                .setName("Juan Luis")
                .setDni("123456789")
                .setAddress("Cali calle 21")
                .setEmail("JuanLuis@gmail.com")
                .setPhoneNumber("321-432-543")
                .setPet(pet1)
                .setRegistrationDate(LocalDate.of(2022, 02, 04))
                .build();
        pet1.setOwner(customer1);

        Pet pet2 = new Pet();
        pet2.setName("Bella");
        pet2.setAge(3);
        pet2.setRace("Labrador");
        pet2.setSpecies("Perro");

        Customer customer2 = new CustomerBuilder()
                .setName("Maria Garcia")
                .setDni("987654321")
                .setAddress("Bogotá carrera 10")
                .setEmail("MariaGarcia@hotmail.com")
                .setPhoneNumber("310-567-890")
                .setPet(pet2)
                .setRegistrationDate(LocalDate.of(2023, 5, 12))
                .build();
        pet2.setOwner(customer2);

        Pet pet3 = new Pet();
        pet3.setName("Luna");
        pet3.setAge(4);
        pet3.setRace("Siames");
        pet3.setSpecies("Gato");

        Customer customer3 = new CustomerBuilder()
                .setName("Carlos Perez")
                .setDni("564738291")
                .setAddress("Medellín avenida 30")
                .setEmail("CarlosPerez@yahoo.com")
                .setPhoneNumber("300-789-654")
                .setPet(pet3)
                .setRegistrationDate(LocalDate.of(2021, 7, 19))
                .build();
        pet3.setOwner(customer3);


        Pet pet4 = new Pet();
        pet4.setName("Charlie");
        pet4.setAge(2);
        pet4.setRace("Bulldog");
        pet4.setSpecies("Perro");

        Customer customer4 = new CustomerBuilder()
                .setName("Ana Torres")
                .setDni("112233445")
                .setAddress("Cartagena calle 8")
                .setEmail("AnaTorres@gmail.com")
                .setPhoneNumber("315-432-111")
                .setPet(pet4)
                .setRegistrationDate(LocalDate.of(2020, 9, 23))
                .build();
        pet4.setOwner(customer4);

        Pet pet5 = new Pet();
        pet5.setName("Milo");
        pet5.setAge(1);
        pet5.setRace("Golden Retriever");
        pet5.setSpecies("Perro");

        Customer customer5 = new CustomerBuilder()
                .setName("Luis Alvarez")
                .setDni("998877665")
                .setAddress("Barranquilla carrera 15")
                .setEmail("LuisAlvarez@gmail.com")
                .setPhoneNumber("312-654-321")
                .setPet(pet5)
                .setRegistrationDate(LocalDate.of(2019, 11, 30))
                .build();
        pet5.setOwner(customer5);

        Pet pet6 = new Pet();
        pet6.setName("Simba");
        pet6.setAge(5);
        pet6.setRace("Persa");
        pet6.setSpecies("Gato");

        Customer customer6 = new CustomerBuilder()
                .setName("Sofia Martinez")
                .setDni("556677889")
                .setAddress("Cúcuta avenida 12")
                .setEmail("SofiaMartinez@gmail.com")
                .setPhoneNumber("319-888-777")
                .setPet(pet6)
                .setRegistrationDate(LocalDate.of(2021, 3, 5))
                .build();
        pet6.setOwner(customer6);

        Pet pet7 = new Pet();
        pet7.setName("Daisy");
        pet7.setAge(2);
        pet7.setRace("Beagle");
        pet7.setSpecies("Perro");

        Customer customer7 = new CustomerBuilder()
                .setName("Andres Ramirez")
                .setDni("665544332")
                .setAddress("Pereira calle 9")
                .setEmail("AndresRamirez@gmail.com")
                .setPhoneNumber("317-555-666")
                .setPet(pet7)
                .setRegistrationDate(LocalDate.of(2018, 8, 20))
                .build();
        pet7.setOwner(customer7);

        Pet pet8 = new Pet();
        pet8.setName("Nala");
        pet8.setAge(3);
        pet8.setRace("Bengala");
        pet8.setSpecies("Gato");

        Customer customer8 = new CustomerBuilder()
                .setName("Lucia Fernandez")
                .setDni("776655443")
                .setAddress("Manizales carrera 22")
                .setEmail("LuciaFernandez@gmail.com")
                .setPhoneNumber("320-777-999")
                .setPet(pet8)
                .setRegistrationDate(LocalDate.of(2022, 12, 15))
                .build();
        pet8.setOwner(customer8);

        veterinary.getCustomerList().add(customer1);
        veterinary.getCustomerList().add(customer2);
        veterinary.getCustomerList().add(customer3);
        veterinary.getCustomerList().add(customer4);
        veterinary.getCustomerList().add(customer5);
        veterinary.getCustomerList().add(customer6);
        veterinary.getCustomerList().add(customer7);
        veterinary.getCustomerList().add(customer8);

    }


    /*
     * Método que obtiene la lista de clientes y la convierte en una lista de CustomerDto.
     * @return Lista de CustomerDto con los datos de los clientes.
     */
    public List<CustomerDto> getCustomerList() {
        // Obtiene la lista de clientes desde el objeto veterinary
        List<Customer> customerList = veterinary.getCustomerList();
        // Lista que almacenará los CustomerDto
        List<CustomerDto> customerDtoList = new ArrayList<>();

        // Itera sobre la lista de clientes y convierte cada uno en CustomerDto
        for (Customer customer: customerList) {
            customerDtoList.add(buildCustomerDto(customer));
        }
        // Retorna la lista de CustomerDto
        return customerDtoList;
    }

    /*
     * Método que construye un objeto CustomerDto a partir de un objeto Customer.
     * @param customer El objeto Customer a convertir.
     * @return Un objeto CustomerDto con los datos del Customer proporcionado.
     */
    private CustomerDto buildCustomerDto(Customer customer) {
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


    public boolean addCustomer(Customer newCustomer) {
        return veterinary.addCustomer(newCustomer);
    }

    public boolean deleteCustomer(Customer customer) {
        return veterinary.deleteCustomer(customer);
    }
}
