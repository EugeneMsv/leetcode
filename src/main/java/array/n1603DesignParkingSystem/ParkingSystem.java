package array.n1603DesignParkingSystem;

class ParkingSystem {

  int[] parking =  new int[4];

  public ParkingSystem(int big, int medium, int small) {
    this.parking[1]=big;
    this.parking[2]=medium;
    this.parking[3]=small;
  }

  public boolean addCar(int carType) {
    if(parking[carType]>0){
      parking[carType]-=1;
      return true;
    }
    return false;
  }
}
