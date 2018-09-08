package designpattern.daopattern.entity;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int nbOfVehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNbOfVehicle() {
        return nbOfVehicle;
    }

    public void setNbOfVehicle(int nbOfVehicle) {
        this.nbOfVehicle = nbOfVehicle;
    }
}
