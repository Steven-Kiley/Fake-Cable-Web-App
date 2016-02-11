package services;

import java.util.HashMap;

import PublicUtils.ServiceType;
import java.util.Date;

public class Services {
	//Generate the recurring services
	static RecurringService basic = new RecurringService("Basic-Package", "Basic plan that includes 50 channels.", 49.99, ServiceType.Cable);
	static RecurringService basicPlus = new RecurringService("Basic-Plus-Package", "Deluxe version of basic plan, that includes 50 additional channels.", 109.99, ServiceType.Cable);
	static RecurringService ultimate = new RecurringService("Ultimate-Package", "Our biggest package yet! Includes 200 channels!", 150.99, ServiceType.Cable);
	static RecurringService speedlane = new RecurringService("Speedlane-Internet", "Our base internet package. Offers a blazing 20/5Mbps!", 54.99, ServiceType.Internet);
	static RecurringService lightlane = new RecurringService("Lightlane-Internet", "No task is too much for Lightlane! An unreal 50/10Mbps connection!", 89.99, ServiceType.Internet);
	
	//Generate the games
	static SingleService game1 = new SingleService("Pac_Man's_Revenge", "Pac Man is back, and now death isn't enough to save those ghosts!",
							5.99, ServiceType.Game);
	static SingleService game2 = new SingleService("Call_of_Snooty", "Full spectrum yacht club action!",
			5.99, ServiceType.Game);
	static SingleService game3 = new SingleService("Hammer_Hands_the_Game", "Hammer Hands has exploded on the scene! Are you ready to nail it?",
			5.99, ServiceType.Game);
	static SingleService game4 = new SingleService("Puppy_Adventures", "Puppies!",
			5.99, ServiceType.Game);
	static SingleService game5 = new SingleService("Satan's_Legion", "Chainsaw those devils back to hell!",
			5.99, ServiceType.Game);
	static SingleService game6 = new SingleService("Care_Bear_Time", "Your parents will buy it for you, but they'll be the ones that end up playing it!",
			5.99, ServiceType.Game);
	static SingleService game7 = new SingleService("Bass_Master_2", "Now with 10 lakes, 6 ponds, and 2 oceans!",
			5.99, ServiceType.Game);
	static SingleService game8 = new SingleService("Anthony_Bourdain's_Grocery_Trip", "Can you get fresh ingredients before time is up?",
			5.99, ServiceType.Game);
	static SingleService game9 = new SingleService("Conquistador", "Conquer the new world! WARNING: May involve crimes against humanity.",
			5.99, ServiceType.Game);
	static SingleService game10 = new SingleService("Alice_in_Wonderland_7", "Alice takes on the Yakuza, but this time she brought a new friend!",
			5.99, ServiceType.Game);
	
