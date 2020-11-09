package grizzlyPunk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Game {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			boolean loop = true;//creates main loop
			//Scanner scanner = new Scanner(System.in);
			boolean combat = true;
			
			
			
				
			IntroMenu.main(args);
			
			//Map.createMap();
			
			//PrintStream oldOut = System.out;
			
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
