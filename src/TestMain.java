import java.util.ArrayList;


public class TestMain {

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle("start");
		e.toPrint();
		
		Successor s = new Successor();
		
		EightPuzzle[] childrenNodes = s.generateSuccessors(e); 
		
		int count = 0;
		
//		for (EightPuzzle eightPuzzle : childrenNodes) {
//			System.out.println("Children : ---> "+ ++count);
//			eightPuzzle.toPrint();
//		}
//		
		System.out.println("==============");
		System.out.println("Goal state");
		
		int[] goalArray = {0,1,2,3,4,5,6,7,8};
		EightPuzzle GoalNode = new  EightPuzzle(goalArray);

		GoalNode.toPrint();
		
	}

}
