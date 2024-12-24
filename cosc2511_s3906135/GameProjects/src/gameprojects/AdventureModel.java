package gameprojects;

import java.util.HashMap;
import java.util.Scanner;

public class AdventureModel {
 private Room rooms[];
 private Items Item[];
 private Adventurer adventurer;
 private Wall walls[];
 private Water waters[];
 
 public AdventureModel() {
    }
 public void initGame(){
 Item = new Items[11];
 walls = new Wall[4];
 waters = new Water[10];
 rooms = new Room[16];
 
 for(int i =0 ;i< 4 ;i++) 
 walls[i] = new Wall();
 
 for(int i =0 ;i< 10 ;i++) 
 waters[i] = new Water();
 
 
 Item[0] = new Items("Sword", "A short sword");
 Item[1] = new Items("Bow", "An Oak longbow");
Item[2] = new Items("Arrow", "Basically useless without a bow");
 Item[3] = new Items("Coin",   "Gold? maybe a merchant needs that");
 Item[4] = new Items("Key", "Hmm whats the key for?");
 Item[5] = new Items("DemonBone ", "The remains of a demon");
Item[6] = new Items("Lamp", "A light source");
Item[7] = new Items("Potion", "Must need for an adventure");
Item[8] = new Items("Shield", "Block Damage");
Item[9] = new Items("Necklace", "Necklace of Hope");
 Item[10] = new Items("Key", "A rusty key");
 
 rooms[0] = new Room("Merchant","Needs 1 coin to sell you things");
 rooms[0].addObject(Item[3]);
 rooms[0].addObject(Item[3]);
 
 
 
 rooms[1] = new Room("Town Square", "In the middle of your home town. ");
 rooms[2] = new Room("A Road", "Leads to the unknown. ");
 rooms[3] = new Room("SplitRoad","Three road either leading to Forest, DarkCrypt and Graveyard. ");
 rooms[4] = new Room("Forest","A narrow track wound steeply up through dense forest. " );
 rooms[6] = new Room("Tavern","A resting area for the hero and start postion. ");
 rooms[11] = new Room("King's Landing(End)","King's Landing(End). ");
 
 rooms[5] = new Room("AbandonedHouse","A dark house. ");
 rooms[5].addObject(Item[6]);


 
 rooms[7] = new Room("Graveyard","For the dead. ");
 rooms[7].addObject(Item[10]);
 
 
 rooms[8] = new Room("Chest Room","TREASURE, well not really. ");
 rooms[8].addObject(Item[0]);
 
 
 rooms[9] = new Room("DarkCrypt","Really creepy, need a Lamp to brighten the area. ");
 rooms[9].addObject(Item[5]);
         
 rooms[10] = new Room("Dungeon","The darkest dungeon. ");
 rooms[10].addObject(Item[3]);
 
 
 
 
 
 //maping wall direction
 walls[0].addDirection("East", rooms[1]);
 walls[0].addDirection("South", rooms[0]);
 
 walls[1].addDirection("East", walls[2]);
 walls[1].addDirection("South", rooms[10]);
 walls[1].addDirection("West", walls[0]);
 
 walls[2].addDirection("East", walls[3]);
 walls[2].addDirection("South", waters[2]);
 walls[2].addDirection("West", walls[1]);
 
 walls[3].addDirection("East", waters[4]);
 walls[3].addDirection("South", waters[3]);
 walls[3].addDirection("West", walls[2]);
 
 
 //maping waters direction
 waters[0].addDirection("East", waters[1]);
 waters[0].addDirection("South", waters[4]);
 waters[0].addDirection("West", walls[3]);
 
 waters[1].addDirection("South", rooms[2]);
 waters[1].addDirection("West", waters[0]);
 
 waters[2].addDirection("East", waters[3]);
 waters[2].addDirection("West", rooms[1]);
 waters[2].addDirection("North", walls[2]);
 waters[2].addDirection("South", rooms[5]);
 
 waters[3].addDirection("East", waters[4]);
 waters[3].addDirection("West", waters[2]);
 waters[3].addDirection("North", walls[3]);
 waters[3].addDirection("South", waters[5]);
 
 waters[4].addDirection("East", rooms[2]);
 waters[4].addDirection("West", waters[3]);
 waters[4].addDirection("North", waters[0]);
 waters[4].addDirection("South", rooms[6]);
 
 waters[5].addDirection("East", rooms[6]);
 waters[5].addDirection("West", rooms[5]);
 waters[5].addDirection("North", waters[3]);
 waters[5].addDirection("South", rooms[10]);
 
 waters[6].addDirection("east", rooms[10]);
 waters[6].addDirection("west", rooms[9]);
 waters[6].addDirection("north", rooms[5]);
 waters[6].addDirection("south", waters[7]);
 
 waters[7].addDirection("East", rooms[15]);
 waters[7].addDirection("West", rooms[14]);
 waters[7].addDirection("North", waters[6]);
 
 waters[8].addDirection("East", waters[9]);
 waters[8].addDirection("West", rooms[15]);
 waters[8].addDirection("North", rooms[11]);
 
 waters[9].addDirection("West", waters[8]);
 waters[9].addDirection("North", rooms[12]);

 
 //maping rooms direction
 rooms[0].addDirection("East", rooms[1]);
 rooms[0].addDirection("North",walls[3]);
 rooms[0].addDirection("South",walls[3]);
 rooms[0].addDirection("West",walls[3]);
 
 
 rooms[1].addDirection("East",rooms[2]);
 rooms[1].addDirection("West",rooms[0]);
 rooms[1].addDirection("North",rooms[6]);
 rooms[1].addDirection("South",rooms[5]);
 
 rooms[2].addDirection("West",rooms[1]);
 rooms[2].addDirection("North",waters[1]);
 rooms[2].addDirection("South",waters[1]);
 rooms[2].addDirection("East",rooms[3]);
 
 rooms[3].addDirection("East",rooms[4]);
 rooms[3].addDirection("North",rooms[0]);
 rooms[3].addDirection("South",rooms[8]);
 rooms[3].addDirection("West",rooms[2]);
 
 rooms[4].addDirection("East",rooms[4]);
 rooms[4].addDirection("West",rooms[3]);
 rooms[4].addDirection("North",rooms[7]);
 rooms[4].addDirection("South",rooms[9]);
 
 rooms[5].addDirection("East",walls[3]);
 rooms[5].addDirection("West",walls[3]);
 rooms[5].addDirection("North",rooms[1]);
 rooms[5].addDirection("South",waters[6]);
 
 rooms[6].addDirection("East",walls[3]);
 rooms[6].addDirection("West",walls[1]);
 rooms[6].addDirection("North",walls[3]);
 rooms[6].addDirection("South",rooms[1]);
 
 rooms[7].addDirection("West",walls[3]);
 rooms[7].addDirection("North",rooms[8]);
 rooms[7].addDirection("South",rooms[3]);
 rooms[7].addDirection("East",walls[3]);
 
 rooms[8].addDirection("East",waters[1]);
 rooms[8].addDirection("North",walls[3]);
 rooms[8].addDirection("South",rooms[7]);
 rooms[8].addDirection("West",waters[1]);
 
 rooms[9].addDirection("East",walls[3]);
 rooms[9].addDirection("West",walls[2]);
 rooms[9].addDirection("North",rooms[4]);
 rooms[9].addDirection("South",rooms[10]);

 rooms[10].addDirection("East",walls[3]);
 rooms[10].addDirection("West",walls[3]);
 rooms[10].addDirection("North",rooms[9]);
 rooms[10].addDirection("South",walls[1]);
 
 rooms[11].addDirection("East",rooms[12]);
 rooms[11].addDirection("West",rooms[6]);
 rooms[11].addDirection("North",rooms[10]);
 rooms[11].addDirection("South",waters[8]);
 
     
 
 adventurer = new Adventurer(rooms[6],null,0);
    }
 public void startGame(){
 initGame();
 Scanner input = new Scanner(System.in);
 String cmd;
 Location currentLoc ,newLoc= null;
 int takeThing;
 
 boolean b = false;
 do{
 currentLoc = adventurer.getLocation();
 showHelpMenu();
 cmd = input.next();
 if(cmd.equalsIgnoreCase("Go")){
 do {
 System.out.println("Current Location : "+ currentLoc);
 System.out.println("Choose direction:");
 System.out.println("one of North, South, East, West");
 String direc = input.next();
 
 b = checkPathExist(direc,currentLoc);
 if(b) {
 newLoc = adventurerNextLocation(direc,currentLoc);
 adventurer.setLocation((Room) newLoc);
                }
 
 else {
 System.out.println("Here is Wall or Water ");
 System.out.println("You can't Move to this direction");
                     }
                }while(b==false);       
            }
 else if(cmd.equalsIgnoreCase("Look")){
 if(currentLoc instanceof Room)
                    ((Room) currentLoc).viewRoomContent();
 adventurer.viewAdventurerInventory();
            }
 else if(cmd.equalsIgnoreCase("Take")){
 if(currentLoc instanceof Room) {
                ((Room) currentLoc).viewRoomContent();
 System.out.println("Take the thing 0/1/2/3 .. from the room : ");
 takeThing = Integer.parseInt(input.next());
 Items t = ((Room) currentLoc).getRoomItem(takeThing);
 adventurer.take(t);
 adventurer.viewAdventurerInventory();
                }
 
            }
 else if(cmd.equalsIgnoreCase("Drop")){
 adventurer.viewAdventurerInventory();
 System.out.println("Drop the thing 0/1/2/3 .. from the Inventory to room : ");
 takeThing = Integer.parseInt(input.next());
 if(currentLoc instanceof Room) {
 Items t =adventurer.getInventoryItem(takeThing);
                    ((Room) currentLoc).addObject(t);
                    ((Room) currentLoc).viewRoomContent();
                }
 
            }
 else if(cmd.equalsIgnoreCase("Use")){
 adventurer.viewAdventurerInventory();
 System.out.println("Use the thing 0/1/2/3 .. from the Inventory : ");
 takeThing = Integer.parseInt(input.next());
 Items t =adventurer.getInventoryItem(takeThing);
 adventurer.drop(t);
            }
 else if(cmd.equalsIgnoreCase("Exit")){
 System.exit(0);
            }
 else{
 System.out.println("Invalid command");
            }
 
        }while(true);
 
    }
 public void showHelpMenu() {
 System.out.println("Choose command: ");
 System.out.println("Go");
 System.out.println("Look");
 System.out.println("Take");
 System.out.println("Drop");
 System.out.println("Use");
 System.out.println("Exit ");
 System.out.println();
    }
 
 public boolean checkPathExist(String path , Location loc) {
 
 HashMap<String ,Location> hm = loc.getRoomDir();
 if(hm.containsKey(path)) {
 if(hm.get(path) instanceof Room)
 return true;
        }   
 return false;
        }
 
 public Location adventurerNextLocation(String path , Location loc) {
 
 HashMap<String ,Location> hm = loc.getRoomDir();
 if(hm.containsKey(path)) {
 if(hm.get(path) instanceof Room)
 return hm.get(path);
        }
 return loc;
 
    }
}
