package com.example.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.custom.exceptions.UndefinedCategoryException;
import com.example.users.Customer;

public class StoreUtilsTest {

    @Test
    public void getNormalCustomer() throws UndefinedCategoryException {
        StoreUtils st = new StoreUtils();
        Customer customer = st.getInstance("Normal");
        customer.setUserName("Apoorv");

        //Customer associated with < 2 years
        int months = 10;

        customer.setNoOfMonthsOfAssociation(months);

        //Total Amount of groceries and non-groceries purchased.
        float amounOfGroceries = 1234.56F;
        customer.setAmountOfGroceries(amounOfGroceries);

        float amountOfNonGroceries = 4589.09F;
        customer.setAmountOfNonGroceries(amountOfNonGroceries);

        customer.setCategoryDiscount(customer.discountCalculation());

        assertEquals("0.0",String.valueOf(customer.getCategoryDiscount()));

       //Customer associated with >= 2 years
        months = 25;
        customer.setNoOfMonthsOfAssociation(months);

        customer.setCategoryDiscount(customer.discountCalculation());
        assertEquals("229.4545",String.valueOf(customer.getCategoryDiscount()));
        assertEquals("0.0", String.valueOf(customer.getFinalAmount()));

    }

    @Test
    public void getAffiliateCustomer() throws UndefinedCategoryException {
        StoreUtils st = new StoreUtils();
        Customer customer = st.getInstance("Affiliate");
        customer.setUserName("Apoorv");

        //Total Amount of groceries and non-groceries purchased.
        float amounOfGroceries = 1000F;
        customer.setAmountOfGroceries(amounOfGroceries);

        float amountOfNonGroceries = 4000F;
        customer.setAmountOfNonGroceries(amountOfNonGroceries);

        customer.setCategoryDiscount(customer.discountCalculation());

        assertEquals("400.0",String.valueOf(customer.getCategoryDiscount()));
        assertEquals("Apoorv",customer.getUserName());

    }

    @Test
    public void getEmployeeCustomer() throws UndefinedCategoryException {
        StoreUtils st = new StoreUtils();
        Customer customer = st.getInstance("Employee");
        customer.setUserName("Apoorv");

        //Total Amount of groceries and non-groceries purchased.
        float amounOfGroceries = 12F;
        customer.setAmountOfGroceries(amounOfGroceries);

        float amountOfNonGroceries = 45F;
        customer.setAmountOfNonGroceries(amountOfNonGroceries);

        customer.setCategoryDiscount(customer.discountCalculation());
        
        assertEquals("13.5",String.valueOf(customer.getCategoryDiscount()));
        assertEquals("43.5", String.valueOf(customer.calculateTotalPaybleAmount()));

    }
    
    @Test(expected=UndefinedCategoryException.class)    
    public void getUndefinedCustomer() throws UndefinedCategoryException {
        StoreUtils st = new StoreUtils();
        st.getInstance("abc");
    }
}