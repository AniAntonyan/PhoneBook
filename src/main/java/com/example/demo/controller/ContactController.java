package com.example.demo.controller;


import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // CRUD metodnern a parunakum
@RequestMapping("/api/v1/contact") // service mapping
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("get-all")
    ResponseEntity<List<Contact>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @GetMapping("/{key}")
    ResponseEntity<List<Contact>> getByKey(@PathVariable("key") String key) {
        return ResponseEntity.ok(contactService.getByKey(key));
    }

    @PostMapping
    ResponseEntity<Contact> create(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.create(contact));
    }

    @PutMapping("/{id}")
    ResponseEntity<Contact> update(@PathVariable("id") int id, @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.update(contact,id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") int id){
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }
}
