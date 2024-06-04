package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.factory;

import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Customer;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.Veterinary;
import co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model.builder.CustomerBuilder;

import java.time.LocalDate;
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
        Customer customer1 = new CustomerBuilder()
                .setName("Juan Luis")
                .setDni("123456789")
                .setAddress("Cali calle 21")
                .setEmail("JuanLuis@gmail.com")
                .setPhoneNumber("321-432-543")
                .setRegistrationDate(LocalDate.of(2022, 02, 04))
                .build();

        Customer customer2 = new CustomerBuilder()
                .setName("Maria Garcia")
                .setDni("987654321")
                .setAddress("Bogotá carrera 10")
                .setEmail("MariaGarcia@hotmail.com")
                .setPhoneNumber("310-567-890")
                .setRegistrationDate(LocalDate.of(2023, 5, 12))
                .build();

        Customer customer3 = new CustomerBuilder()
                .setName("Carlos Perez")
                .setDni("564738291")
                .setAddress("Medellín avenida 30")
                .setEmail("CarlosPerez@yahoo.com")
                .setPhoneNumber("300-789-654")
                .setRegistrationDate(LocalDate.of(2021, 7, 19))
                .build();

        Customer customer4 = new CustomerBuilder()
                .setName("Ana Torres")
                .setDni("112233445")
                .setAddress("Cartagena calle 8")
                .setEmail("AnaTorres@gmail.com")
                .setPhoneNumber("315-432-111")
                .setRegistrationDate(LocalDate.of(2020, 9, 23))
                .build();

        Customer customer5 = new CustomerBuilder()
                .setName("Luis Alvarez")
                .setDni("998877665")
                .setAddress("Barranquilla carrera 15")
                .setEmail("LuisAlvarez@gmail.com")
                .setPhoneNumber("312-654-321")
                .setRegistrationDate(LocalDate.of(2019, 11, 30))
                .build();

        Customer customer6 = new CustomerBuilder()
                .setName("Sofia Martinez")
                .setDni("556677889")
                .setAddress("Cúcuta avenida 12")
                .setEmail("SofiaMartinez@gmail.com")
                .setPhoneNumber("319-888-777")
                .setRegistrationDate(LocalDate.of(2021, 3, 5))
                .build();

        Customer customer7 = new CustomerBuilder()
                .setName("Andres Ramirez")
                .setDni("665544332")
                .setAddress("Pereira calle 9")
                .setEmail("AndresRamirez@gmail.com")
                .setPhoneNumber("317-555-666")
                .setRegistrationDate(LocalDate.of(2018, 8, 20))
                .build();

        Customer customer8 = new CustomerBuilder()
                .setName("Lucia Fernandez")
                .setDni("776655443")
                .setAddress("Manizales carrera 22")
                .setEmail("LuciaFernandez@gmail.com")
                .setPhoneNumber("320-777-999")
                .setRegistrationDate(LocalDate.of(2022, 12, 15))
                .build();

        veterinary.getCustomerList().add(customer1);
        veterinary.getCustomerList().add(customer2);
        veterinary.getCustomerList().add(customer3);
        veterinary.getCustomerList().add(customer4);
        veterinary.getCustomerList().add(customer5);
        veterinary.getCustomerList().add(customer6);
        veterinary.getCustomerList().add(customer7);
        veterinary.getCustomerList().add(customer8);

    }

    public List<Customer> getCustomerList() {
        return veterinary.getCustomerList();
    }

    public boolean createCustomer(Customer customer) {
        return veterinary.createCustomer(customer);
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        return veterinary.removeCustomer(selectedCustomer);
    }

    public boolean upDateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        return veterinary.upDateCustomer(selectedCustomer, customerUpdate);
    }
}
