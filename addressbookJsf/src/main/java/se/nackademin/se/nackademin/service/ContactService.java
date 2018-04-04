package se.nackademin.se.nackademin.service;

import se.nackademin.domain.Contact;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@Singleton
@ApplicationScoped
@ManagedBean(name = "service")
public class ContactService {

    private List<Contact> contacts = new ArrayList<>();
    private List<Contact> searchResult = new ArrayList<>();
    private int id = 1;

    public void addContact(Contact newContact) {
        newContact.setId(id++);
        contacts.add(newContact);
    }

    public void deleteContact(int idDelete) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == idDelete) {
                contacts.remove(i);
            }
        }
    }

    public void searchContact(String searchString) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(searchString) || contacts.get(i).getLastName().equals(searchString) || contacts.get(i).getStreet().equals(searchString) ||  contacts.get(i).getPhone().equals(searchString) && contacts.get(i).getFirstName() != null) {
                searchResult.add(contacts.get(i));
            }
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Contact> searchResult) {
        this.searchResult = searchResult;
    }

    @PostConstruct
    public void createDB() {

        addContact(new Contact("Raisa", "Bolic", "Birgittavägen 1", "0193919"));
        addContact(new Contact("Vlad", "Jungerstam", "Skogsbacken 16", "231313"));

    }
}