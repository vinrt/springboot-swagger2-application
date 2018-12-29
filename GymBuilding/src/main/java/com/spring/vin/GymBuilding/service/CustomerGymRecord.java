package com.spring.vin.GymBuilding.service;

import com.spring.vin.GymBuilding.model.Customer;

import java.util.*;

/**
 * Created by vinayraghavtiwari on 30/11/18.
 */
public interface CustomerGymRecord {

    void addCustomerRecord(Customer customer);

    boolean updateCustomerRecord(Customer customer);

    boolean deleteRecord(Integer Id);

    Customer findbyId(Integer Id);

    Set<Customer> findAllVustomers();
}
