package hashing.n1396DesignUndergroundSystem;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
  Map<Integer, Travel> inTravel;
  Map<String, TripStats> stats;

  public UndergroundSystem() {
    inTravel =  new HashMap<>();
    stats =  new HashMap<>();
  }

  public void checkIn(int id, String startStation, int startTime) {
    inTravel.put(id, new Travel(startStation, startTime));
  }

  public void checkOut(int id, String endStation, int endTime) {
    Travel travel = inTravel.get(id);
    String statsKey = statsKey(travel.startStation, endStation);
    TripStats trip = stats.getOrDefault(statsKey, new TripStats());
    trip.recordStat(endTime-travel.startTime);
    stats.put(statsKey, trip);
  }

  public double getAverageTime(String startStation, String endStation) {
    return stats.getOrDefault(statsKey(startStation, endStation), new TripStats()).currentAvg;
  }

  String statsKey(String startStation, String endStation){
    return startStation+";"+endStation;
  }

  private static class Travel{
    String startStation;
    int startTime;

    Travel(String startStation,int startTime){
      this.startStation=startStation;
      this.startTime =startTime;
    }
  }

  private static class TripStats{
    double currentAvg;
    int customersCount;


    double recordStat(int tripLength){
      currentAvg = (currentAvg*(double)customersCount +tripLength)/(customersCount+1);
      customersCount+=1;
      return currentAvg;
    }
  }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */