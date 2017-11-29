/**
 * @(#)Cable.java
 * @author(s) Adam Garibay && Mathew Jackson
 * @version 1.00 2017/11/22 @ 00:33
 * Program Purpose: This is the cable class that has four methods.
 */

import java.util.Scanner;
import java.time.LocalDate;

public class Cable {
  
  private Scanner input = new Scanner (System.in);
  private LocalDate dateTime = LocalDate.now();
  private Invoice[] cableBills = null;
  private String[] billingStmts;
  
  
  public Cable() {  //empty constructor
  }
  
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
  
  public void processBills() {
    
    System.out.printf("%nHow many bills are there to process?  ");
    int numBills = input.nextInt(); //captures int from user.
    
    cableBills = new Invoice[numBills];
    billingStmts = new String[cableBills.length];
    
    for(int i=0; i < numBills; i++) {
      cableBills[i] = new Invoice();
      cableBills[i].setCustNm(i);
      cableBills[i].determineCableSrv(i);
      cableBills[i].setMoviesPurchased(i);
      
      double total = cableBills[i].getMoviePurchased() + cableBills[i].getCableSrv();
      double movieCharges = cableBills[i].getMoviePurchased();
      
      billingStmts[i] = String.format("%nCustomer: %S"
                                        + "%n%nCable Service: %20c%,10.2f"
                                        + "%nMovies-On-Demand-HD: %14c%,10.2f"
                                        + "%n%nTOTAL DUE: %24c%,10.2f%n",
                                      cableBills[i].getCustNm(), '$',
                                      cableBills[i].getCableSrv(), ' ', movieCharges, '$', total);
    }
  }
  
  public void displayBills() {
    
    for (String billingStmts : billingStmts) {
      
      System.out.printf("%nSA CABLE CHARGES AS OF %tD", dateTime);
      System.out.println(billingStmts);
      printThankYou();
      
    }
  }
  
  public void printThankYou() {
    
    System.out.printf("%nThank you for being a valued SA Cable Customer!%n%n");
  } 
}
