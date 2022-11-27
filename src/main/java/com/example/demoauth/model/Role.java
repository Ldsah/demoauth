package com.example.demoauth.model;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public void setName(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public Role(){

    }

    public Role(ERole name){
        this.name = name;
    }

}
