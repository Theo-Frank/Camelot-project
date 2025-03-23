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
		var root = get(NodeLabels.root.toString());
		root.add(new CreateAll(List.of(GreatHall, City )))
		.add(new CreateCharacterSequence(player))
		.add(new CreateCharacterSequence(King))
		.add(new CreateCharacterSequence(beggar))
		.add(new SetPosition(player, GreatHall))
		.add(new SetPosition(King, GreatHall))
		.add(new SetPosition(beggar, City))
		.add(new Face(player,King))
		.add(new CreateItem(sword,Sword))
		.add(new CreateItem(blueBook, BlueBook))
		.add(new SetPosition(Sword, King))
		.add(new SetPosition(blueBook,beggar))
		.add(new SetCameraFocus(player))
		.add(new ShowMenu());
		
		//Example:
		//var root = get(NodeLabels.root.toString());
		//root.add(new CreateAll(List.of(cottage, town, sword)));
		//Theo Frank
	}
	@BuilderMethod
	public void atGreatHall() {
		var node = get(NodeLabels.atGreatHall.toString);
		node.add(new HideMenu())
		.add(new EnableInput());
		.add(new SetDialog(King, "Hero, would you like to accept a quest on behalf of the kingdom?[Yes|Yes!] [No|No Thanks]"))
		.add(new ShowDialog());
		//Theo Frank
		
	}
	@BuilderMethod
	public void agreedToQuest() {
		var node = get(NodeLabel.agreedToQuest.toString);
		node.add(new HideDialog())
		.add(new SetDialog(King, " Thank you for Agreeing to aid my kingdom. Resently, my kingdom has lost 2 keys of great importance and I need you to retrieve them for me. Each key is marked with a different color symbolising a core of my kingdom, RED and BLUE.  I have heard rumors that a bandit has one of the keys. Before you leave here is something to aid you on your quest. [Accept Sword|Accept Sword]"))
		.add(new ShowDialog())
		.add(new Take(player, sword, King));
		//Theo Frank
	}
	@BuilderMethod
	public void doNotTakeQuest() {
		var node = get(NodeLabel.doNotTakeQuest.toString);
		node.add(new HideDialog())
		.add(new SetNarration("And the Hero decided not to accept the quest, Deciding to live happily ever after on a farm, the end"))
		.add(new ShowMenu());
		//Theo Frank
	}
	@BuilderMethod
	public void leaveGreatHall() {
		var node = get(NodeLabel.leaveGreatHall.toString);
		node.add(new HideDialog())
		.add(new Exit(player, GreatHall.door, true))
		
		
	}
	
}
