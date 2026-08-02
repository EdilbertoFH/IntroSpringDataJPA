package com.spring.IntroSpringDataJPA.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "direccion_seq")
    @SequenceGenerator(name = "direccion_seq", sequenceName = "DIRECCION_SEQ", allocationSize = 1)
    private Long id;

   @Column(name = "pais")
   private String country;

   @Column(name = "direccion")
   private String address;

   @OneToOne(mappedBy = "address")
   private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
