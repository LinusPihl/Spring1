package com.yrgo.services.customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yrgo.domain.Call;
import com.yrgo.domain.Customer;

public class CustomerManagementMockImpl implements CustomerManagementService {

    private HashMap<String, Customer> customerMap;

    public CustomerManagementMockImpl() {
        customerMap = new HashMap<String, Customer>();
        customerMap.put("OB74", new Customer("OB74", "Fargo Ltd", "some notes"));
        customerMap.put("NV10", new Customer("NV10", "North Ltd", "some other notes"));
        customerMap.put("RM210", new Customer("RM210", "River Ltd", "some more notes"));
    }

    @Override
    public void newCustomer(Customer newCustomer) {
    }

    @Override
    public void updateCustomer(Customer changedCustomer) {
    }

    @Override
    public void deleteCustomer(Customer oldCustomer) {
    }

    @Override
    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        return customerMap.get(customerId);
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customerMap.values()) {
            if (customer.getCompanyName().contains(name)) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        return customerMap.get(customerId);
    }

    @Override
    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        Customer customer = customerMap.get(customerId);
        if (customer != null) {
            customer.addCall(callDetails);
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
