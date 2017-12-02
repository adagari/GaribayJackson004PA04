/**
 * @(#)Cable.java
 * @author(s) Adam Garibay && Mathew Jackson
 * @version 1.00 2017/11/22 @ 00:33
 * Program Purpose: This is the cable class that has four methods.
 */

import java.util.Scanner;   //import Scanner for user input.
import java.time.LocalDate; //import LocalDate to display current date.

public class Cable {
  
  private Scanner input = new Scanner (System.in);  //declare and initialize new Scanner.
  private LocalDate dateTime = LocalDate.now();     //declare and initialize new LocalDate.
  private Invoice[] cableBills = null;              //declare cableBills array.
  private String[] billingStmts;                    //declare billingStmts array.
  
  
  /**
   *By Adam Garibay
   *This is any empty constructor.
   */ 
  public Cable() {
  }
  
  /**
   *By Adam Garibay
   *This method captures char 'y' or 'n' to start the entire process.
   *If 'y' starts process, else receives printThankYou() method.
   */
  public void start() {
    System.out.printf("%nDo you want to begin processing cable  bills? Enter 'Y' or 'N':  ");
    char answer = input.next().charAt(0); //captures char input from user.
    
    if(Character.toUpperCase(answer) == 'Y') {
      processBills();
      displayBills();
    } else {
      printThankYou();
    }
  }
  
  /**
   *By Adam Garibay
   *This method captures the amount of bills the customer is ready to process.
   *Sets the array sizes, calls methods in a for loop, calculates the total
   *and movie charges, and adds them as a String.format to the billingStmts
   *array.
   */ 
  public void processBills() {
    
    System.out.printf("%nHow many bills are there to process?  ");
    int numBills = input.nextInt(); //local variable captures int from user.
    
    cableBills = new Invoice[numBills];
    billingStmts = new String[numBills];
    
    for(int i=0; i < numBills; i++) {
      cableBills[i] = new Invoice();
      cableBills[i].setCustNm(i);
      cableBills[i].determineCableSrv(i);
      cableBills[i].setMoviesPurchased(i);
      
      double total = cableBills[i].getMoviePurchased() + cableBills[i].getCableSrv(); //local variable calculates the total/
      double movieCharges = cableBills[i].getMoviePurchased();                        //local variable calculates the movie charges.
      
      billingStmts[i] = String.format("%nCustomer: %S"
                                        + "%n%nCable Service: %20c%,10.2f"
                                        + "%nMovies-On-Demand-HD: %14c%,10.2f"
                                        + "%n%nTOTAL DUE: %24c%,10.2f%n",
                                      cableBills[i].getCustNm(), '$',
                                      cableBills[i].getCableSrv(), ' ', movieCharges, '$', total);
    }
  }
  
  /**
   *By Adam Garibay
   *This method uses an enhanced for loop to print out the billingStmts array.
   */
  public void displayBills() {
    
    System.out.println();
    
    for (String billingStmts : billingStmts) {
      
      System.out.printf("%nSA CABLE CHARGES AS OF %tD", dateTime);
      System.out.println(billingStmts);
      printThankYou();     
    }
  }
  /**
   *By Adam Garibay
   *This method thanks our valuable customers!
   */
  public void printThankYou() {
    
    System.out.printf("Thank you for being a valued SA Cable Customer!%n%n");
  } 
}
