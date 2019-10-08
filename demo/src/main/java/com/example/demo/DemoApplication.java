package com.example.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.custom.exceptions.UndefinedCategoryException;
import com.example.store.StoreUtils;
import com.example.users.Customer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        System.out.println();
        System.out.println();
        char c= 'Y';
        do {
            System.out.println("****Welcome to XYZ Retail Store****");
            System.out.println();
            //FETCHING CUSTOMER CATEGORY
            System.out.println("Enter the category of user (Normal/Affiliate/Employee)");
            Scanner sc=new Scanner(System.in);
            String category=sc.next();

            //CREATING CUSTOMER OBJECT DEPENDING UPON THE ABOVE INPUT
            StoreUtils fu=new StoreUtils();
            try {
                Customer user=fu.getInstance(category);

                System.out.println("-------");

                //ENTER CUSTOMER DETAILS
                System.out.println("Enter the name of customer");
                String name=sc.next();
                user.setUserName(name);

                if("Normal".equalsIgnoreCase(category))
                {
                    System.out.println("-------");

                    System.out.println("Enter the number of months of association with Retail Store");
                    int months=sc.nextInt();
                    user.setNoOfMonthsOfAssociation(months);
                }

                System.out.println("-------");

                //ENTER TOTAL AMOUNT OF GROCERY and NON-GROCERY ITEMS
                System.out.println("Enter the amount of groceries");
                float amounOfGroceries=sc.nextFloat();
                user.setAmountOfGroceries(amounOfGroceries);

                System.out.println("-------");

                System.out.println("Enter the amount of non-groceries");
                float amountOfNonGroceries=sc.nextFloat();
                user.setAmountOfNonGroceries(amountOfNonGroceries);

                //DISCOUNT CALCULATION
                float discount=user.discountCalculation();
                user.setCategoryDiscount(discount);

                System.out.println();

                System.out.println("Hello "+user.getUserName());
                System.out.println("Total MRP for your shopping is "+(user.getAmountOfGroceries()+user.getAmountOfNonGroceries()));
                System.out.println("Discount as per category is "+user.getCategoryDiscount());
                System.out.println("Final discount is "+((user.getAmountOfGroceries()+user.getAmountOfNonGroceries())-user.calculateTotalPaybleAmount()));
                System.out.println("Final Payble amount is: "+user.getFinalAmount());
            } catch(Exception ex) {
                System.out.println("You have entered wrong input!!\nTerminating this bill.");

            } finally {
            
                System.out.println("Do you want to process another bill? (Y/N)");
                c=sc.next().charAt(0);
                
            }
                }
    while(c=='Y' || c=='y');
 }
}