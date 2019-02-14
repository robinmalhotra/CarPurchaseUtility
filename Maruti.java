class Maruti extends Car {
  private float mResale;

  Maruti(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
      setCar(CAR_ID, YEAR, PRICE, MODEL);
      mResale=computeResale(PRICE);
  }

  float computeResale(final float takeprice) {
      mResale=(float)((60.0/100.0)*takeprice);
      return mResale;
  }
  void showMaruti() {
    System.out.println("In Maruti Class now: ");
     getCar();
     System.out.println("Resale value = " + mResale);
  }

  /*public static void main(String[] args) {
    Maruti mtest= new Maruti(102,2018,20000,"800");
    mtest.showMaruti();
  }*/
}

/*
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
