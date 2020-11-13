package grizzlyPunk;
import java.util.*;

public class Puzzles {
	private String puzzleID;
	private String puzzleName;
	private String description;
	private String answer;
	//Answer choices placed in an arraylist
	private ArrayList<String> choices = new ArrayList<>();
	private boolean isSolved;
	
	//Constructor
	public Puzzles(String puzzleID, String puzzleName, String description, String answer, ArrayList<String> choices,
			boolean isSolved) {
		super();
		this.puzzleID = puzzleID;
		this.puzzleName = puzzleName;
		this.description = description;
		this.answer = answer;
		this.choices = choices;
		this.isSolved = isSolved;
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
	
	public boolean isSolved() {
		return isSolved;
	}


	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public String getPuzzleName() {
		return puzzleName;
	}

	public void setPuzzleName(String puzzleName) {
		this.puzzleName = puzzleName;
	}

	//toString
	@Override
	public String toString() {
		return "Puzzles [puzzleID=" + puzzleID + ", puzzleName=" + puzzleName + ", description=" + description
				+ ", answer=" + answer + ", choices=" + choices + ", isSolved=" + isSolved + "]";
	}


	//win reward
	public void puzzleWin() {
		//set isSolved to true
		setSolved(true);
	}
}
