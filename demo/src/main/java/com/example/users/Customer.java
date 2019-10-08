package com.example.users;

public class Customer {

   protected String userName;
   protected float amountOfGroceries;
   protected float amountOfNonGroceries;   
   protected int noOfMonthsOfAssociation;
   protected float categoryDiscount;
   protected float finalAmount;

   
   //GETTERS AND SETTERS
   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public float getAmountOfGroceries() {
      return amountOfGroceries;
   }

   public void setAmountOfGroceries(float amountOfGroceries) {
      this.amountOfGroceries = amountOfGroceries;
   }

   public float getAmountOfNonGroceries() {
      return amountOfNonGroceries;
   }

   public void setAmountOfNonGroceries(float amountOfNonGroceries) {
      this.amountOfNonGroceries = amountOfNonGroceries;
   }

   public int getNoOfMonthsOfAssociation() {
      return noOfMonthsOfAssociation;
   }

   public void setNoOfMonthsOfAssociation(int noOfMonthsOfAssociation) {
      this.noOfMonthsOfAssociation = noOfMonthsOfAssociation;
   }

   public float getCategoryDiscount() {
      return categoryDiscount;
   }

   public void setCategoryDiscount(float categoryDiscount) {
      this.categoryDiscount = categoryDiscount;
   }

   //categoryDiscount CALCULATION FOR NORMAL CUSTOMER
   public float discountCalculation() {

      //CHECK FOR CUSTOMER > 2 years
      if(getNoOfMonthsOfAssociation()>=24) {
         categoryDiscount=(5*amountOfNonGroceries)/100;
      }

      return categoryDiscount;
   }

   public float getFinalAmount() {
      return finalAmount;
   }

   //TOTAL PAYABLE AMOUNT
   public float calculateTotalPaybleAmount(){

       finalAmount=(getAmountOfGroceries()+getAmountOfNonGroceries())-categoryDiscount; 
       int temp=(int)(finalAmount/100);
       temp=temp*5;
       finalAmount=finalAmount-temp;
       return finalAmount;
   }
}