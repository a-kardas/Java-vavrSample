package org.vavr.sample.validator;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.apache.commons.lang3.text.WordUtils;
import org.vavr.sample.domain.Customer;

/**
 * Created by aleksandra on 04.10.17.
 */
public class CustomerValidator {

    private final String NOT_EMPTY_ERROR = "%s field is empty";
    private final String PESEL_ERROR = "Pesel is not valid";
    private final Integer VALID_PESEL_LENGHT = 11;

    public Validation<Seq<String>, Customer> validate(Customer customer){

        return Validation.combine(
                isEmpty(customer.getFirstName(), "firstName"),
                isEmpty(customer.getLastName(), "lastName"),
                isPeselValid(customer.getPesel())
        ).ap(Customer::new);
    }

    private Validation<String, String> isEmpty(String value, String field){
        if(value == null || value.equals(""))
            return Validation.invalid(String.format(NOT_EMPTY_ERROR, WordUtils.capitalize(field)));
        else
            return Validation.valid(value);
    }

    private Validation<String, String> isPeselValid(String pesel){
        if(pesel == null || pesel.length() != VALID_PESEL_LENGHT)
            return Validation.invalid(PESEL_ERROR);
        else
            return Validation.valid(pesel);
    }
}
