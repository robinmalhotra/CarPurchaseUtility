import java.util.Scanner;

class Hyundai extends Car {
    //Since the resale of every Car is unique for its own, it has mResale variable private  to itself.
    private float mResale;
    //Constructs the Hyundai Car with no values.
    Hyundai() {
        setCar(0,0,(float)0.0,"");
        mResale=(float)0.0;
    }
    //Constructor that creates a object of type Hyundai with specified values.
    Hyundai(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
        setCar(CAR_ID, YEAR, PRICE, MODEL);
        mResale=computeResale(PRICE);
    }
    //Overridden method to compute Resale value of Hyundai cars.
    float computeResale(final float TAKES_PRICE) {
        float takeprice=TAKES_PRICE;
        mResale=(float)((40.0/100.0)*takeprice);
        return mResale;
    }
    //Shows the the Hyundai Car details.
    void showCar() {
       System.out.println("It's a Hyundai Car. ");
        getCar();
        System.out.println("Resale value = Rs" + mResale);
     }
      // Method to create a Car Object.
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
       System.out.println(mCarModelForAdd);

       Car addH= new Hyundai(mCarIdForAdd,mCarYearForAdd,mCarPriceForAdd,mCarModelForAdd);

       return addH;
     }
}

/*
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
