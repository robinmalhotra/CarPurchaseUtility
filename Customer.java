import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private int mCustomerId;
    private String mCustomerName;
    private ArrayList<Car> mCustomerCarList= new ArrayList<>();

    void createCarList() {
      System.out.println("b");
    }
      void addCustomer(Customer cust) {

      Scanner sc = new Scanner(System.in);

      System.out.println("Enter the name of Customer: ");
      cust.mCustomerName=sc.nextLine();
      System.out.println("Enter the ID of Customer: ");
      cust.mCustomerId=sc.nextInt();
      System.out.println("Add Cars for this Customer: ");
      System.out.println("List of Cars available");
      System.out.println("'1' for Hyundai");
      System.out.println("'2' for Maruti");
      System.out.println("'3' for Toyota");
      int carChoice=sc.nextInt();
      switch(carChoice)
      {
        case 1: cust.mCustomerCarList.add(cust.addHyundai);
        break;

        case 2: cust.mCustomerCarList.add(cust.addMaruti);
        break;

        case 3: cust.mCustomerCarList.add(cust.addToyota);
        break;

        default:
          System.out.println("Choice not available");
      }
      System.out.println("Do you want to add more cars? Y/N");
      String addCarDecision=sc.nextLine();
      if (addCarDecision=="Y" ||addCarDecision=='y') 

}


/* * This application is controlled by the admin who will manage customers along with their purchased cars.
* Customer will have an ID, name, and list of purchased Cars
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
/* * Add new Customer,
* Add new Car to an existing Customer,
* List all Customers with their cars sorted by name,
* List individual Customer based on ID,
* Generate prizes for the customer(Explained Below). */
