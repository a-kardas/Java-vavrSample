package org.vavr.sample.service;


import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.vavr.sample.dao.CustomerDao;
import org.vavr.sample.dao.DaoFactory;
import org.vavr.sample.domain.Customer;
import org.vavr.sample.validator.CustomerValidator;

import java.util.List;

/**
 * Created by aleksandra on 04.10.17.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerValidator customerValidator = new CustomerValidator();

    private DaoFactory factory = DaoFactory.getInstance();

    private CustomerDao customerDao = (CustomerDao) factory.getDao(Customer.class);


    public Option<Customer> findOne(Long id) {
        return Option.of(customerDao.findOne(id));
    }

    public Either<String, Customer> save(Customer customer) {
        Validation<Seq<String>, Customer> validate = validate(customer);
        if(validate.isValid()) {
            customerDao.save(customer);
            return Either.right(customer);
        }
        return Either.left("Customer not valid");
    }

    public Try<Customer> get(Long id) {
        Try<Customer> customer = Try.of(() -> customerDao.get(id));
        return customer;
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Validation<Seq<String>, Customer> validate(Customer customer) {
        return customerValidator.validate(customer);
    }
}
