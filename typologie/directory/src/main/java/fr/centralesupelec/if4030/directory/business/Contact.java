package fr.centralesupelec.if4030.directory.business;
import java.util.List;
import java.util.ArrayList;

public class Contact implements IContact {
    private String firstName;
    private String lastName;
    private List< Integer > phones;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = new ArrayList<>();
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public List< Integer > getPhones() {
        return List.copyOf(phones);
    }

    public void addPhone(Integer phone) {
        this.phones.add(phone);
    }
}
