package gameprojects;
import java.util.ArrayList;

public class Adventurer {
 private Room location;
 private Room moveFrom;
 private ArrayList<Items> inventory;
 private int numberOfObjects;
 
 public Adventurer() {
 location = null;
 moveFrom = null;
 inventory = new ArrayList<Items>();
 numberOfObjects = 0;
    }
 public Adventurer(Room location, Room moveFrom,int numberOfObjects) {
 super();
 this.location = location;
 this.moveFrom = moveFrom;
 this.inventory = new ArrayList<Items>();
 this.numberOfObjects = numberOfObjects;
    }
 public void take(Items item){
 inventory.add(item);
    }
 public void drop(Items item){
 inventory.remove(item);
    }
 public Room getLocation() {
 return location;
    }
 public void setLocation(Room location) {
 this.location = location;
    }
 public Room getMoveFrom() {
 return moveFrom;
    }
 public void setMoveFrom(Room moveFrom) {
 this.moveFrom = moveFrom;
    }
 public ArrayList<Items> getInventory() {
 return inventory;
    }
 public void setInventory(ArrayList<Items> inventory) {
 this.inventory = inventory;
    }
 public int getNumberOfObjects() {
 return numberOfObjects;
    }
 public void setNumberOfObjects(int numberOfObjects) {
 this.numberOfObjects = numberOfObjects;
    }
 
 public void viewAdventurerInventory() {
 System.out.println("Adventurer Inventory");
 System.out.println();
 if(inventory.size()==0)
 System.out.println("No Item in Inventory");
 else {
 for(int i = 0 ; i < inventory.size(); i++)
 System.out.println(i + "  " + inventory.get(i));
        }
 System.out.println();
    }
 
 public Items getInventoryItem(int takeItems) {
 Items t = inventory.get(takeItems);
 drop(t);
 return t;
    }
 
    @Override
 public String toString() {
 return "Adventurer [location=" + location + ", moveFrom=" + moveFrom + ", inventory=" + inventory
                + ", numberOfObjects=" + numberOfObjects + "]";
    }
 
 
 
}