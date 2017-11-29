/**
* @(#)Cable.java
* @author(s) Adam Garibay && Mathew Jackson
* @version 1.00 2017/11/22 @ 00:33
* Program Purpose: This is the cable class that has four methods.
*/

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;


public class Cable {

    Scanner input = new Scanner (System.in);
    LocalDate dateTime = LocalDate.now();
    Invoice[] cableBills = null;
    String[] billingStmts;


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

        int numBills = 0;

        System.out.printf("%nHow many bills are there to process?  ");
        numBills = input.nextInt(); //captures int from user.

        cableBills = new Invoice[numBills];
        billingStmts = new String[cableBills.length];

        for(int i=0; i < numBills; i++) {
            cableBills[i] = new Invoice();
            cableBills[i].setCustNm(i);
            //cableBills[i].setCablePkg(i);
            cableBills[i].determineCableSrv(i);
            cableBills[i].setMoviesPurchased(i);
        }
    }

    public void displayBills() {

        for (Invoice cableBills : cableBills) {

            double total = cableBills.getMoviePurchased() + cableBills.getCableSrv();
            double movieCharges = cableBills.getMoviePurchased();

            billingStmts[0] = String.format("%nCustomer: %S"
                                            + "%n%nCable Service: %20c%,10.2f"
                                            + "%nMovies-On-Demand-HD: %14c%,10.2f"
                                            + "%n%nTOTAL DUE: %24c%,10.2f%n",
                                            cableBills.getCustNm(), '$',
                                            cableBills.getCableSrv(), ' ', movieCharges, '$', total);

            System.out.printf("%nSA CABLE CHARGES AS OF %tD", dateTime);
            System.out.printf(Arrays.toString(billingStmts).replace("[", "").replace("]", "").replace(", null", ""));
            printThankYou();



        }
    }

    public void printThankYou() {

        System.out.printf("%nThank you for being a valued SA Cable Customer!%n%n");
    }

}
