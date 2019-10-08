package com.example.users;

public class Affiliate extends Customer{

    //DISCOUNT METHOD OVERRIDDEN FOR AFFILIATE CUSTOMER
    @Override
    public float discountCalculation() {
        categoryDiscount=(10*amountOfNonGroceries)/100;
        return categoryDiscount;
   }
}
