import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private static int mCustomerId;
    private static String mCustomerFirstName;
    private static String mCustomerLastName;
    private static ArrayList<Car> mCustomerCarList;

    Customer(int mCustId, String mCustFirstName, String mCustLastName, ArrayList<Car> carsOfCustomer) {
      mCustomerId=mCustId;
      mCustomerFirstName=mCustFirstName;
      mCustomerLastName=mCustLastName;
      mCustomerCarList=carsOfCustomer;
    }
      ArrayList<Car> createCarList(int carCount) {

        ArrayList<Car> holdList=new ArrayList<>();

        if (carCount==0) {
            System.out.println("No Cars being added!");
            return holdList;
        }//if ends
        int count=0;
          //ArrayList<Car> holdList=new ArrayList<>();
          Scanner getCarsforList=new Scanner(System.in);
          do {
          System.out.println("Add Cars for this Customer: ");
          System.out.println("List of Cars available");
          System.out.println("'1' for Hyundai");
          //Hyundai newHyundai;
          System.out.println("'2' for Maruti");
          //Maruti newMaruti;
          System.out.println("'3' for Toyota");
          //Toyota newToyota;
          Car newCar;
          int carChoice=getCarsforList.nextInt();
          switch(carChoice) {
              case 1: Hyundai hyundaiCar= new Hyundai();
                      newCar=hyundaiCar.addCar();
                      //hyundaiCar=addCar;
                      holdList.add(newCar);
              break;
              case 2: Maruti marutiCar=new Maruti();
                      newCar=marutiCar.addCar();
                      holdList.add(newCar);
              break;
              case 3: Toyota toyotaCar=new Toyota();
                      newCar=toyotaCar.addCar();
                      holdList.add(newCar);
              break;
              default:
                System.out.println("This option is not available");
          }// switch ends
          count++;
        }while(count<carCount);
        /*  System.out.println("Do you want to add more cars? Y/N");
          String addCarDecision=getCarsforList.next();

          if (addCarDecision=="Y" ||addCarDecision=="y") {
            System.out.println("How many cars do you want to add?: ");
            int newcarCount=getCarsforList.nextInt();
            createCarList(carCount);
        }//if ends*/
          return holdList;
      }//function ends

      Customer addCustomer() {

      Scanner sc = new Scanner(System.in);

      System.out.println("Enter the ID of Customer: ");
      int mCustId=sc.nextInt();
      System.out.println("Enter the First name of Customer: ");
      String mCustFirstName=sc.next();
      System.out.println("Enter the Last name of Customer: ");
      String mCustLastName=sc.next();
      System.out.println("How many cars do you want to add?: ");
      int carCount=sc.nextInt();
      //createCarList(carCount);
      ArrayList<Car> carsOfCustomer=createCarList(carCount);
      Customer customerCreated=new Customer(mCustId,mCustFirstName,mCustLastName,carsOfCustomer);
        System.out.println("Customer Created");
      return customerCreated;

      }



  void showCustomer() {
  System.out.println("In Customer Class now");
  System.out.println("Id of Customer" + mCustomerId);
  System.out.println("First Name of Customer"+ mCustomerFirstName);
  System.out.println("First Last of Customer"+mCustomerLastName);
  System.out.println("Cars of this customer are: ");
  for(int i=0;i<mCustomerCarList.size();i++) {
    (mCustomerCarList.get(i)).showCar();
  }
}


/*public static void main(String[] args) {
    Customer ctest1;
    ctest=addCustomer();
    ctest.showCustomer();
}*/
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
