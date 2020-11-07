package adventure;

public class Puzzle {
	private String puzzleID;
	private String question;
	private String answer;
	private String passMessage;
	private String failMessage;
	private int tries;
	private boolean solved;
	
	public Puzzle(String puzzleID, String question, String answer, String passMessage, String failMessage, int tries, boolean solved) {
		super();
		this.puzzleID = puzzleID;
		this.question = question;
		this.answer = answer;
		this.passMessage = passMessage;
		this.failMessage = failMessage;
		this.tries = tries;
		this.solved = solved;
	}

	
	public Puzzle() {
		super();
	}


	public String getPuzzleID() {
		return puzzleID;
	}
	public void setId(String puzzleID) {
		this.puzzleID = puzzleID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassMessage() {
		return passMessage;
	}
	public void setPassMessage(String passMessage) {
		this.passMessage = passMessage;
	}
	public String getFailMessage() {
		return failMessage;
	}
	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

 
	
	
	
//	public void solvePuzzle()
//	{
//		//"if" puzzle solved or not
//		if() //puzzle solved within attempts
//		{
//			//the puzzle disappears
//		}
//		else
//		{
//			//needs failure message = puzzle remains
//		}
//		
//	}
	
	
	
	
	
	
	
}
