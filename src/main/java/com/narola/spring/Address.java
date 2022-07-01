package com.narola.spring;

import javax.persistence.*;

//@Entity
//@Table(name = "TBL_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addId;

    @Column(name = "address", nullable = false)
    private String address;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private User user;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
