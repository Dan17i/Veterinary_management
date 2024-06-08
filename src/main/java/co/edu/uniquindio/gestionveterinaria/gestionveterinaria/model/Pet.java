package co.edu.uniquindio.gestionveterinaria.gestionveterinaria.model;

public class Pet {
    private String name;
    private String race;
    private int age;
    private String species;
    private Customer owner;

    public Pet(String name, String race, int age, String species, Customer owner) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.species = species;
        this.owner = owner;
    }

    public Pet () {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
