package br.com.contact.service;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.model.Contact;
import br.com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void createContact(ContactRequest request) {
        this.contactRepository.save(new Contact().convertToEntity(request));
    }

    @Override
    public void removeContact(Long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public List<ContactResponse> getContactByName(String name) {
        return (List<ContactResponse>) this.contactRepository.findAll().stream().filter(contactResponse -> contactResponse.getName().equals(name)).findAny().get();

    }

    @Override
    public ContactResponse getByName(String name) {
        return this.contactRepository.findByName(name);

    }

    @Override
    public List<ContactResponse> getAllContact() {
        return this.contactRepository.findAll()
                .stream().map(contact -> contact.convertToContactResponse(contact))
                .collect(Collectors.toList());
    }

    @Override
    public void updateContact(ContactRequest request) {
        this.contactRepository.save(new Contact().convertToEntity(request));
    }


}
