package se.nackademin.controller;

import se.nackademin.domain.Contact;
import se.nackademin.se.nackademin.service.ContactService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "contactcontroller")
public class ContactController implements Serializable{

    private List<Contact> contacts;
    private Contact newContact = new Contact();


    @ManagedProperty("#{service}")
    private ContactService contactService;

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void init() {
        contacts = contactService.getContacts();
    }

    public Contact getNewContact() {
        return newContact;
    }

    public void setNewContact(Contact newContact) {
        this.newContact = newContact;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void createContact() {
        contactService.addContact(newContact);
    }

    public void delete(Contact contact) {

        contacts.remove(contact);
        contactService.deleteContact(contact.getId());
    }
}


