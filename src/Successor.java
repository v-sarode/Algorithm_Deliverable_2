import java.util.LinkedList;


public class Successor {

	public EightPuzzle[] generateSuccessors(EightPuzzle puzzle){
		ValidMoves v = new ValidMoves(puzzle);
	//	int[] moves = v.getMoves();
		int blank = getBlank(puzzle.getStateValues(),0);
		int[] neighbours = v.calculateNeighbours(blank);
		int numberOfSuccessors = neighbours.length;
	
		int[] puzzleValues = puzzle.getStateValues(); 
		
		
	//	System.out.println("BLANK POSITION "+blank);
		
		int[] tempArray = new int[puzzleValues.length];
		
		EightPuzzle[] children = new EightPuzzle[numberOfSuccessors];
		
		for(int i = 0; i<neighbours.length;i++ ){

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//			System.out.println();
			System.out.println("BLANK POSITION : "+blank+" NEIGHBOUT POSITION  :"+neighbours[i]+" INDEX OF N ARRAY "+ i);
//			System.out.println();
//			tempArray = swapElement(puzzleValues, blank, neighbours[i]);
			tempArray = null;
			tempArray = swapElement(puzzleValues, blank, neighbours[i]);
	//		tempArray = swapElement(puzzle.getStateValues(), blank, i);
			children[i] = new EightPuzzle(tempArray, puzzle);
		//	System.out.println("--------------------");
		//	children[i].displayState(children[i]);
			children[i].toPrint();
			tempArray = null;
			
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~			
		}
		return children;
	}
	
	
	public static LinkedList<EightPuzzle> generateSuccessorsList(EightPuzzle puzzle){
		
		LinkedList<EightPuzzle> children = new LinkedList<EightPuzzle>();
		
		ValidMoves v = new ValidMoves(puzzle);
	//	int[] moves = v.getMoves();
		int blank = getBlank(puzzle.getStateValues(),0);
		int[] neighbours = v.calculateNeighbours(blank);
		int numberOfSuccessors = neighbours.length;
	
		int[] puzzleValues = puzzle.getStateValues(); 
		
		
	//	System.out.println("BLANK POSITION "+blank);
		
		int[] tempArray = new int[puzzleValues.length];
		
//		EightPuzzle[] children = new EightPuzzle[numberOfSuccessors];
		
		for(int i = 0; i<neighbours.length;i++ ){

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//			System.out.println();
			System.out.println("BLANK POSITION : "+blank+" NEIGHBOUT POSITION  :"+neighbours[i]+" INDEX OF N ARRAY "+ i);
//			System.out.println();
//			tempArray = swapElement(puzzleValues, blank, neighbours[i]);
			tempArray = null;
			tempArray = swapElement(puzzleValues, blank, neighbours[i]);

			children.add(new EightPuzzle(tempArray, puzzle));
			
//			children[i] = new EightPuzzle(tempArray, puzzle);
		//	System.out.println("--------------------");
		//	children[i].displayState(children[i]);
//			children[i].toPrint();
			tempArray = null;
			
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~			
		}
		return children;
	}

	
	public static int[] swapElement(int[] values,int blank,int position){
//		int[] puzzleTiles = values;
		int[] puzzleTiles = null; 
		puzzleTiles = values.clone();
		
		int temp;
		
		temp = puzzleTiles[blank];
		puzzleTiles[blank] = puzzleTiles[position];
		puzzleTiles[position] = temp;
		
//		System.out.println(
//		puzzleTiles[0]+" "+puzzleTiles[1]+" "+puzzleTiles[2]+"\n");;
//		System.out.println(
//		puzzleTiles[3]+" "+puzzleTiles[4]+" "+puzzleTiles[5]+"\n");;
//		System.out.println(
//		puzzleTiles[6]+" "+puzzleTiles[7]+" "+puzzleTiles[8]+"\n");;
		
		return puzzleTiles;
	}
	
	public static int getBlank(int[] array,int key){
//		int blank = -1;
		for(int i = 0; i<array.length;i++){
			if(array[i] == key){
				return i;
 			}
		}
		return -1;
		//return blank;
	}
}
