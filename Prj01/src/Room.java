import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Room extends Building {
    String name;
    double roomSize;
    double roomSizeUnderFurniture = 0;
    int numberOfWindows = 0;
    int numberOfLamps = 0;
    final double MAX_LUMINANCE = 4000;
    final double MAX_ALLOWED_FURNITURE_PERCENTAGE = 70;
    public List<Lamp> lampList = new ArrayList<>();
    public List<Furniture> furnitureList = new ArrayList<>();

    public Room(String roomName, double roomSize, int numberOfWindows) {
        this.name = roomName;
        this.roomSize = roomSize;
        this.numberOfWindows = numberOfWindows;
        this.numberOfLamps = 0;
        lampList = new ArrayList<>();
    }

    public void describe() {
        System.out.println(" Room " + this.name + " info.\n  Room size is: " + this.roomSize + " sq. m , number of windows is: " + this.numberOfWindows + ", number of lamps is: " + this.numberOfLamps + ", total room luminance is : " + this.getTotalRoomLuminance());
    }

    public int addLamp(int numberOfLampsToAdd, double illuminanceOfLampToAdd) {
        for (int i = 0; i < (numberOfLampsToAdd); i++) {
            if (isMaxLuminanceReached()) {
                break;
            } else {
                this.lampList.add(new Lamp(illuminanceOfLampToAdd));
                this.numberOfLamps += 1;
            }
        }
        System.out.println("Number of lamps is: " + this.numberOfLamps);
        return numberOfLamps;
    }

    // this method checks if the max luminance level is not reached
    private boolean isMaxLuminanceReached() {
        boolean isMaxLuminanceReached = true;
        double roomLuminance = this.getTotalRoomLuminance();
        if (roomLuminance <= MAX_LUMINANCE) {
            isMaxLuminanceReached = false;
        } else {
            isMaxLuminanceReached = true;
            System.out.println("OOPS, total room luminance is reached. You can not add new lamp");
        }
        return isMaxLuminanceReached;
    }

    // this method count total luminance of all the lamps in a room
    public double getTotalLampsLuminance() {
        double totalLampsIuminance = 0;
        if (lampList.size() == 0) {
            totalLampsIuminance = 0;
        } else {
            for (Lamp lampToCount : lampList) {
                totalLampsIuminance += lampToCount.getIlluminance();
            }
        }
        return totalLampsIuminance;
    }
    public int getNumberOfWindows() {
        return this.numberOfWindows;
    }

    public double getTotalWindowLuminance() {
        double totalWindowLuminance = 0;
        if (numberOfWindows == 0) {
            totalWindowLuminance = 0;
        } else {
            totalWindowLuminance = this.numberOfWindows * 700;
        }
        return totalWindowLuminance;
    }

    public double getTotalRoomLuminance() {
        double totalRoomLuminance = this.getTotalLampsLuminance() + this.getTotalWindowLuminance();
        return totalRoomLuminance;
    }

    private double getRoomSizeUnderFurniture() {
        return this.roomSizeUnderFurniture;
    }

    public double addFurniture(String furnitureName, double furnitureSize, int numberOfFurnitureUnits) {
        double roomUnderFurniture;
        if (numberOfFurnitureUnits == 0) {
            System.out.println("Nothing has been added.");
        } else {
            for (int i = 0; i < numberOfFurnitureUnits; i++) {
                if (canAddMoreFurniture(furnitureSize) == false) {
                    break;
                } else {
                    if (numberOfFurnitureUnits == 1) {
                        roomUnderFurniture = getRoomSizeUnderFurniture() + furnitureSize;
                        this.roomSizeUnderFurniture = roomUnderFurniture;
                        System.out.println((i + 1) + " " + furnitureName + " has been added");
                        break;
                    } else {
                        System.out.println((i + 1) + " " + furnitureName + "s have been added");
                        roomUnderFurniture = +getRoomSizeUnderFurniture() + furnitureSize;
                        this.roomSizeUnderFurniture = roomUnderFurniture;
                    }
                }
            }
        }
        System.out.println("Room under furniture is : " + this.getRoomSizeUnderFurniture());
        return roomSizeUnderFurniture;
    }

    private boolean isMaxFurnitureSizeReached() {
        boolean isMaxFurnitureSizeReached = true;
        if ((getRoomSizeUnderFurniture() / this.roomSize) * 100 <= MAX_ALLOWED_FURNITURE_PERCENTAGE) {
            isMaxFurnitureSizeReached = false;
        } else {
            isMaxFurnitureSizeReached = true;
            System.out.println("OOPS, total room size under furniture is reached. You can not add new furniture item.");
        }
        return isMaxFurnitureSizeReached;
    }

    private boolean canAddMoreFurniture(double furnitureSize) {
        boolean canAddMoreFurniture = false;
        if (isMaxFurnitureSizeReached()) {
            canAddMoreFurniture = false;
        } else {
            if (((getRoomSizeUnderFurniture() + furnitureSize) / this.roomSize * 100) > MAX_ALLOWED_FURNITURE_PERCENTAGE) {
                canAddMoreFurniture = false;
            }
            if (((getRoomSizeUnderFurniture() + furnitureSize) / this.roomSize * 100) <= MAX_ALLOWED_FURNITURE_PERCENTAGE) {
                canAddMoreFurniture = true;
            }
        }
        return canAddMoreFurniture;
    }



}
