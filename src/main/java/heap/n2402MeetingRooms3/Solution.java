package heap.n2402MeetingRooms3;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  public int mostBooked(int n, int[][] meetings) {
    int[] rooms = new int[n];

    // 0 -> meetingStart, 1->  meetingEnd
    Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
    // 0 -> meetingEnd, 1->  roomNum
    PriorityQueue<int[]> roomQueue =  new PriorityQueue<>((a,b) -> a[0] - b[0] == 0 ? a[1] -b[1] : a[0]-b[0]);


    for(int[] meeting : meetings){

      int start = meeting[0];

      // Clear all rooms which are free before start
      while(!roomQueue.isEmpty() && roomQueue.peek()[0] <= start){
        int[] roomInfo = roomQueue.poll();
        unBookRoom(rooms, roomInfo[1]);
      }

      // If there is empty room
      if(roomQueue.size() < n){
        int roomNum = bookFirstRoom( rooms);
        roomQueue.offer(new int[]{meeting[1], roomNum});
      }else{
        int[] roomInfo = roomQueue.poll();
        int roomNum = roomInfo[1];
        unBookRoom(rooms, roomNum);
        roomQueue.offer(new int[]{roomInfo[0] +meeting[1] - meeting[0], roomNum});
        bookRoom( rooms, roomNum);
      }
    }

    int max=-1;
    int resultNum = -1;
    for(int roomNum = 0; roomNum < rooms.length;  roomNum++){

      if(Math.abs(rooms[roomNum]) > max){
        max =  Math.abs(rooms[roomNum]);
        resultNum = roomNum;
      }
    }
    return resultNum;
  }

  // Room is booked when it has negative value
  private int bookFirstRoom( int[] rooms){
    for(int roomNum = 0; roomNum <rooms.length; roomNum++){
      if(rooms[roomNum] >= 0){
        rooms[roomNum]+=1;
        rooms[roomNum]*=-1;
        return roomNum;
      }
    }
    return -1;
  }
  private int bookRoom(int[] rooms, int roomNum){
    rooms[roomNum]+=1;
    rooms[roomNum]*=-1;
    return roomNum;
  }

  private void unBookRoom(int[] rooms, int roomNum){
    rooms[roomNum]*=-1;
  }
}
