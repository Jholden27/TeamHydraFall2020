package grizzlyPunk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			boolean loop = true;//creates main loop
			//Scanner scanner = new Scanner(System.in);
			boolean combat = true;
			
			
			
			//LOADS UP MENU GUI
			IntroMenu.main(args);
			//LOADS DATA FROM TEXT FILES
			Map.createMap();
			//SETS INITIAL STATS
			Player.maxHP = 100;
			Player.currentHP = 100;
			Player.sp = 0;
			Player.ap = 0;

			
<<<<<<< HEAD
			//Create map
			Map map = new Map();
			map.createMap();
			
			//Create player: player starts out in room R1 with empty inventory
			ArrayList<Item> inventory = new ArrayList<>();
			Player player = new Player(map.getRoom("R1"), 100, 100, 0, 0, 0, inventory, map, map.getRoom("R1"));
			
			//PrintStream oldOut = System.out;
			
=======
			//SETS GUI AS CONSOLE
>>>>>>> f78f2ccbb265c7c9ee37be8f9b58b9491fbd619b
			PrintStream oldOut = System.out;
			PrintStream printStream = new PrintStream(new OutputStream()
					{

						@Override
						public void write(int b) throws IOException {
							GUI.console.append(String.valueOf((char)b));
							GUI.console.setCaretPosition(GUI.console.getDocument().getLength());
							
						}
				
					});
			System.setOut(printStream);
			
			//NEW GAME STORY TEXT
			System.out.println("Zap! A portal opens below you as you see the ground quickly approaching. You land with a thud in a pile of rocks and rusted metal.");
			System.out.println("Out of the corner of your eye you see someone wearing a dingy, tattered bear costume walking towards you.");
			System.out.println();
			System.out.println("oh. Wasnt expecting to see you again! ");
			System.out.println();
			System.out.println("After a brief conversation, the 'Bear' realizes you've lost your memories. ");
			System.out.println("You should just take this as a sign to start over, theres not much left in these ruins for you to find.");
			System.out.println("Insisting you recover your memories, the 'Bear' shrugs and goes back to scavenging through a burned out car.");
			System.out.println();
			System.out.println("Its getting dark as you hear howling not far off, better start looking! ");
				
				
				
				
				
				
				
				System.out.println();
				
			
				
			}
			
			

	}
