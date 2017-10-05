package org.vavr.sample.dao;

import org.vavr.sample.domain.Customer;

/**
 * Created by aleksandra on 05.10.17.
 */
public class DaoFactory {

    private static DaoFactory INSTANCE;
    private CustomerDao customerDao;

    private DaoFactory(){
        this.customerDao = new CustomerDao();
    }

    public static DaoFactory getInstance(){
        if(INSTANCE == null)
            return INSTANCE = new DaoFactory();
        else
            return INSTANCE;
    }

    public BaseDao getDao(Class clazz){
        if(clazz.equals(Customer.class))
            return customerDao;

        return null;
    }
}
