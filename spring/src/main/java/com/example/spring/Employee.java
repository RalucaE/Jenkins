package com.example.spring;



import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "employee_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String emailAdress;
    private String adress;
    private String role;

    public Employee() {
        firstName = "";
        lastName = "";
        age = 0;
        emailAdress = "";
        adress = "";
        role = "";
    }

    public Employee(String firstName, String lastName, int age, String emailAdress, String adress, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAdress = emailAdress;
        this.adress = adress;
        this.role = role;
    }
    public Long getId(){
        return id;
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

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
