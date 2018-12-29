package com.spring.vin.GymBuilding.service;

import com.spring.vin.GymBuilding.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by vinayraghavtiwari on 30/11/18.
 */

@Service
public class CustomerGymRecordImplementation implements CustomerGymRecord{

    Set<Customer> gymRecord = new HashSet<>();


    @Override
    public void addCustomerRecord(Customer customer) {

        customer.setId(gymRecord.size()+1);
        gymRecord.add(customer);
        System.out.println("Gym Record" + gymRecord);
    }

    @Override
    public boolean updateCustomerRecord(Customer customer) {

        for(Customer cust : gymRecord){
            if(cust.getId().equals(customer.getId()))
            {
                cust.setFirstName(customer.getFirstName());
                cust.setLastName(customer.getLastName());
                cust.setEmailId(customer.getEmailId());

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteRecord(Integer Id) {
        for(Customer cust : gymRecord){
            if(cust.getId().equals(Id))
                gymRecord.remove(cust);
                return true;
        }
        return false;
    }

    @Override
    public Customer findbyId(Integer Id) {
        for(Customer cus: gymRecord){
            if(cus.getId().equals(Id)){
                return cus;
            }
        }
        return null;
    }

    @Override
    public Set<Customer> findAllVustomers() {
        return gymRecord;
    }
}
