import java.util.ArrayList;
import java.util.List;


public class ValidMoves {
	
	
	
	Puzzle puzzle;
	public static int BLANK_POSITION;
	
	
	public ValidMoves(){
		
	}
	
	public ValidMoves(EightPuzzle puzzle){
		this.puzzle = puzzle;
		this.BLANK_POSITION = puzzle.getBlankPosition();
	}
	
	
	public ValidMoves(Puzzle_15 puzzle){
		this.puzzle = puzzle;
	}
	
	
	public int[] calculateNeighbours(int blank){
	//	int neighbours = 0;
		
		List<Integer> neighbours = new ArrayList<Integer>();
		if(blank > 2) neighbours.add(blank - 3);//array[neighbours++] = blank - 3;
		if(blank < 6) neighbours.add(blank + 3);//array[neighbours++] = blank + 3;
		if(blank % 3 != 0) neighbours.add(blank - 1);//array[neighbours++] = blank - 1;
		if(blank % 3 != 2) neighbours.add(blank + 1);//array[neighbours++] = blank + 1;
		
		return this.convertIntegers(neighbours);
//		int[] array = this.convertIntegers(neighbours);
//		return array;
	}
	
	
	public int[] getMoves(){
					// index positions top,right,bottom,left
		int[] moves = {0,0,0,0};
		
		switch(BLANK_POSITION){
		case 0:
			moves[1] = 1;
			moves[2] = 1;
			break;

		case 1:
			moves[1] = 1;
			moves[2] = 1;
			moves[3] = 1;
			break;

		case 2:
			moves[2] = 1;
			moves[3] = 1;
			break;

		case 3:
			moves[0] = 1;
			moves[1] = 1;
			moves[2] = 1;
			break;

		case 4:
			moves[0] = 1;
			moves[1] = 1;
			moves[2] = 1;
			moves[3] = 1;
			break;

		case 5:
			moves[0] = 1;
			moves[2] = 1;
			moves[3] = 1;
			break;

		case 6:
			moves[0] = 1;
			moves[1] = 1;
			break;

		case 7:
			moves[0] = 1;
			moves[1] = 1;
			moves[3] = 1;
			break;

		case 8:
			moves[0] = 1;
			moves[3] = 1;
			break;
		}
		
		return moves;
	}

	
	public static int[] convertIntegers(List<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
}
