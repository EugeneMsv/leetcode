package stack.n853CarFleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

  public int carFleet(int target, int[] position, int[] speed) {
    List<Car> cars = new ArrayList<>(position.length);
    for (int carNum = 0; carNum < position.length; carNum++) {
      cars.add(new Car(position[carNum], speed[carNum]));
    }
    Collections.sort(cars, Comparator.comparing(Car::position).reversed());
    Stack<Car> fleets = new Stack<>();
    for (Car car : cars) {
      if (fleets.isEmpty()) {
        fleets.push(car);
      } else {
        Car aboveCar = fleets.peek();
        double aboveUntilDestination = (target - aboveCar.position) / (double) aboveCar.speed;
        double untilDestination = (target - car.position) / (double) car.speed;
        if (untilDestination > aboveUntilDestination) {
          fleets.push(car);
        }
      }
    }
    return fleets.size();
  }

  private class Car {

    final int position;
    final int speed;

    public Car(int position, int speed) {
      this.position = position;
      this.speed = speed;
    }

    public int position() {
      return this.position;
    }
  }
}
