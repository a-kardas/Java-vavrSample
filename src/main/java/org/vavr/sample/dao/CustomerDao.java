package org.vavr.sample.dao;


import org.vavr.sample.domain.Customer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aleksandra on 04.10.17.
 */
public class CustomerDao implements BaseDao<Customer> {

    private Long sequence = 1L;
    private Map<Long, Customer> customers = new HashMap();

    public CustomerDao(){
        customers.put(sequence, new Customer("Chuck", "Noris", "881212098765"));
        customers.put(++sequence, new Customer("Sylvester", "Stallone", "891212098765"));
        customers.put(++sequence, new Customer("Arnold", "Schwarzenegger", "901212098765"));
    }

    public Customer findOne(Long id){
        return customers.get(id);
    }

    public Customer get(Long id) throws Exception {
        if(customers.containsKey(id))
            return customers.get(id);
        else
            throw new Exception("Not found");
    }

    public List<Customer> findAll(){
        List<Customer> values = (List<Customer>) customers.values();
        return Collections.unmodifiableList(values);
    }

    public void save(Customer customer){
        customers.put(++sequence, customer);
    }
}
