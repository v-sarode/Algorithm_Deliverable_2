import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
/*

public class newAstar {
	   public static void astar(EightPuzzle start, EightPuzzle goal)
       {
               if(start.getInversions() % 2 == 1)
               {
                       System.out.println("Unsolvable");
                       return;
               }
//             function A*(start,goal)
//          closedset := the empty set                 // The set of nodes already evaluated. 
               LinkedList<EightPuzzle> closedset = new LinkedList<EightPuzzle>();
//          openset := set containing the initial node // The set of tentative nodes to be evaluated. priority queue
               PriorityQueue<EightPuzzle> openset = new PriorityQueue<EightPuzzle>();

               openset.add(start);
               
//          came_from := the empty map                 // The map of navigated nodes.
//          g_score[start] := 0                        // Distance from start along optimal path.
//          h_score[start] := heuristic_estimate_of_distance(start, goal)
//          f_score[start] := h_score[start]           // Estimated total distance from start to goal through y.
//          while openset is not empty
               while(openset.size() > 0){
//              x := the node in openset having the lowest f_score[] value
                       EightPuzzle x = openset.peek();

//              if x = goal
                       if(x.mapEquals(goal))
                       {
//                  return reconstruct_path(came_from, came_from[goal])
                                Stack<EightPuzzle> toDisplay = reconstruct(x);
                                System.out.println("Printing solution... ");
                                System.out.println(start.toString());
                                print(toDisplay);
                                return;
                                
                       }
//              remove x from openset
//              add x to closedset
                       closedset.add(openset.poll());
                       LinkedList <EightPuzzle> neighbor = x.getChildren();
//              foreach y in neighbor_nodes(x)                 
                       while(neighbor.size() > 0)
                       {
                               EightPuzzle y = neighbor.removeFirst();
//                             if y in closedset
                               if(closedset.contains(y)){
//                      continue
                                       continue;
                               }
//                  tentative_g_score := g_score[x] + dist_between(x,y)
//      
//                  if y not in openset
                               if(!closedset.contains(y)){
//                      add y to openset
                                       openset.add(y);
//                      tentative_is_better := true
                               }
//                  elseif tentative_g_score < g_score[y]
//                      tentative_is_better := true
                       }
//                  else
//                      tentative_is_better := false
//                  if tentative_is_better = true
//                      came_from[y] := x
//                      g_score[y] := tentative_g_score
//                      h_score[y] := heuristic_estimate_of_distance(y, goal)
//                      f_score[y] := g_score[y] + h_score[y]
               }
       }
}
*/