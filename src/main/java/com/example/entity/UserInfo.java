package com.example.entity;

import com.example.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class UserInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "role")
    private String role;

    @Column(name = "gender")
    private String gender;

    @Column(name = "photo")
    private String photo;

    @Column(name = "signature")
    private String signature;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "constellation")
    private String constellation;

    @Override
    protected void prePersist(){

        super.prePersist();

        if(nickname == null){
            nickname = username;
        }

        if(gender == null){
            gender = "";
        }

        if(photo == null){
            photo = "";
        }

        if(signature == null){
            signature = "";
        }

        if(constellation == null){
            constellation = "";
        }
    }
}
