package com.yrgo.client;

import com.yrgo.services.customers.CustomerManagementService;

import com.yrgo.domain.Customer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SimpleClient {

    public static void main(String[] args) {
        // Load the Spring application context from application.xml
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            // Retrieve the CustomerManagementService bean
            CustomerManagementService customerManagementService = context.getBean(CustomerManagementService.class);

            // Get a list of customers
            List<Customer> customers = customerManagementService.getAllCustomers();

            // Print the list of customers
            System.out.println("List of Customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
