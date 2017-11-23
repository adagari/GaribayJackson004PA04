import java.util.Scanner;

public class Invoice {

    Scanner input = new Scanner(System.in);
    String custNm = "";
    int cablePkg = 0;
    double cableSrv = 0;
    int noOfMovies = 0;

    public Invoice() {

    }

    public Invoice(String custNm) {

        this.custNm = custNm;
    }

    public void setCustNm(int num1) {

        System.out.printf("%nWLECOME TO SA CABLE%n");
        System.out.printf("%nPlease enter customer %d's name:  ", (num1+1));
        this.custNm = input.nextLine();
    }

    public void setCablePkg(int num1) {
        System.out.printf("%nSA CABLE - SUBSCRIPTION PACKAGES - INCLUDES INTERNET SERVICE%n");
        System.out.printf("%n1. Basic: Local & major TV network channels %26s %.2f", '$', 35.00);
        System.out.printf("%n2. Deluxe: Local, major TV, cable & 100 other channels %21.2f", 75.00);
        System.out.printf("%n3. Premium: Deluxe package plus HBO, on-demand & 300 other channels %8.2f", 110.00);
        System.out.printf("%n%nSelect the cable subscription package for customer %d:  ", (num1+1));

        while (!input.hasNextInt()) {
            input.next();
            System.out.printf("%nYou must only enter an integer: %n");
            System.out.printf("%n1. Basic: Local & major TV network channels %26s %.2f", '$', 35.00);
            System.out.printf("%n2. Deluxe: Local, major TV, cable & 100 other channels %21.2f", 75.00);
            System.out.printf("%n3. Premium: Deluxe package plus HBO, on-demand & 300 other channels %8.2f", 110.00);
            System.out.printf("%n%nSelect the cable subscription package for customer %d:  ", (num1+1));
        }
        this.cablePkg = input.nextInt();
    }

    public void determineCableSrv(int num1) {

        do {
            setCablePkg(num1);

            switch (cablePkg) {

            case 1:
                this.cableSrv = 35.00;
                break;
            case 2:
                this.cableSrv = 75.00;
                break;
            case 3:
                this.cableSrv = 110.00;
                break;
            default:
                System.out.printf("%nInvalid Selection!%n");
            }
        } while (cablePkg < 1 || cablePkg > 3);
    }

    public void setMoviesPurchased(int num1) {

        System.out.printf("%nSA CABLE - MOVIES%n");
        System.out.printf("%nEnter the number of Movies-On-Demand-HD purchases for %d:  ", (num1+1));

        while (!input.hasNextInt()) {
            input.next();
            System.out.printf("%nYou must only enter an integer: %n");
            System.out.printf("%nEnter the number of Movies-On-Demand-HD purchases:  ", (num1+1));
        }
        this.noOfMovies = input.nextInt();
    }

    public int getMoviePurchased() {
        return noOfMovies * 7;
    }

    public double getCableSrv() {
        return cableSrv;
    }

    public int getCablePkg() {
        return cablePkg;
    }

    public String getCustNm() {
        return custNm;
    }
}