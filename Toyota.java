class Toyota extends Car {
  private float mResale;

  Toyota(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
      setCar(CAR_ID, YEAR, PRICE, MODEL);
      mResale=computeResale(PRICE);
  }

  float computeResale(final float takeprice) {
    mResale=(float)((80.0/100.0)*takeprice);
    return mResale;
  }
  void showToyota() {
    System.out.println("In Toyota Class now: ");
     getCar();
     System.out.println("Resale value = " + mResale);
   }
/*  public static void main(String[] args) {
    Toyota ttest= new Toyota(103,2019,20000, "Etios");
    ttest.showToyota();*/
  }
}

/*
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
