import java.util.Random;


public class EightPuzzle extends Puzzle{

	private static int LEVEL;
	private static int N = 9;
	private int inversions;
	int[] problem ;//= new int[9];
	int[] goal= {0,1,2,3,4,5,6,7,8};
	EightPuzzle Parent = null;
	
//	int[] goal= new int[9];
//	Node<EightPuzzle> initial_state = new Node(this);
//	Node<EightPuzzle> Goal_state = new Node(this);
	int h,f,g;
	
	
	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public int getG() {
		return g;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	
	public void setF() {
		this.f = this.h + this.g;
	}
	
	public int getF() {
		return f;
	}
	
	/**
	 * DESC: Contr.
	 */

	public EightPuzzle(int[] values){
		this.setPuzzleValues(values);
	}
	
	
	/**
	 * DESC: Contr.
	 */
	public EightPuzzle(String start){
		this.generateProblem();
	//	this.setGoalState();
//		this.displayState(this);
		this.countInversions();
	//	System.out.println("Blank position  "+this.getBlankPosition());
		this.h = this.calcManhattanDistance(this.problem, this.goal);
		this.setG(0);
		this.setF();
		
//		System.out.println("H G F "+this.getH()+" "+this.getG()+" "+this.getF());
//		this.isSolvable();
	}

	
	/**
	 * DESC: Contr.
	 */
	public EightPuzzle(int[] values,EightPuzzle parent){
		this.problem = values;
		this.Parent = parent;
		this.h = this.calcManhattanDistance(this.problem, this.goal);
		this.setG(parent.getG() + 1);
		this.setF();
	}
	
	public void setPuzzleValues(int[] puzzleTiles){
		this.problem = puzzleTiles;
	}
	
	/**
	 * DESC: Generate any instance of 8-puzzle using random.
	 */
	public void generateProblem(){
		 //array to store N random integers (0 - N-1)
		problem = new int[N];

        // initialize each value at index i to the value i 
        for (int i = 0; i < problem.length; ++i)
        {
        	problem[i] = i;
        }

        Random randomGenerator = new Random();
        int randomIndex; // the randomly selected index each time through the loop
        int randomValue; // the value at nums[randomIndex] each time through the loop

        // randomize order of values
        for(int i = 0; i < problem.length; ++i)
        {
             // select a random index
             randomIndex = randomGenerator.nextInt(problem.length);

             // swap values
             randomValue = problem[randomIndex];
             problem[randomIndex] = problem[i];
             problem[i] = randomValue;
        }
	}
	
	/**
	 * 
	 * @return  LEVEL OF PUZZLE 
	 * 		    0 EASY
	 * 			1 MEDIUM
	 * 			2 HARD 
	 * 			3 UNSOLVABLE
	 */
	public int checkLevel(){
		// logic to check level of game
		if(isSolvable()){
			this.LEVEL = 0;
		}else{
			this.LEVEL = 3;
		}
		return LEVEL;
	}
	
	public boolean isSolvable(){
		if(inversions%2 == 0){
			return true;			
		}else{
			return false;			
		}
	}

	public void countInversions(){
		for(int i=0;i<=problem.length;i++){
			for(int j =i+1;j<problem.length;j++){
				if(problem[i]>problem[j]){
					inversions++;
				}
			}
		}
	}
	
	public int getInversions() {
		return this.inversions;
	}
		
//	public void setGoalState(){
//		for(int i = 0; i < 9; i++){
//			this.goal[i] = i;
//		}
//	}
//	
	
	public int[] getStateValues(){
		return this.problem;
	}
	
	
	public EightPuzzle getParent(){
		return 	this.Parent;
	}
	
	public int getBlankPosition(){
		int blank = -1;
		for (int i=0;i<this.problem.length;i++){
			if(this.problem[i] == 0){
				blank = i;
			}
		}
		return blank;
	}
	
//	public int getBlankPosition(){
//		int BLANK_INDEX = -1;
//		for(int i = 0 ; i<problem.length;i++){
//			if(problem[i] == 0){
//				BLANK_INDEX = i;
//			}
//		}
//		return BLANK_INDEX;
//	}
	
	public void getMove(int blankPosition){
		
	}
	
	public boolean isValidMove(){
		return true;
	}
	
	
	public boolean isGoal(){
		//this.problem.length;
		boolean result = false;
		for(int i = 0; i < this.problem.length; i++){
			if(this.problem[i] == i){
				result = true;
			}else{
				result = false;
			}
		}
		return result;
	}
	
	public void generateSuccessor(EightPuzzle puzzle){
		int blankPosition = puzzle.getBlankPosition();
	}
	
	
	public int calcManhattanDistance(int[] ps, int[] goal) {
//	    int rowSz = calculatePuzzleRowSize(ps);
		int rowSz = 3;
	    int manhattanDistanceSum = 0;
	    for (int i = 0; i < ps.length; i++) {
	        for (int j = 0; j < ps.length; j++) {
	            if (ps[i] == goal[j])
	                manhattanDistanceSum += (Math.abs(i/rowSz - j/rowSz) + Math.abs(i%rowSz - j%rowSz)); 
	        }
	    }
	    return manhattanDistanceSum;
	}
	
	// do toString for this ..
	// display array
	public void displayState(EightPuzzle puzzle){
		int rowSz = 3;
		for(int i = 0; i < rowSz; i++){
			for(int j = 0; j < rowSz; j++){
				System.out.print(puzzle.problem[i * rowSz + j]+" ");
			}
			System.out.println();
		}
	}

	
	public String printBoard(){
		int rowSz = 3;
		String arrayString = " ";
		for(int i = 0; i < rowSz; i++){
			for(int j = 0; j < rowSz; j++){
				System.out.print(this.problem[i * rowSz + j]+" ");
				arrayString += this.problem[i * rowSz + j];
			}
			arrayString += " \n";
			//System.out.println();
		}
		return arrayString;
	}
	
	public String arrayPrint(){
	//	this.problem
		String arrayString = "";
		for(int i = 0; i< this.problem.length;i++){
			arrayString += " "+this.problem[i]; 
		}
		return arrayString;
	}
	
	
	@Override
	public String toString() {
		this.displayState(this);
		return "VALUES: ["+this.arrayPrint()+" ]"+" BLANK : "+this.getBlankPosition()+" H : "+this.getH()+" G :"+this.getG()+" F: "+this.getF()+"\n";
	//	return "VALUES: [ "+this.printBoard()+" ]"+" BLANK : "+this.getBlankPosition()+" H : "+this.getH()+" G :"+this.getG()+" F: "+this.getF();
		//		return super.toString();
	}

	public void toPrint(){
		System.out.println(this.toString());
	}
	
	public static void print(EightPuzzle e){
		System.out.println(e.toString());
	}
	public void addParent(EightPuzzle e){
		this.Parent = e;
	}

}
