package myclassproject.mystorygraph;

import java.util.List;


import com.storygraph.*;
import com.actions.EnableInput;
import com.actions.SetCameraFocus;
import com.actions.Face;
import com.actions.ShowMenu;
import com.actions.SetPosition;
import com.actions.Take;
import com.sequences.CreateCharacterSequence;
import com.actions.Exit;
import com.actions.Enter;
import com.actions.*;
import com.sequences.*;
import com.sequences.DialogSequence;
import myclassproject.mystorygraph.*;
//Theo Frank
import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.actions.Wave;






import myclassproject.questexample.NodeLabels;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootActions() {
		var root = get(MyNodeLabels.root.toString());
		root.add(new CreateAll(List.of(GreatHall, City )))
		.add(new CreateCharacterSequence(player))
		.add(new CreateCharacterSequence(King))
		.add(new CreateCharacterSequence(beggar))
		.add(new CreateCharacterSequence(Knight))
		.add(new CreateCharacterSequence(Bartender))
		.add(new SetPosition(player, GreatHall.Supplicant))
		.add(new SetPosition(King, GreatHall.Throne))
		.add(new SetPosition(beggar, City.Alley2))
		.add(new SetPosition(Bartender, Tavern.Barrel))
		.add(new SetPosition(Knight, City.RedHouseDoor))
		.add(new Face(player,King))
		.add(new SetPosition(sword, King))
		.add(new SetPosition(Bottle,Bartender))
		.add(new SetCameraFocus(player))
		.add(new ShowMenu());
		
		//Example:
		//var root = get(NodeLabels.root.toString());
		//root.add(new CreateAll(List.of(cottage, town, sword)));
		//Theo Frank
	}
	 @BuilderMethod
	 public void atGreatHall() {
	     var node = get(MyNodeLabels.atGreatHall.toString());
	     node.add(new HideMenu())
	     .add(new EnableInput())
	     .add(new DialogSequence(King, null,List.of("Hero, would you like to accept a quest on behalf of the kingdom?"),List.of("[Yes|Yes!]", "[No|No Thanks]")));
	 }
	 //Theo Frank

	 @BuilderMethod
	 public void agreedToQuest() {
	     var node = get(MyNodeLabels.agreedToQuest.toString());
	     node.add(new HideDialog())
	     .add(new DialogSequence(King, null,List.of("Thank you for agreeing to aid my kingdom. Recently, my kingdom has lost 2 keys of great importance and I need you to retrieve them. Each key is marked with a different color symbolizing a core of my kingdom: RED and BLUE. I have heard rumors that a bandit has one of the keys. Before you leave, here is something to aid you on your quest."),List.of("[Accept Sword|Accept Sword]")))
	     .add(new Take(player, sword, King));
	 }
	 //Theo Frank
	 @BuilderMethod
	 public void doNotTakeQuest() {
	     var node = get(MyNodeLabels.doNotTakeQuest.toString());
	     node.add(new HideDialog())
	     .add(new DialogSequence(player, null,List.of("And the Hero decided not to accept the quest, choosing to live happily ever after on a farm. The end."),List.of("[Close|Close]")))
	     .add(new ShowMenu());
	}
	 //Theo frank
	@BuilderMethod
	public void leaveGreatHall() {
		var node = get(MyNodeLabels.leaveGreatHall.toString());
		node.add(new HideDialog())
		.add(new Exit(player, GreatHall.Gate, true));
		
	}//theo Frank
	@BuilderMethod
	public void enterCity() {
		var node = get(MyNodeLabels.enterCity.toString());
        node.add(new Enter(player, City.Door, true))
		.add(new Exit(player, City.NorthEnd, true))
		.add(new Exit(player,City.WestEnd,true))
		.add(new Exit(player, City.BlueHouseDoor,true));
		
	}//Theo Frank
    @BuilderMethod
    public void enterTavern() {
        var node = get(MyNodeLabels.enterTavern.toString());
        node.add(new Enter(player, Tavern.Door, true))
        .add(new Wave(Bartender))
        .add(new Face(player,Bartender))
        .add(new Exit(player, Tavern.Door, true));
    }//Theo Frank
    @BuilderMethod
    public void talkWithBartender() {
        var node = get(MyNodeLabels.talkWithBartender.toString());
        node.add(new Face(player, Bartender))
            .add(new DialogSequence(Bartender, null,
                List.of("Would you like a drink to relax my young Hero?"),List.of("[No thanks|Leave]")));
    }//Theo Frank
    @BuilderMethod
    public void talkWithBeggar() {
        var node = get(MyNodeLabels.talkWithBeggar.toString());
        node.add(new DialogSequence(beggar, null,List.of("Hello my friend, I heard you are off on a quest. I hope you succeed and aid our kingdom."),List.of("[Close|Close]")));
    }//Theo Frank
}
