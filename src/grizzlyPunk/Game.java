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
			
			
			
				//Map.createMap();
			GUI.main(args);
			
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
			System.out.println("This is the console");
			
				
			
			//Player.playerLoc = 1;
			
			
				System.out.println("Which direction do you want to go? (N,S,E,W)");
				//String input = scanner.nextLine();
				//char typedDigit = scanner.next().charAt(0);
				
				
				
				
				
				
				System.out.println();
				
			
				//scanner.close();
			}
			
			

	}
