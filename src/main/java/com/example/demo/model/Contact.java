package com.example.demo.model;


import com.example.demo.model.util.Label;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity // db-i het kap hastati
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // db table  kap@ kodi  klassneri het
    private int id;

    private String name;

    private String surname;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Label phoneLabel;


    @Column(nullable = false) // chi kara null lini
    private String email;

    @Enumerated(EnumType.STRING)
    private Label emailLabel;


    public String stringify() {
        return "" + name +
                "" + surname +
                "" + phone +
                "" + phoneLabel +
                "" + email +
                "" + emailLabel;
    }
}