	//Generate the movies
	static SingleService movie1 = new SingleService("The_Deer_Chaser", "Can Danny put his life back together after a Cuisinart accident kills his fiance?",
			2.99, ServiceType.PPVMovie);
	static SingleService movie2 = new SingleService("Grumpy_old_Dogs", "These dogs are old, wrinkled, and ornery...and they just might steal your heart.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie3 = new SingleService("The_Goblin", "Promiscuous teenagers awaken an ancient evil in an abandoned cabin. Will they be able to survive the Goblin?",
			2.99, ServiceType.PPVMovie);
	static SingleService movie4 = new SingleService("Grand_Eloquence", "Grace Brannigan has won a Nobel prize for literature, but something in her past won't let her enjoy the triumph.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie5 = new SingleService("Anthony_Bourdain's_Not_Allowed_on_TV", "The culinary globe trotting of Anthony Bourdain comes to big screen, and this time he can show it all.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie6 = new SingleService("Cats", "You will expect the acclaimed musical. Instead you will get 3 hours of home videos featuring domestic felines.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie7 = new SingleService("Orc", "Every year the humans, elves, and dwarves come, trying to wipe them out. Now one orc has had enough, and the fair races of Baldinoor better watch out!",
			2.99, ServiceType.PPVMovie);
	static SingleService movie8 = new SingleService("Shoes", "Every shoe manufactured since 1968, all in one movie.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie9 = new SingleService("Bus_Driver_3", "Shania takes a job driving the #22 bus, oblivious to the curse. Can she get her passengers there before they die...of old age?",
			2.99, ServiceType.PPVMovie);
	static SingleService movie10 = new SingleService("Pain", "Does it hurt when I do this?",
			2.99, ServiceType.PPVMovie);
	static SingleService movie11 = new SingleService("Soccer_Hooligans", "Jeremy has been a soccer hooligan his whole life. But when he meets his match in Vanessa, his heart is ready to riot!",
			2.99, ServiceType.PPVMovie);
	static SingleService movie12 = new SingleService("Master_of_Disaster 6: Tornado Alley", "Can Dynamic Dave master a tornado?",
			2.99, ServiceType.PPVMovie);
	static SingleService movie13 = new SingleService("The_Beer_Chaser", "When his last can of beer rolls away downhill, hockey fan Reginald Porter knows he doesn't have long to get it back before third period begins.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie14 = new SingleService("The_Pastel_Devil", "Mrs. Ayala suspects her neighbor, a famous artist, is making a terrible deal with dark forces.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie15 = new SingleService("Hammer_Hands", "Welder Gary Black loses his hands below the elbow when mob bosses put out a hit on him. Little do they know, they're the ones about to get nailed!",
			2.99, ServiceType.PPVMovie);
	static SingleService movie16 = new SingleService("Hallowed_Ground", "When the Wehrmacht shows up at his door, Father Braun must choose whether to give what they want to save his church or do what he believes is right.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie17 = new SingleService("Grower", "Jim and Pam are thrilled when their baby arrives. Things soon beccome difficult when it's found a disorder is causing their baby to grow at an extreme rate.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie18 = new SingleService("The_Explodinator 4", "When things get tough, they call the Explodinator. The dark forces of Shark Island will test his strength like never before.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie19 = new SingleService("Finding_Land", "Two sailors lost at sea search desperately for dry land.",
			2.99, ServiceType.PPVMovie);
	static SingleService movie20 = new SingleService("Grapes,_Grapes,_Grapes!", "Did you ever want to know about grapes?",
			2.99, ServiceType.PPVMovie);
	
		
	//Generate the sport PPVs
	static SingleService sport1 = new SingleService("Bruiser_VS_Xanthabe", "Brain Bruiser takes on Garb Xanthabe in the heavyweight championship event of the decade!", 
			15.99, ServiceType.PPVSport);
		
			
	static	SingleService sport2 = new SingleService("NBA_Finals_round_1", "Cleveland Cavaliers take on the Golden State Warriors for the championship. Round 1.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport3 = new SingleService("NBA_Finals_round_2", "Cleveland Cavaliers take on the Golden State Warriors for the championship. Round 2.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport4 = new SingleService("NBA_Finals_round_3", "Cleveland Cavaliers take on the Golden State Warriors for the championship. Round 3.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport5 = new SingleService("NBA_Finals_round_4", "Cleveland Cavaliers take on the Golden State Warriors for the championship. Round 4.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport6 = new SingleService("NHL_Finals_round_1", "Chicago Blackhawks take on the Tampa Bay Lightning for the championship. Round 1.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport7 = new SingleService("NHL_Finals_round_2", "Chicago Blackhawks take on the Tampa Bay Lightning for the championship. Round 2.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport8 = new SingleService("NHL_Finals_round_3", "Chicago Blackhawks take on the Tampa Bay Lightning for the championship. Round 3.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport9 = new SingleService("NHL_Finals_round_4", "Chicago Blackhawks take on the Tampa Bay Lightning for the championship. Round 4.", 
			15.99, ServiceType.PPVSport);
			
			
	static SingleService sport10 = new SingleService("Little_League_National_Championship", "Watch the best kids in baseball show their love of the game and their impressive skills.", 
			15.99, ServiceType.PPVSport);
			


public static HashMap<String, RecurringService> getRecurs(){
	HashMap<String, RecurringService> recurs = new HashMap<String, RecurringService>();
	recurs.put(basic.getName(), basic);
	recurs.put(basicPlus.getName(), basicPlus);
	recurs.put(ultimate.getName(), ultimate);
	recurs.put(speedlane.getName(), speedlane);
	recurs.put(lightlane.getName(), lightlane);
	return recurs;
}

public static HashMap<String, SingleService> getSingles(){
	HashMap<String, SingleService> singles = new HashMap<String, SingleService>();
	/**Generate the dates for Sport Events*/
		//Event 1 week from today (used)
		Date sevenDay = new Date(System.currentTimeMillis() + 7L * 24 * 3600 * 1000);
		Date sixDay = new Date(System.currentTimeMillis() + 6L * 24 * 3600 * 1000);
		
		//Event 1 day from today (used)
		Date oneDay = new Date(System.currentTimeMillis() + 1L * 24 * 3600 * 1000);
		Date now = new Date(System.currentTimeMillis());
		
		//Event 10 days hence (used)
		Date tenDay = new Date(System.currentTimeMillis() + 10L * 24 * 3600 * 1000);
		Date nineDay = new Date(System.currentTimeMillis() + 9L * 24 * 3600 * 1000);
		
		//Event 4 days hence (used)
		Date fourDay = new Date(System.currentTimeMillis() + 4L * 24 * 3600 * 1000);
		Date threeDay = new Date(System.currentTimeMillis() + 3L * 24 * 3600 * 1000);
		
		//Event 2 weeks hence  (used)
		Date fourteenDay = new Date(System.currentTimeMillis() + 14L * 24 * 3600 * 1000);
		Date thirteenDay = new Date(System.currentTimeMillis() + 13L * 24 * 3600 * 1000);
		
		//Event 12 days hence (used)
		Date twelveDay = new Date(System.currentTimeMillis() + 12L * 24 * 3600 * 1000);
		Date elevenDay = new Date(System.currentTimeMillis() + 11L * 24 * 3600 * 1000);
		
		//Event 16 days hence (used)
		Date sixteenDay = new Date(System.currentTimeMillis() + 16L * 24 * 3600 * 1000);
		Date fifteenDay = new Date(System.currentTimeMillis() + 15L * 24 * 3600 * 1000);
	
	//Put the dates into the sport events
	sport1.setDate(oneDay, now);
	sport2.setDate(fourDay, threeDay);
	sport3.setDate(sevenDay, sixDay);
	sport4.setDate(tenDay, nineDay);
	sport5.setDate(twelveDay, elevenDay);
	sport6.setDate(tenDay, nineDay);
	sport7.setDate(twelveDay, elevenDay);
	sport8.setDate(fourteenDay, thirteenDay);
	sport9.setDate(sixteenDay, fifteenDay);
	sport10.setDate(oneDay, now);
	
	//games
	singles.put(game1.getName(), game1);
	singles.put(game2.getName(), game2);
	singles.put(game3.getName(), game3);
	singles.put(game4.getName(), game4);
	singles.put(game5.getName(), game5);
	singles.put(game6.getName(), game6);
	singles.put(game7.getName(), game7);
	singles.put(game8.getName(), game8);
	singles.put(game9.getName(), game9);
	singles.put(game10.getName(), game10);
	
	//movies
	singles.put(movie1.getName(), movie1);
	singles.put(movie2.getName(), movie2);
	singles.put(movie3.getName(), movie3);
	singles.put(movie4.getName(), movie4);
	singles.put(movie5.getName(), movie5);
	singles.put(movie6.getName(), movie6);
	singles.put(movie7.getName(), movie7);
	singles.put(movie8.getName(), movie8);
	singles.put(movie9.getName(), movie9);
	singles.put(movie10.getName(), movie10);
	singles.put(movie11.getName(), movie11);
	singles.put(movie12.getName(), movie12);
	singles.put(movie13.getName(), movie13);
	singles.put(movie14.getName(), movie14);
	singles.put(movie15.getName(), movie15);
	singles.put(movie16.getName(), movie16);
	singles.put(movie17.getName(), movie17);
	singles.put(movie18.getName(), movie18);
	singles.put(movie19.getName(), movie19);
	singles.put(movie20.getName(), movie20);
	
	//sports
	singles.put(sport1.getName(), sport1);
	singles.put(sport2.getName(), sport2);
	singles.put(sport3.getName(), sport3);
	singles.put(sport4.getName(), sport4);
	singles.put(sport5.getName(), sport5);
	singles.put(sport6.getName(), sport6);
	singles.put(sport7.getName(), sport7);
	singles.put(sport8.getName(), sport8);
	singles.put(sport9.getName(), sport9);
	singles.put(sport10.getName(), sport10);
	
	return singles;
}





}
