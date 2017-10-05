package org.vavr.sample.service;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.vavr.sample.domain.Customer;

import java.util.List;

/**
 * Created by aleksandra on 04.10.17.
 */
public interface CustomerService {

    Option<Customer> findOne(Long id);

    Either<String, Customer> save(Customer customer);

    Try<Customer> get(Long id);

    List<Customer> findAll();

    Validation<Seq<String>, Customer> validate(Customer customer);



}
