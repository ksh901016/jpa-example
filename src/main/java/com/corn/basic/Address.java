package com.corn.basic;

import javax.persistence.Embeddable;

@Embeddable // composite 타입
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
}
