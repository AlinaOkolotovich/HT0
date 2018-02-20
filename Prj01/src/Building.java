import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Building {

    String name;
    double totalBuildingSize = 0;
    double buildingSizeUnderFurniture = 0;
    double illuminationLevel = 0;
    int numberOfRooms = 0;
    int numberOfWindows = 0;
    public HashMap<String, Room> roomList = new HashMap<>();


    public Building(String buildingName) {
        this.name = buildingName;
        this.totalBuildingSize = 0;
        this.buildingSizeUnderFurniture = 0;
        this.numberOfRooms = 0;
        this.illuminationLevel = 0;
    }

    public Building() {
    }

    public void describe() {
        System.out.println("Building " + this.name + " info.");
        for (Room r: roomList.values()) {
            r.describe();
        }
        System.out.println("Number of rooms in building: " + this.numberOfRooms + ", building size: " + this.totalBuildingSize + " sq.m, area under furniture: " + this.buildingSizeUnderFurniture + " sq.m.");
    }
    public HashMap<String,Room> addRoom (String roomName, double roomSize, int numberOfWindows){
        Room r1 = new Room(roomName, roomSize, numberOfWindows);
        this.roomList.put(roomName, r1);
        this.numberOfRooms += 1;
        this.totalBuildingSize += roomSize;
        this.numberOfWindows += numberOfWindows;
        return roomList;
    }

    public double getIlluminationLevel() {
        for (int i = 0; i < this.roomList.size() ; i++) {
            Room room = this.roomList.get(i);
            double roomLuminance  = room.getTotalLampsLuminance() + room.getTotalWindowLuminance();
            illuminationLevel +=roomLuminance;
        }
        return illuminationLevel;
    }

    public Room getRoom(String roomName) {
        Room room = roomList.get(roomName);
        return room;
    }
    public int getTotalnumberOfWindows(){
        int numberOfWindows = 0;
     for (Room r: roomList.values()) {
        numberOfWindows +=r.getNumberOfWindows();
    }
    return numberOfWindows;
}
}
