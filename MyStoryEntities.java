package myclassproject.mystorygraph;
import com.entities.*;
import com.enums.ItemTypes;


public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	
	//Characters-Theo Frank
	
	public static final Characters King = new Characters("king", BodyTypes.B, Clothing.King, HairStyle.Short_Full, Colors.Black);
	public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Long, Colors.Black);
	public static final Characters beggar = new Characters("beggar", BodyTypes.H, Clothing.Beggar, HairStyle.Spiky, Colors.Black);
	
	//Places-Theo Frank
	public static final Place GreatHall = new place("Kings Palace", PlaceTypes.GreatHall);
	public static final Place City = new place("Kings Palace", PlaceTypes.City);
	
	// Items-Theo Frank
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Item bluebook = new Item("Magic Book", ItemTypes.BlueBook);
	
	
	
	
	

}
