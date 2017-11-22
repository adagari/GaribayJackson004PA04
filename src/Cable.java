import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;


public class Cable {
  
  Scanner input = new Scanner (System.in);
  LocalDate dateTime = LocalDate.now();
  Invoice[] cableBills = null;
  String[] billingStmts;
  
  
  public Cable(){
  }
  
  public void start() { 
    System.out.printf("%nDo you want to begin processing cable  bills? Enter 'Y' or 'N':  ");
    char answer = input.next().charAt(0);
    
    if(Character.toUpperCase(answer) == 'Y'){
      processBills();
      displayBills();
    } else {
      printThankYou();
    }
  }
  
  public void processBills(){
    
    int numBills = 0;
    
    System.out.printf("%nHow many bills are there to process?  ");
    numBills = input.nextInt();
    
    cableBills = new Invoice[numBills];
    billingStmts = new String[cableBills.length];
    
    for(int i=0;i < numBills; i++){      
      cableBills[i] = new Invoice();
      cableBills[i].setCustNm(i);
      cableBills[i].setCablePkg(i);
      cableBills[i].determineCableSrv(i);
      cableBills[i].setMoviesPurchased();
    }  
  }
  
  public void displayBills(){    
    
    for (Invoice numBills : cableBills){
      double total = numBills.getMoviePurchased() + numBills.getCableSrv();
      double movieCharges = numBills.getMoviePurchased();
      
      billingStmts[0] = String.format("%nCustomer: %S"
                                        + "%n%nCable Service: %20c%,10.2f"
                                        + "%nMovies-On-Demand-HD: %14c%,10.2f"
                                        + "%n%nTOTAL DUE: %24c%,10.2f%n",
                                      numBills.getCustNm(), '$',                                  
                                      numBills.getCableSrv(), ' ', movieCharges, '$', total);
      
      System.out.printf("%nSA CABLE CHARGES AS OF %s", dateTime);
      System.out.printf(Arrays.toString(billingStmts).replace("[", "").replace("]", "").replace(", null", ""));
      printThankYou();
      
      
      
    }      
  }
  
  public void printThankYou(){
    
    System.out.printf("%nThank you for being a valued SA Cable Customer!%n%n");
  }
  
}