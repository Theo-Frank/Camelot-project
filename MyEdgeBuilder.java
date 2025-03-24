package myclassproject.mystorygraph;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;
import com.entities.IInteract;
import com.playerInput.*;


public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	@BuilderMethod
	public void rootEdges() {
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.GreatHall.toString());
		root.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void startQuestEdges() {
		var node = get(MyNodeLabels.GreatHall.toString());
		var nextNodeIfAccepted = get(MyNodeLabels.agreedToQuest.toString());
		var acceptChoice = new DialogChoice("Accept quest");
		node.add(new Edge(acceptChoice, nextNodeIfAccepted));
		var nextNodeIfRejected = get(MyNodeLabels.doNotTakeQuest.toString());
		var rejectChoice = new DialogChoice("Reject quest");
		node.add(new Edge(rejectChoice, nextNodeIfRejected));
	}
	
	@BuilderMethod
	public void acceptedQuestEdge() {
		var node = get(MyNodeLabels.agreedToQuest.toString());
		var nextNode = get(MyNodeLabels.leaveGreatHall.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.ExitGreatHall.toString(), (IInteract) City, PlayerInteraction.Icons.exit, "Accept sword and leave Great Hall");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void enterCityEdge() {
		var node = get(MyNodeLabels.leaveGreatHall.toString());
		var nextNode = get(MyNodeLabels.enterCity.toString());
		var choice = new PlayerInteraction(player, MyChoiceLabels.EnterCity.toString(), (IInteract) City);
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void inCityEdges() {
		var node = get(MyNodeLabels.enterCity.toString());
		var nextNodeIfTavern = get(MyNodeLabels.enterTavern.toString());
		var enterTavernChoice = new PlayerInteraction(MyChoiceLabels.EnterTavern.toString(), (IInteract) Tavern, PlayerInteraction.Icons.exit, "Enter the Tavern");
		node.add(new Edge(enterTavernChoice, nextNodeIfTavern));
		var nextNodeIfBeggar = get(MyNodeLabels.talkWithBeggar.toString());
		var talkToBeggarChoice = new PlayerInteraction(MyChoiceLabels.TalkToBeggar.toString(), beggar, PlayerInteraction.Icons.talk, "Talk to a beggar");
		node.add(new Edge(talkToBeggarChoice, nextNodeIfBeggar));
	}
	
	@BuilderMethod
	public void beggarEdges() {
		var node = get(MyNodeLabels.talkWithBeggar.toString());
		var beggarConvoChoice = new DialogChoice("Indeed I am!");
		/*
		var nextNodeInConvo // need a node for the dialog with the beggar)
		node.add(new Edge(beggarConvoChoice, nextNodeInConvo));
		*/
	}
	@BuilderMethod
	public void inTavernEdges() {
		var node = get(MyNodeLabels.enterTavern.toString());
		var nextNodeIfBartender = get(MyChoiceLabels.TalkToBartender.toString());
		var talkToBartenderChoice = new PlayerInteraction(MyChoiceLabels.TalkToBartender.toString(), Bartender, PlayerInteraction.Icons.talk, "Talk to the bartender");
		node.add(new Edge(talkToBartenderChoice, nextNodeIfBartender));
	}
	
	

}

