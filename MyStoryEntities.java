package myclassproject.mystorygraph;
import com.entities.*;




import com.enums.FurnitureTypes;
import com.enums.ItemTypes;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.HairStyle;
import com.enums.Colors;
import com.enums.PlaceTypes;
import com.enums.Effects;


public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	
	//Characters-Theo Frank
	
	public static final Characters King = new Characters("king", BodyTypes.B, Clothing.King, HairStyle.Short_Full, Colors.Black,6);
	public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Long, Colors.Black,6);
	public static final Characters beggar = new Characters("beggar", BodyTypes.H, Clothing.Beggar, HairStyle.Spiky, Colors.Black,6);
	public static final Characters Knight = new Characters("Knight", BodyTypes.A, Clothing.HeavyArmour, HairStyle.Short, Colors.Black,6);
	public static final Characters Bartender = new Characters("Bartender", BodyTypes.C, Clothing.Merchant, HairStyle.Spiky, Colors.Black,6);
	public static final Characters Priest = new Characters("Priest", BodyTypes.G, Clothing.Priest, HairStyle.Straight, Colors.Black,6);
	public static final Characters Merchant = new Characters("Merchant", BodyTypes.B, Clothing.Merchant, HairStyle.Musketeer_Full, Colors.Black,6);
	public static final Characters MysteryMan = new Characters("MysteryMan", BodyTypes.F, Clothing.Warlock, HairStyle.Mage_Full, Colors.Black,6);
	public static final Characters Bandit = new Characters("Bandit", BodyTypes.C, Clothing.Bandit, HairStyle.Short, Colors.Black,6);
	//Places-Theo Frank
	public static final Place GreatHall = new Place("GreatHall", PlaceTypes.GreatHall);
	public static final Place City = new Place("City", PlaceTypes.City);
	public static final Place Tavern = new Place("Tavern", PlaceTypes.Tavern);
	public static final Place ForestPath = new Place("ForestPath", PlaceTypes.ForestPath);
	public static final Place Bridge = new Place("Bridge", PlaceTypes.Bridge);
	public static final Place Port = new Place("Port", PlaceTypes.Port);
	public static final Place Ruins = new Place("Ruins", PlaceTypes.Ruins);
	
	
	// Items-Theo Frank
	public static final Item sword = new Item("sword", ItemTypes.Sword);
	public static final Item Bottle = new Item("Bottle", ItemTypes.Bottle);
	public static final Item BlueKey = new Item("BlueKey",ItemTypes.BlueKey);
	public static final Item RedKey = new Item("RedKey",ItemTypes.RedKey);
	public static final Item sword1 = new Item("sword1", ItemTypes.Sword);
	public static final Item Bag = new Item("Bag", ItemTypes.Bag);
	public static final Item Apple = new Item("Apple", ItemTypes.Apple);
	// Effects Theo Frank
    public static final Furniture Chair = new Furniture(Tavern, FurnitureTypes.Chair);
    public static final Furniture Bench = new Furniture(City, FurnitureTypes.Bench);
    public static final Furniture Throne = new Furniture(GreatHall, FurnitureTypes.Throne);
    public static final Furniture Barrel = new Furniture(Tavern, FurnitureTypes.Barrel);
    public static final Furniture Table = new Furniture(Tavern, FurnitureTypes.Table);
    public static final Furniture Altar = new Furniture(ForestPath, FurnitureTypes.Altar);
    public static final Furniture WestEnd = new Furniture(City, FurnitureTypes.WestEnd);
    public static final Furniture EastEnd = new Furniture(City, FurnitureTypes.EastEnd);
    public static final Furniture Fountain = new Furniture(City, FurnitureTypes.Fountain);
    public static final Furniture RedHouseDoor = new Furniture(City, FurnitureTypes.RedHouseDoor);
    public static final Furniture SouthSign = new Furniture(Bridge, FurnitureTypes.SouthSign);
    public static final Furniture Plant = new Furniture(Ruins, FurnitureTypes.Plant);
    public static final Furniture BigStall = new Furniture(Port, FurnitureTypes.BigStall);
    public static final Furniture Plant1 = new Furniture(ForestPath, FurnitureTypes.Plant);
    public static final Furniture RightThrone = new Furniture(GreatHall, FurnitureTypes.RightThrone);
    public static final Furniture Gate = new Furniture(GreatHall, FurnitureTypes.Gate);
    public static final Furniture NorthEnd = new Furniture(City, FurnitureTypes.NorthEnd);
    public static final Furniture BlueHouseDoor = new Furniture(City, FurnitureTypes.BlueHouseDoor);
    public static final Furniture TavernDoor = new Furniture(Tavern, FurnitureTypes.Door);
    public static final Furniture EastEnd1 = new Furniture(ForestPath, FurnitureTypes.EastEnd);
    public static final Furniture WestEnd1 = new Furniture(ForestPath, FurnitureTypes.WestEnd);
    public static final Furniture Exit = new Furniture(Ruins, FurnitureTypes.Exit);
    public static final Furniture SouthEnd = new Furniture(Bridge, FurnitureTypes.SouthEnd);
    public static final Furniture NorthEnd1 = new Furniture(Bridge, FurnitureTypes.NorthEnd);
    public static final Furniture Exit1 = new Furniture(Port, FurnitureTypes.Exit);
    public static final Effects Heart = Effects.Heart;
    public static final Effects Aura = Effects.Aura;
    public static final Effects Resurrection = Effects.Resurrection;

    
    
	
	
	
	
	
	

}
