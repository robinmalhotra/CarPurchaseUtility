import java.util.Scanner;

class Hyundai extends Car {

    private float mResale;

    Hyundai(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
        setCar(CAR_ID, YEAR, PRICE, MODEL);
        mResale=computeResale(PRICE);
    }

    float computeResale(final float takeprice) {
        mResale=(float)((40.0/100.0)*takeprice);
        return mResale;
    }
     void showHyundai() {
       System.out.println("In Hyundai Class now: ");
        getCar();
        System.out.println("Resale value = " + mResale);
     }
       Car addHyundai(Car addHyun) {
       Scanner scanme= new Scanner(System.in);


       System.out.println("Enter the Car ID: ");
       int mCarIdForAddHyundai=scanme.nextInt();
       System.out.println("Enter the Car Year: ");
       int mCarYearForAddHyundai=scanme.nextInt();
       System.out.println("Enter the Car Model: ");
       String mCarModelForAddHyundai=scanme.nextLine();
       System.out.println("Enter the Car Price: ");
       float mCarPriceForAddHyundai=scanme.nextFloat();

       Hyundai addH= new Hyundai(mCarIdForAddHyundai,mCarYearForAddHyundai,mCarPriceForAddHyundai,mCarModelForAddHyundai);
       addHyun=addH;
       return addHyun;
     }

public static void main(String[] args) {
    
}
}

/*
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
