package myclassproject.mystorygraph;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;
import com.entities.IInteract;
import com.playerInput.*;
import com.playerInput.PlayerInteraction.*;


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
	// Keenan Gray (all edges)
	
	@BuilderMethod
	public void rootEdges() {
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.GreatHall.toString());
		root.add(new Edge(choice, nextNode));
	}
	

	@BuilderMethod
	public void inGreatHallEdges() {
		var node = get(MyNodeLabels.GreatHall.toString());
		var nextNode1 = get(MyNodeLabels.talkToKing.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToKing.toString(), King, PlayerInteraction.Icons.talk, "Talk to the questgiver");
		node.add(new Edge(choice1, nextNode1));
		
	}
	
	@BuilderMethod
	public void talkToKingEdges() {
		var node = get(MyNodeLabels.talkToKing.toString());
		var nextNodeIfAccepted = get(MyNodeLabels.agreedToQuest.toString());
		var acceptChoice = new DialogChoice("Yes!");
		node.add(new Edge(acceptChoice, nextNodeIfAccepted));
		var nextNodeIfRejected = get(MyNodeLabels.doNotTakeQuest.toString());
		var rejectChoice = new DialogChoice("No Thanks");
		node.add(new Edge(rejectChoice, nextNodeIfRejected));
	}
	
	@BuilderMethod
	public void rejectedQuestEdge() {
		// resets game
		var node = get(MyNodeLabels.doNotTakeQuest.toString());
		var resetChoice = new DialogChoice("Close");
		var nextNode = get(MyNodeLabels.GreatHall.toString());
		node.add(new Edge(resetChoice, nextNode));
	}
	@BuilderMethod
	public void acceptedQuestEdge() {
		var node = get(MyNodeLabels.agreedToQuest.toString());
		var nextNode = get(MyNodeLabels.acceptedSword.toString());
		var choice = new DialogChoice("Accept sword");
		node.add(new Edge(choice, nextNode));
		
	}
	@BuilderMethod
	public void acceptedSwordEdge() {
		var node = get(MyNodeLabels.acceptedSword.toString());
		var nextNode = get(MyNodeLabels.enterCity.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.EnterCity.toString(), Gate, PlayerInteraction.Icons.exit, "Leave the Castle");
		node.add(new Edge(choice, nextNode));
	}
	/*@BuilderMethod
	public void enterCityEdge() {
		var node = get(MyNodeLabels.leaveGreatHall.toString());
		var nextNode = get(MyNodeLabels.enterCity.toString());
		var choice = new PlayerInteraction(player, MyChoiceLabels.EnterCity.toString(), Gate);
		node.add(new Edge(choice, nextNode));
	}*/
	
	@BuilderMethod
	public void cityEdgeToTavern() {
	    var node = get(MyNodeLabels.enterCity.toString());
	    var nextNode = get(MyNodeLabels.enterTavern.toString());
	    var choice = new PlayerInteraction(MyChoiceLabels.EnterTavern.toString(), TavernEntrance, PlayerInteraction.Icons.exit, "Enter the Tavern");
	    node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void cityEdgeToBeggar() {
	    var node = get(MyNodeLabels.enterCity.toString());
	    var nextNode = get(MyNodeLabels.talkWithBeggar.toString());
	    var choice = new PlayerInteraction(MyChoiceLabels.TalkToBeggar.toString(), beggar, PlayerInteraction.Icons.talk, "Talk to a beggar");
	    node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void cityEdgeToMerchant() {
		var node = get(MyNodeLabels.enterCity.toString());
		var nextNode = get(MyNodeLabels.tradeMerchant.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToMerchant.toString(), Merchant, PlayerInteraction.Icons.talk, "Talk With the Merchant");
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void tradeMerchantEdges() {
	    var node = get(MyNodeLabels.tradeMerchant.toString());

	    var acceptTalkChoice = new DialogChoice("Yeah!");
	    var nextNodeTalk = get(MyNodeLabels.whatToOffer.toString());
	    node.add(new Edge(acceptTalkChoice, nextNodeTalk));

	    var declineTalkChoice = new DialogChoice("No thank you, not today");
	    var nextNodeDecline = get(MyNodeLabels.declineTrade.toString());
	    node.add(new Edge(declineTalkChoice, nextNodeDecline));
	}

	@BuilderMethod
	public void whatToOfferEdges() {
	    var node = get(MyNodeLabels.whatToOffer.toString());
	    
	    var acceptTradeChoice = new DialogChoice("sure");
	    var nextNodeAccept = get(MyNodeLabels.acceptTrade.toString());
	    node.add(new Edge(acceptTradeChoice, nextNodeAccept));
	    
	    var declineOfferChoice = new DialogChoice("No, Why would i give up my protection");
	    var nextNodeDecline = get(MyNodeLabels.declineTrade.toString());
	    node.add(new Edge(declineOfferChoice, nextNodeDecline));
	}
	




	@BuilderMethod
	public void cityEdgeToForestPath() {
	    var node = get(MyNodeLabels.enterCity.toString());
	    var nextNode = get(MyNodeLabels.enterForestPath.toString());
	    var choice = new PlayerInteraction(MyChoiceLabels.EnterForest.toString(), EastEnd, PlayerInteraction.Icons.exit, "Enter the Forest Path");
	    node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void cityEdgeToBridge() {
	    var node = get(MyNodeLabels.enterCity.toString());
	    var nextNode = get(MyNodeLabels.enterBridge.toString());
	    var choice = new PlayerInteraction(MyChoiceLabels.GoToBridge.toString(), WestEnd, PlayerInteraction.Icons.exit, "Go to the Bridge");
	    node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void cityEdgeReturnToCastle() {
	    var node = get(MyNodeLabels.enterCity.toString());
	    var nextNode = get(MyNodeLabels.talkWithKnight.toString());
	    var choice = new PlayerInteraction(MyChoiceLabels.ReturnToGreatHall.toString(), Gate, PlayerInteraction.Icons.exit, "Return to the Great Hall");
	    node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void beggarEdges() {
	    var node = get(MyNodeLabels.talkWithBeggar.toString());
	    var beggarClose = new DialogChoice("Close");
	    var nextNode = get(MyNodeLabels.closeBeggarDialog.toString());
	    node.add(new Edge(beggarClose, nextNode));
	}

	@BuilderMethod
	public void closeBeggarDialogEdges() {
	    var node = get(MyNodeLabels.closeBeggarDialog.toString());
	    var closeChoice = new DialogChoice("Close");
	    var nextNode = get(MyNodeLabels.enterCity.toString());
	    node.add(new Edge(closeChoice, nextNode));
	}

	@BuilderMethod
	public void inTavernEdges() {
		var node = get(MyNodeLabels.enterTavern.toString());
		var nextNodeIfBartender = get(MyNodeLabels.talkWithBartender.toString());
		var talkToBartenderChoice = new PlayerInteraction(MyChoiceLabels.TalkToBartender.toString(), Bartender, PlayerInteraction.Icons.talk, "Talk to the bartender");
		node.add(new Edge(talkToBartenderChoice, nextNodeIfBartender));
		var leaveTavernChoice = new PlayerInteraction(player, MyChoiceLabels.ExitTavern.toString(), TavernDoor);
		var nextNodeIfLeaving = get(MyNodeLabels.leaveTavern.toString());
		node.add(new Edge(leaveTavernChoice, nextNodeIfLeaving));
	}
	
	@BuilderMethod
	public void bartenderEdges() {
		var node = get(MyNodeLabels.talkWithBartender.toString());
		var choice1 = new DialogChoice("Why not?");
		var nextNode1 = get(MyNodeLabels.takeDrink.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new DialogChoice("No thanks");
		var nextNode2 = get(MyNodeLabels.inTavern.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	@BuilderMethod
	public void bartenderDialogEdges() {
	    var node = get(MyNodeLabels.talkWithBartender.toString());
	    var choice = new DialogChoice("Close");
	    var nextNode = get(MyNodeLabels.closeBartenderDialog.toString());
	    node.add(new Edge(choice, nextNode));
	}

	
	@BuilderMethod
	public void inForestEdges() {
		var node = get(MyNodeLabels.enterForestPath.toString());
		var nextNodeIfPriest = get(MyNodeLabels.talkWithPriest.toString());
		var talkToPriestChoice = new DialogChoice("Talk To Priest");
		node.add(new Edge(talkToPriestChoice, nextNodeIfPriest));
		var leaveForestChoice = new PlayerInteraction(player, MyChoiceLabels.ExitForest.toString(), EastEnd1);
		var nextNodeIfLeaving = get(MyNodeLabels.enterCity.toString());
		node.add(new Edge(leaveForestChoice, nextNodeIfLeaving));
		var enterRuinsChoice = new PlayerInteraction(player, MyChoiceLabels.EnterRuins.toString(), Exit);
		var nextNodeIfRuins = get(MyNodeLabels.atRuins.toString());
		node.add(new Edge(enterRuinsChoice, nextNodeIfRuins));
	}
	
	@BuilderMethod
	public void priestEdges() {
		var node = get(MyNodeLabels.talkWithPriest.toString());
		var giveSwordChoice = new DialogChoice("Yes");
		var nextNodeIfGive = get(MyNodeLabels.giveSwordToPriest.toString());
		node.add(new Edge(giveSwordChoice, nextNodeIfGive));
		var keepSwordChoice = new DialogChoice("No");
		var nextNodeIfKeep = get(MyNodeLabels.enterForestPath.toString());
		node.add(new Edge(keepSwordChoice, nextNodeIfKeep));
	}
	
	@BuilderMethod
	public void giveSwordEdges() {
		var node = get(MyNodeLabels.giveSwordToPriest.toString());
		var priestCloseChoice = new DialogChoice("Close");
		var nextNode = get(MyNodeLabels.enterForestPath.toString());
		node.add(new Edge(priestCloseChoice, nextNode));
	}
	
	@BuilderMethod
	public void inRuinsEdges() {
		var node = get(MyNodeLabels.enterRuins.toString());
		var leaveRuinsChoice = new PlayerInteraction(player, MyChoiceLabels.ExitRuins.toString(), Exit);
		var nextNodeIfLeave = get(MyNodeLabels.enterForestPath.toString());
		node.add(new Edge(leaveRuinsChoice, nextNodeIfLeave));
		var attackBanditChoice = new DialogChoice("Attack");
		var nextNodeIfAttack = get(MyNodeLabels.killBandit.toString());
		node.add(new Edge(attackBanditChoice, nextNodeIfAttack));
		var letBanditAttackChoice = new DialogChoice("Let Bandit Attack");
		var nextNodeIfLetAttack = get(MyNodeLabels.death.toString());
		node.add(new Edge(letBanditAttackChoice, nextNodeIfLetAttack));
	}
	
	@BuilderMethod
	public void killBanditEdges() {
		var node = get(MyNodeLabels.killBandit.toString());
		var takeKeyChoice = new DialogChoice("Pick up the Blue Key");
		var nextNode = get(MyNodeLabels.pickUpBlueKey.toString());
		node.add(new Edge(takeKeyChoice, nextNode));
	}
	
	@BuilderMethod
	public void takeBlueKeyEdges() {
		// TODO: do I need this? see comment below
		var node = get(MyNodeLabels.pickUpBlueKey.toString());
		var leaveRuinsChoice = new PlayerInteraction(player, MyChoiceLabels.ExitRuins.toString(), Exit);
		var nextNode = get(MyNodeLabels.enterForestPath.toString());
		node.add(new Edge(leaveRuinsChoice, nextNode));
	}

	@BuilderMethod
	public void deathEdges() {
		// TODO: do I need a separate edge for this like above?
		var node = get(MyNodeLabels.death.toString());
		var takeGiftChoice = new DialogChoice("Accept Gift");
		// how to actually take item? use com.actions.Take? should not be dialog option?
		var nextNode = get(MyNodeLabels.atRuins.toString());
		node.add(new Edge(takeGiftChoice, nextNode));
	}
	
	@BuilderMethod
	public void goToBridge() {
		var node = get(MyNodeLabels.enterBridge.toString());
		var talkToManChoice = new PlayerInteraction(MyChoiceLabels.TalkToMysteryMan.toString(), MysteryMan, PlayerInteraction.Icons.talk, "Talk to the mystery man");
		var nextNodeIfTalk = get(MyNodeLabels.atBridge.toString());
		node.add(new Edge(talkToManChoice, nextNodeIfTalk));
		var leaveBridgeChoice = new PlayerInteraction(player, MyChoiceLabels.EnterCity.toString(), SouthEnd);
		var nextNodeIfLeave = get(MyNodeLabels.enterCity.toString());
		node.add(new Edge(leaveBridgeChoice, nextNodeIfLeave));
	}
	
	@BuilderMethod
	public void atBridgeEdges() {
		var node = get(MyNodeLabels.atBridge.toString());
		var answerRiddleChoice = new DialogChoice("Yes");
		var nextNodeIfRiddle = get(MyNodeLabels.answerRiddle.toString());
		node.add(new Edge(answerRiddleChoice, nextNodeIfRiddle));
		var refuseRiddleChoice = new DialogChoice("No");
		var nextNodeIfRefuse = get(MyNodeLabels.enterBridge.toString());
		node.add(new Edge(refuseRiddleChoice, nextNodeIfRefuse));
	}
	
	@BuilderMethod
	public void answerRiddleEdges() {
		var node = get(MyNodeLabels.answerRiddle.toString());
		var answerRiddleChoice = new DialogChoice("A secret");
		var nextNode = get(MyNodeLabels.riddleAnswered.toString());
		node.add(new Edge(answerRiddleChoice, nextNode));
	}
	
	@BuilderMethod
	public void riddleAnsweredEdges() {
		var node = get(MyNodeLabels.riddleAnswered.toString());
		var takeAppleChoice = new DialogChoice("Thank you");
		var nextNode = get(MyNodeLabels.enterBridge.toString());
		node.add(new Edge(takeAppleChoice, nextNode));
	}
	
	//TODO: can't add port/merchant options because not sure how to get there
	
	@BuilderMethod
	public void talkToKnight() {
		var node = get(MyNodeLabels.talkWithKnight.toString());
		var finishQuestChoice = new DialogChoice("Yes");
		var nextNodeIfFinished = get(MyNodeLabels.questComplete.toString());
		node.add(new Edge(finishQuestChoice, nextNodeIfFinished));
		var unfinishedChoice = new DialogChoice("Not yet");
		var nextNodeIfUnfinished = get(MyNodeLabels.GreatHall.toString());
		node.add(new Edge(unfinishedChoice, nextNodeIfUnfinished));
	}
	
	@BuilderMethod
	public void talkToKingEndEdges() {
		var node = get(MyNodeLabels.returnToThrone.toString());
		var endChoice = new DialogChoice("The End");
		// start over?
		var nextNode = get(MyNodeLabels.root.toString());
		node.add(new Edge(endChoice, nextNode));
	}
}