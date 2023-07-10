package com.example.GIL.modele;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String nom;
    private String email;
    private String password;



//    public Enseignant(){
//        super();
//        password = "1234";
//    }



}
