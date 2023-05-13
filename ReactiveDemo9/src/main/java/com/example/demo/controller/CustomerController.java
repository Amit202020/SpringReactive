package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
	
	@Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer/{custID}")
    Mono<ResponseEntity<Customer>> getustomer(@PathVariable Long custID) {
        return customerRepository.findById(custID).map(cust -> {
            return new ResponseEntity<>(cust, HttpStatus.OK);
        });
    }
    
    @PostMapping("/customers")
    Mono<ResponseEntity<Customer>> addCustomer(@RequestBody Customer customerAdd) {
        return customerRepository.save(customerAdd).map(cust -> {
            return new ResponseEntity<>(cust, HttpStatus.CREATED);
        });
    }
    
    
    @PutMapping("/customer/{custID}")
    Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable Long custID, @RequestBody Customer newCustData) {

        return customerRepository.findById(custID)
                .switchIfEmpty(Mono.error(new Exception("Customer with ID " + custID + " not found")))
                .flatMap(foundCustomer -> {
                    foundCustomer.setFirstName(newCustData.getFirstName());

                    return customerRepository.save(foundCustomer).map(cust -> {
                        return new ResponseEntity<>(cust, HttpStatus.ACCEPTED);
                    });
                });
    }
    
    
    
    @DeleteMapping("/customer/{custID}")
    Mono<Object>  deleteCustomer(@PathVariable Long custID) {
    	 return customerRepository.findById(custID)
                 .switchIfEmpty(Mono.error(new Exception("Customer with ID " + custID + " not found")))
                 .flatMap(foundCust -> {
                    return customerRepository.deleteById(custID).map(cust -> {
                        return new ResponseEntity<>(cust, HttpStatus.ACCEPTED);
                    });
                });
    }
    
  
   
}
