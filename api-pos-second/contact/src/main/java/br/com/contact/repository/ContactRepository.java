package br.com.contact.repository;

import br.com.contact.controller.response.ContactResponse;
import br.com.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    ContactResponse findByName(String name);
}
