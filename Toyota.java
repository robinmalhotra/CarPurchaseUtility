import java.util.Scanner;

class Toyota extends Car {
  //Since the resale of every Car is unique for its own, it has mResale variable private  to itself.
  private float mResale;

  //Constructs the Toyota Car with no values.
  Toyota (){
      setCar(0,0,(float)0.0,"");
      mResale=(float)0.0;
  }

  //Constructor that creates a object of type Toyota with specified values.
  Toyota(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
      setCar(CAR_ID, YEAR, PRICE, MODEL);
      mResale=computeResale(PRICE);
  }

  float computeResale(final float takeprice) {
    mResale=(float)((80.0/100.0)*takeprice);
    return mResale;
  }
  void showCar() {
    System.out.println("In Toyota Class now: ");
     getCar();
     System.out.println("Resale value = Rs " + mResale);
   }

     Car addCar() {
     Scanner scanme= new Scanner(System.in);

     System.out.println("Enter the Car ID: ");
     int mCarIdForAdd=scanme.nextInt();
     System.out.println("Enter the Car Year: ");
     int mCarYearForAdd=scanme.nextInt();
     System.out.println("Enter the Car Price: Rs ");
     float mCarPriceForAdd=scanme.nextFloat();
     System.out.println("Enter the Car Model: ");
     String mCarModelForAdd=scanme.next();

     Toyota addT= new Toyota(mCarIdForAdd,mCarYearForAdd,mCarPriceForAdd,mCarModelForAdd);

     return addT;
   }

}

/*
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
