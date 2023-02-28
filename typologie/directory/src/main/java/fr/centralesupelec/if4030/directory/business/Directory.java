package fr.centralesupelec.if4030.directory.business;
import java.util.List;
import java.util.HashMap;
// import java.util.Objects;
import java.util.Map;
// import java.util.Optional;
import java.util.ArrayList;

public class Directory implements ISearch, IAddEntry {
    private IContactData data;
    HashMap< Integer, Contact > contacts;

    public Directory(IContactData contactData) {
        this.data = contactData;
        this.contacts = new HashMap<>();
        for (Integer id : contactData.getIds()) {
            contacts.put(id,new Contact(contactData.getFirstName(id),contactData.getLastName(id)));
            for (Integer phone : data.getPhones(id)) {
                contacts.get(id).addPhone(phone);
            }
        }
    }

    @Override
    public void addPhone(String firstName, String lastName, Integer phone) {
        // Optional<Integer> id = contacts
        //     .entrySet()
        //     .stream()
        //     .filter(entry -> Objects.equals(entry.getValue(), new Contact(firstName, lastName)))
        //     .map(Map.Entry::getKey)
        //     .findFirst();
        // if (id.isPresent()) {
        //     data.addPhone(id.get(), phone);
        //     contacts.get(id.get()).
        // }
        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            if (entry.getValue().getFirstName().equals(firstName) &&
                entry.getValue().getLastName().equals(lastName)) {
                    entry.getValue().addPhone(phone);
                    data.addPhone(entry.getKey(), phone);
                    return;
                }
        }
        Integer id = data.newContact(firstName, lastName);
        data.addPhone(id, phone);
        contacts.put(id, new Contact(firstName, lastName));
        contacts.get(id).addPhone(phone);
    }

    @Override
    public List< IContact > search(String name) {
        List< IContact > result = new ArrayList<IContact>();
        for (Contact contact : contacts.values()) {
            if (contact.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                contact.getLastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(contact);
            }
        }
        return result;
    }
}
