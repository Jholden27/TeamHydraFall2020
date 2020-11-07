package grizzlyPunk;
import java.util.*;

public class Puzzles {
	private String puzzleID;
	private String description;
	private String answer;
	//Answer choices placed in an arraylist
	private ArrayList<String> choices = new ArrayList<>();
	
	//Constructor
	public Puzzles(String puzzleID, String description, String answer, ArrayList<String> choices) {
		this.puzzleID = puzzleID;
		this.description = description;
		this.answer = answer;
		this.choices = choices;
	}
	
	//Getters and Setters
	public String getPuzzleID() {
		return puzzleID;
	}

	public void setPuzzleID(String puzzleID) {
		this.puzzleID = puzzleID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	
	//toString
	@Override
	public String toString() {
		return "Puzzles [puzzleID=" + puzzleID + ", description=" + description + ", answer=" + answer + ", choices="
				+ choices + "]";
	}
}
