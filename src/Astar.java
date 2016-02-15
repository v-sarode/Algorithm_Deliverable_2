import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Astar {
	
	EightPuzzle eightPuzzleProblem;
	Puzzle_15 fifteenPuzzleProblem;
	EightPuzzle firstNode = new  EightPuzzle("start");
	int[] goalArray = {0,1,2,3,4,5,6,7,8};
	EightPuzzle GoalNode = new  EightPuzzle(goalArray);
	
//	Node startState;
//	Node goalSate;
//	Node currentNode;
//	
//	List<Node> openlist = new ArrayList<Node>();
//	List<Node> closedlist = new ArrayList<Node>();
	
	
	public Astar(Puzzle puzzle){
		if (puzzle instanceof EightPuzzle) {
			 eightPuzzleProblem = (EightPuzzle) puzzle;
			 this.astar(eightPuzzleProblem);
		}
		
		if (puzzle instanceof Puzzle_15) {
			fifteenPuzzleProblem = (Puzzle_15) puzzle;
		}
		
	}
	

//	public void serach(){
//		
//		openlist.add(startState);	
//		while(!openlist.isEmpty()){
//			
//		}
//	}
	
//=============================
	public boolean isGoalState(){
		return true;
	}
//=============================
	
	
	  public static void astar(EightPuzzle start)//, EightPuzzle goal)
      {
              if(start.getInversions() % 2 == 1)
              {
                      System.out.println("Unsolvable");
                      return;
              }
              
              LinkedList<EightPuzzle> closedset = new LinkedList<EightPuzzle>();
              PriorityQueue<EightPuzzle> openset = new PriorityQueue<EightPuzzle>();
              //

              openset.add(start);
              
              while(openset.size() > 0){
                      EightPuzzle x = openset.peek();

                             if(x.isGoal())
                             {
                                      Stack<EightPuzzle> toDisplay = reconstruct(x);
                                      System.out.println("Printing solution... ");
                                      System.out.println(start.toString());
                             //         print(toDisplay);
                                      return;
                                      
                             }
                             closedset.add(openset.poll());
                             LinkedList <EightPuzzle> neighbor =  Successor.generateSuccessorsList(x);  //x.getChildren();
                             while(neighbor.size() > 0)
                             {
                                     EightPuzzle y = neighbor.removeFirst();
                                     if(closedset.contains(y)){
                                             continue;
                                     }
                                     if(!closedset.contains(y)){
                                             openset.add(y);
                                     }
                             }
                     }
       }
	  
	  
	    public static Stack<EightPuzzle> reconstruct(EightPuzzle winner)
        {
                Stack<EightPuzzle> correctOutput = new Stack<EightPuzzle>();
                
                while(winner.getParent() != null)
                {
                correctOutput.add(winner);
                winner = winner.getParent();
                }
                
//           if came_from[current_node] is set
//               p = reconstruct_path(came_from, came_from[current_node])
//               return (p + current_node)
//           else
//               return current_node
                return correctOutput;
        
        
        }
        
}
