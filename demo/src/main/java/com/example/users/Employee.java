package com.example.users;

public class Employee extends Customer{

    //categoryDiscount METHOD OVERRIDDEN FOR EMPLOYEE CUSTOMER
    @Override
    public float discountCalculation() {
        categoryDiscount=(30*amountOfNonGroceries)/100;
        return categoryDiscount;
   }
}