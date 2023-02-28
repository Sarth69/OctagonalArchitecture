package fr.centralesupelec.if4030.directory.server;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
    @Id
    Integer number;
    @JoinColumn
    @ManyToOne
    Person owner;
    public Phone(Integer number, Person owner) {
        this.number = number;
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
