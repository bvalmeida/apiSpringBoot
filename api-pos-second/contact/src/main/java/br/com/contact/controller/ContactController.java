package br.com.contact.controller;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.model.Contact;
import br.com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> get(){
        return this.contactService.getAllContact();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactRequest request){
        this.contactService.createContact(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteContact(@RequestParam Long id){
        this.contactService.removeContact(id);
    }

    @GetMapping("/findy-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Contact getContactByName(@RequestParam String name){
        return  this.contactService.getByName(name);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateContact(@RequestBody ContactRequest request){
        this.contactService.updateContact(request);
    }





}
