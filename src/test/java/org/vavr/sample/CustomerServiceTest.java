package org.vavr.sample;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.junit.Assert;
import org.junit.Test;
import org.vavr.sample.domain.Customer;
import org.vavr.sample.service.CustomerService;
import org.vavr.sample.service.CustomerServiceImpl;

/**
 * Created by aleksandra on 04.10.17.
 */
public class CustomerServiceTest {

    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void customerShouldBeValid(){
        //Given
        Customer customer = new Customer("John", "Kowalski", "99121109876");

        //When
        Validation<Seq<String>, Customer> validate = customerService.validate(customer);

        //Then
        Assert.assertTrue(validate.isValid());
    }

    @Test
    public void customerShouldNotBeValid() {
        //Given
        Customer customer = new Customer(null, "Kowalski", null);

        //When
        Validation<Seq<String>, Customer> validate = customerService.validate(customer);

        //Then
        Assert.assertTrue(!validate.isValid());
        Assert.assertTrue(validate.getError().size() == 2);
    }

    @Test
    public void shouldAddNewCustomer(){
        //Given
        Customer customer = new Customer("Robert", "Downey", "90111112345");

        //When
        Either<String, Customer> save = customerService.save(customer);

        //Then
        Assert.assertTrue(save.isRight());
    }


    @Test
    public void shouldNotAddNewCustomer(){
        //Given
        Customer customer = new Customer("Robert", "Downey", null);

        //When
        Either<String, Customer> save = customerService.save(customer);

        //Then
        Assert.assertTrue(save.isLeft());
    }

    @Test
    public void shouldFindOne(){
        //Given
        long id = 1l;

        //When
        Option<Customer> customer = customerService.findOne(id);

        //Then
        Assert.assertFalse(customer.isEmpty());
    }


    @Test
    public void shouldNotFindOne() {
        //Given
        long id = 10l;

        //When
        Option<Customer> customer = customerService.findOne(id);

        //Then
        Assert.assertTrue(customer.isEmpty());
    }

    @Test
    public void shouldNotGetCustomer(){
        //Given
        long id = 10l;

        //When
        Try<Customer> customer = customerService.get(id);

        //Then
        Assert.assertTrue(customer.isFailure());
    }

    @Test
    public void shouldGetCustomer(){
        //Given
        long id = 1l;

        //When
        Try<Customer> customer = customerService.get(id);

        //Then
        Assert.assertTrue(customer.isSuccess());
    }

}
