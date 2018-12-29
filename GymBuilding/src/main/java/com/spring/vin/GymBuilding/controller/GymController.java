package com.spring.vin.GymBuilding.controller;

import com.spring.vin.GymBuilding.service.CustomerGymRecord;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.spring.vin.GymBuilding.model.Customer;
import java.util.*;

/**
 * Created by vinayraghavtiwari on 28/12/18.
 */
@RestController
@RequestMapping(value = "/gym/sweden")
public class GymController {

    @Autowired
    private CustomerGymRecord customergymrecord;

    @ApiOperation(value = " Getting All Gym Customers")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Set<Customer> findAllCustomers() {
        return customergymrecord.findAllVustomers();
    }

    @ApiOperation(value = " Adding Gym Customers")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCustomerRecord(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String emailId) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmailId(emailId);
        customergymrecord.addCustomerRecord(customer);
    }

    @ApiOperation(value = " Find Customer Id")
    @RequestMapping(method = RequestMethod.GET , value = "/{Id}")
    Customer findById(@PathVariable Integer Id){
        return customergymrecord.findbyId(Id);
    }

    @ApiOperation(value = " Update Customer Record")
    @RequestMapping(method = RequestMethod.PUT , value = "/update/{Id}")
    public void updateCustomerRecord(@PathVariable Integer Id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String emailId)
    {
        Customer customer = customergymrecord.findbyId(Id);
                if(firstName!=null)
                    customer.setFirstName(firstName);
                if(lastName!=null)
                    customer.setLastName(lastName);
                if(emailId!=null)
                    customer.setEmailId(emailId);
                customergymrecord.updateCustomerRecord(customer);

    }
    @ApiOperation(value = " Deletes Customer Record")
    @RequestMapping(method = RequestMethod.DELETE , value = "/delete/{Id}")
    public boolean deleteCustomer(@PathVariable Integer Id){
       customergymrecord.deleteRecord(Id);
       return true;
    }
}