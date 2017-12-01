/**
 * @(#)Invoice.java
 * @author(s) Adam Garibay && Mathew Jackson
 * @version 1.00 2017/11/22 @ 00:33
 * Program Purpose: This is the Invoice class that has five class variables.
 */

import java.util.Scanner;  //import Scanner for user input.

public class Invoice {
  
  private Scanner input = new Scanner(System.in);  //new scanner
  private String custNm = "";   //declare and initialize custNm
  private int cablePkg = 0;     //declare and initialize cablePkg
  private double cableSrv = 0;  //declare and initialize cableSrv
  private int noOfMovies = 0;   //declare and initialize noOfMovies
  
  /**
   *By Mathew Jackson
   *This is an empty constructor. 
   */  
  public Invoice() {    
  }
  
   /**
   *By Mathew Jackson
   *This is an overloaded constructor which accepts the name of the customer.
   *@param custNm The name of the customer.
   */  
  public Invoice(String custNm) {
    
    this.custNm = custNm;
  }
  
  /**
   *By Mathew Jackson
   *This method prints Welcome statement and captures
   *the customers 1st and last name.
   *@param num1 loop control value from the loop that calls it. 
   */
  public void setCustNm(int num1) {
    
    System.out.printf("%nWELCOME TO SA CABLE%n");  //output message header
    System.out.printf("%nPlease enter customer %d's name:  ", (num1+1));
    custNm = input.nextLine();  //captures String input from user.
  }
  
  /**
   *By Mathew Jackson
   *This method captures the cable subscription package.
   *@param num1 loop control value from the loop that calls it. 
   */
  public void setCablePkg(int num1) {
    System.out.printf("%nSA CABLE - SUBSCRIPTION PACKAGES - INCLUDES INTERNET SERVICE%n");                          //output for cable package header
    System.out.printf("%n1. Basic: Local & major TV network channels %26s %.2f", '$', 35.00);                       //outputs 1st pkg & cost
    System.out.printf("%n2. Deluxe: Local, major TV, cable & 100 other channels %21.2f", 75.00);                    //outputs 2st pkg & cost
    System.out.printf("%n3. Premium: Deluxe package plus HBO, on-demand & 300 other channels %8.2f", 110.00);       //outputs 3st pkg & cost
    System.out.printf("%n%nSelect the cable subscription package for customer %d:  ", (num1+1));
    
    while (!input.hasNextInt()) {  //while loop for when user does not input integer.
      input.next();
      System.out.printf("%nYou must only enter an integer:  %n");                                                  //output for cable package header
      System.out.printf("%n1. Basic: Local & major TV network channels %26s %.2f", '$', 35.00);                   //outputs 1st pkg & cost when user fails to input integer
      System.out.printf("%n2. Deluxe: Local, major TV, cable & 100 other channels %21.2f", 75.00);                //outputs 2nd pkg & cost when user fails to input integer
      System.out.printf("%n3. Premium: Deluxe package plus HBO, on-demand & 300 other channels %8.2f", 110.00);   //outputs 3rd pkg & cost when user fails to input integer
      System.out.printf("%n%nSelect the cable subscription package for customer %d:  ", (num1+1));
    }
    cablePkg = input.nextInt();  //captures Int input from user.
  }
  
  /**
   *By Mathew Jackson
   *This Method Assigns a Price for the Cable Service. 
   *@param num1 loop control value from the loop that calls it. 
   */
  public void determineCableSrv(int num1) {
    
    do {
      setCablePkg(num1);
      
      switch (cablePkg) {  //switch statment for cableSrv amounts in USD
        
        case 1:
          cableSrv = 35.00;   //1st cable service.
          break;  //case break
        case 2:
          cableSrv = 75.00;   //2nd cable service.
          break;  //case break
        case 3:
          cableSrv = 110.00;  //3rd cable service.
          break;  //case break
        default:
          System.out.printf("%nInvalid Selection!%n"); //output for any Int ! 1 through 3
      }
    } while (cablePkg < 1 || cablePkg > 3); //while loop continues for any int < 1 or > 3 
  }
  
  /**
   *By Mathew Jackson
   *This method captures the number of movies purchased.
   *@param num1 loop control value from the loop that calls it. 
   */  
  public void setMoviesPurchased(int num1) {
    
    System.out.printf("%nSA CABLE - MOVIES%n");
    System.out.printf("%nEnter the number of Movies-On-Demand-HD purchases for customer %d:  ", (num1+1));
    
    while (!input.hasNextInt()) {
      input.next();
      System.out.printf("%nYou must only enter an integer:  %n");
      System.out.printf("%nEnter the number of Movies-On-Demand-HD purchases:  ", (num1+1));
    }
    noOfMovies = input.nextInt();
  }
  
  /**
   *By Mathew Jackson
   *This method is a value returning method for the customers name.
   *@return The customer name.
   */
  public String getCustNm() {
    return custNm;
  }
  
  /**
   *By Mathew Jackson
   *This method is a value returning method for the type of Cable Package.
   *@return The cablePkg selected.
   */
  public int getCablePkg() {
    return cablePkg;
  }
  
  /**
   *By Mathew Jackson
   *This method is a value returning method for the price of cable survice.
   *@return The amount for cableSrv.
   */
  public double getCableSrv() {
    return cableSrv;
  } 
  
  /**
   *By Mathew Jackson
   *This is a value returning method for the amount of Movies-On-Demands.
   *@return The product of noOfMovies times 7.
   */ 
  public int getMoviePurchased() {
    return noOfMovies * 7;
  }  
}
