package com.example.store;

import com.example.custom.exceptions.UndefinedCategoryException;
import com.example.users.Affiliate;
import com.example.users.Employee;
import com.example.users.Customer;

public class StoreUtils {

    //CHECK FOR CUSTOMER CATEGORY
    public Customer getInstance(String category) throws UndefinedCategoryException {
        if("Normal".equalsIgnoreCase(category))
            return new Customer();
        else if("Employee".equalsIgnoreCase(category))
            return new Employee();
        else if("Affiliate".equalsIgnoreCase(category))
            return new Affiliate();
        else
            throw new UndefinedCategoryException("Wrong category.");
    }
}
