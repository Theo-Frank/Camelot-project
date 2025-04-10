package myclassproject.mystorygraph;

import java.util.List;

import javax.sound.sampled.Port;

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
import com.actions.Sit;
import com.actions.Drink;
import com.actions.DisableInput;
import com.actions.CreateEffect;
import com.actions.*;
import com.sequences.*;
import com.sequences.DialogSequence;
import myclassproject.mystorygraph.*;
//Theo Frank
import static myclassproject.mystorygraph.MyStoryEntities.*;
import com.actions.Attack;
import com.actions.Give;


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
		.add(new CreateCharacterSequence(Priest))
		.add(new CreateCharacterSequence(MysteryMan))
		.add(new CreateCharacterSequence(Merchant))
		.add(new CreateCharacterSequence(Bandit))
		.add(new SetPosition(Bandit, Plant))
		.add(new SetPosition(Merchant, BigStall))
		.add(new SetPosition(Apple,MysteryMan))
		.add(new SetPosition(sword1,Bandit))
		.add(new SetPosition(Bandit, Plant))
		.add(new SetPosition(RedKey,Merchant))
		.add(new SetPosition(BlueKey,Bandit))
		.add(new SetPosition(Bag,Bandit))
		.add(new SetPosition(MysteryMan, SouthSign))
		.add(new SetPosition(Priest, Plant1))
		.add(new SetPosition(player, RightThrone))
		.add(new SetPosition(King, Throne))
		.add(new SetPosition(beggar,Fountain))
		.add(new SetPosition(Bartender, Barrel))
		.add(new SetPosition(Knight, RedHouseDoor))
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
		.add(new Exit(player, Gate, true));
		
	}//theo Frank
	@BuilderMethod
	public void enterCity() {
		var node = get(MyNodeLabels.enterCity.toString());
        node.add(new Enter(player, EastEnd, true))
		.add(new Exit(player, NorthEnd, true))
		.add(new Exit(player,WestEnd,true))
		.add(new Exit(player, BlueHouseDoor,true));
		
	}//Theo Frank
    @BuilderMethod
    public void enterTavern() {
        var node = get(MyNodeLabels.enterTavern.toString());
        node.add(new Enter(player, Door, true))
        .add(new Wave(Bartender))
        .add(new Face(player,Bartender))
        .add(new Exit(player, Door, true));
    }//Theo Frank
    @BuilderMethod
    public void talkWithBartender() {
        var node = get(MyNodeLabels.talkWithBartender.toString());
        node.add(new Face(player, Bartender))
            .add(new DialogSequence(Bartender, null,
                List.of("Would you like a drink to relax my young Hero?"),List.of("[No thanks|Leave]")));
        
    }//Theo Frank
    @BuilderMethod
    public void takeDrink() {
    	var node= get(MyNodeLabels.takeDrink.toString());
    	node.add(new DisableInput())
    	.add(new WalkTo(player, Chair))
    	.add(new Sit(player,Chair ))
    	.add(new Drink(player))
    	.add(new CreateEffect(player,Heart));
    }
    @BuilderMethod
    public void talkWithBeggar() {
        var node = get(MyNodeLabels.talkWithBeggar.toString());
        node.add(new DialogSequence(beggar, null,List.of("Hello my friend, I heard you are off on a quest. I hope you succeed and aid our kingdom."),List.of("[Close|Close]")));
    }//Theo Frank
    
    @BuilderMethod
    public void enterForestPath() {
        var node = get(MyNodeLabels.enterForestPath.toString());
        node.add(new Enter(player, EastEnd1, true));
    }
    @BuilderMethod
    public void exitForestPath() {
        var node = get(MyNodeLabels.exitForestPath.toString());
        node.add(new Exit(player, EastEnd1, true));
    }
    @BuilderMethod
    public void atForestPath() {
        var node = get(MyNodeLabels.atForestPath.toString());
        node.add(new EnableInput())
        .add(new Face(player, Priest))
        .add(new DialogSequence(player, null, 
                List.of("You see a priest standing quietly beside the path."),
                List.of("[would you like to|talkWithPriest]", "[Ignore|Continue on your way]")));
    }
    @BuilderMethod
    public void talkWithPriest() {
        var node = get(MyNodeLabels.talkWithPriest.toString());
        node.add(new HideDialog())
        .add(new DialogSequence(Priest, null, 
            List.of("Today is a holy day. There shall be no hurting others today. Would you like to relinquish your sword to me?"),
            List.of("[Yes|giveSwordToPriest]", "[No|I need my Sword today]")));
    }
    
    @BuilderMethod
    public void giveSwordToPriest() {
        var node = get(MyNodeLabels.giveSwordToPriest.toString());
        node.add(new Give(player, sword, Priest))
        .add(new CreateEffect(player,Aura))
            .add(new DialogSequence(Priest, null, 
                List.of("May peace be with you, brave one."),
                List.of("[Close|ShowMenu]")));
    }


    @BuilderMethod
    public void leaveToRuins() {
        var node = get(MyNodeLabels.leaveToRuins.toString());
        node.add(new Exit(player, WestEnd1, true));
       
    }
    @BuilderMethod
    public void enterRuins() {
        var node = get(MyNodeLabels.enterRuins.toString());
        node.add(new Enter(player, Exit, true));
    }
    @BuilderMethod
    public void leaveRuins() {
        var node = get(MyNodeLabels.leaveRuins.toString());
        node.add(new Exit(player, Exit, true));
    }
    @BuilderMethod
    public void returnToForestPathFromRuins() {
        var node = get(MyNodeLabels.returnToForestPathFromRuins.toString());
        node.add(new Enter(player, WestEnd1, true));
    }

    @BuilderMethod
    public void atRuins() {
        var node = get(MyNodeLabels.atRuins.toString());
        node.add(new Face(player, Bandit))
        .add(new DialogSequence(Bandit, null,
                List.of("Hello traveler. Do you have anything of value that I could take from you today?"),
                List.of("[Attack|attackBandit]", "[Let Bandit Attack|banditAttacksPlayer]")));
    }
    @BuilderMethod
    public void killBandit() {
        var node = get(MyNodeLabels.killBandit.toString());
        node.add(new Attack(player, Bandit, true))  
            .add(new Die(Bandit))
            .add(new DialogSequence(player, null,
                List.of("The bandit drops a Blue Key."),
                List.of("[Pick up the Blue Key|pickUpBlueKey]")));
    }
    @BuilderMethod
    public void pickUpBlueKey() {
        var node = get(MyNodeLabels.pickUpBlueKey.toString());
        node.add(new Take(player, BlueKey))
            .add(new ShowMenu());
    }
    @BuilderMethod
    public void banditAttacksPlayer() {
        var node = get(MyNodeLabels.banditAttacksPlayer.toString());
        node.add(new Attack(Bandit, player, true))
            .add(new Die(player))
            .add(new FadeOut());
    }
    @BuilderMethod
    public void death() {
    	var node = get(MyNodeLabels.death.toString());
    	node.add(new FadeIn())
        .add(new Revive(player))
        .add(new EnableEffect(player, Resurrection))
        .add(new DialogSequence(Bandit, null,
            List.of("Oh my god... what have I done? I need to fix my ways. Here, take everything I own."),
            List.of("[Accept Gift|takeRedKeyAndBag]")));

    }
    @BuilderMethod
    public void takeRedKeyAndBag() {
        var node = get(MyNodeLabels.takeRedKeyAndBag.toString());
        node.add(new Give(Bandit, RedKey, player))
            .add(new Give(Bandit, Bag, player))
            .add(new ShowMenu());
    }
    @BuilderMethod
    public void leaveCityToBridge() {
        var node = get(MyNodeLabels.leaveCityToBridge.toString());
        node.add(new Exit(player, WestEnd, true))
            .add(new Enter(player, NorthEnd1, true));
    }
    @BuilderMethod
    public void returnToCityFromBridge() {
        var node = get(MyNodeLabels.returnToCityFromBridge.toString());
        node.add(new Exit(player, NorthEnd1, true))
            .add(new Enter(player, WestEnd, true));
    }

    @BuilderMethod
    public void atBridge() {
        var node = get(MyNodeLabels.atBridge.toString());
        node.add(new Face(player, MysteryMan))
            .add(new DialogSequence(MysteryMan, null,
                List.of("Hello young traveler, would you like to answer a riddle for me today?"),
                List.of("[Yes|answerRiddle]", "[No|exitBridge]")));
    }
    @BuilderMethod
    public void exitBridge() {
        var node = get(MyNodeLabels.exitBridge.toString());
        node.add(new Exit(player, SouthEnd, true))
            .add(new Enter(player, Exit1, true));
    }
    @BuilderMethod
    public void answerRiddle() {
        var node = get(MyNodeLabels.answerRiddle.toString());
        node.add(new DialogSequence(MysteryMan, null,
            List.of("If you have me, you will want to share me. If you share me, you will no longer have me. What am I?"),
            List.of("[A secret|riddleAnswered]")));
    }
    @BuilderMethod
    public void riddleAnswered() {
        var node = get(MyNodeLabels.riddleAnswered.toString());
        node.add(new DialogSequence(MysteryMan, null,
            List.of("Thank you for answering this riddle, here is an apple for your journey."),
            List.of("[Thank you|ShowMenu]")))
            .add(new Give(MysteryMan, Apple, player));
    }
    @BuilderMethod
    public void atPort() {
        var node = get(MyNodeLabels.atPort.toString());
        node.add(new WalkTo(player, BigStall))
            .add(new Face(player, Merchant))
            .add(new DialogSequence(Merchant, null,
                List.of("Hello my young friend. Would you care to buy this key that I found?"),
                List.of("[Yes|buyKey]", "[No|merchantInsists]")));
    }
    @BuilderMethod
    public void merchantInsists() {
        var node = get(MyNodeLabels.merchantInsists.toString());
        node.add(new DialogSequence(Merchant, null,
            List.of("Are you sure you don't want to get this key?"),
            List.of("[Yes|ShowMenu]")));
    }
    @BuilderMethod
    public void buyKey() {
        var node = get(MyNodeLabels.buyKey.toString());
        node.add(new Give(Merchant, RedKey, player))
            .add(new ShowMenu());
    }
    @BuilderMethod
    public void leavePort() {
        var node = get(MyNodeLabels.leavePort.toString());
        node.add(new Exit(player, Exit1, true))
            .add(new Enter(player, SouthEnd, true));
    }
    @BuilderMethod
    public void talkWithKnight() {
        var node = get(MyNodeLabels.talkWithKnight.toString());
        node.add(new Face(player, Knight))
            .add(new DialogSequence(Knight, null,
                List.of("Have you completed your quest and found all the keys?"),
                List.of("[Yes|questComplete]", "[Not yet|ShowMenu]")));
    }
    @BuilderMethod
    public void questComplete() {
        var node = get(MyNodeLabels.questComplete.toString());
        node.add(new FadeOut());
    }
    @BuilderMethod
    public void returnToThrone() {
        var node = get(MyNodeLabels.returnToThrone.toString());
        node.add(new FadeIn())
            .add(new SetPosition(player, RightThrone))
            .add(new SetCameraFocus(player))
            .add(new Face(King, player))
            .add(new DialogSequence(King, null,
                List.of("Thank you, my young friend, for your heroic journey to retrieve the keys."),
                List.of("[The End|theEnd]")));
    }


}
