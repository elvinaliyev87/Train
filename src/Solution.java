
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	 public static Map<Town, Node> _route = new HashMap<Town, Node>();
	 

    public static int findDistance(ArrayList<Town>towns)  {

        if (towns.size()<2){
          return 0;
        }

        int distance = 0;
        int depth = 0;
        int index = 0;

        while (index < towns.size()-1){
             if(_route.containsKey(towns.get(index))) {
                    Node route = _route.get(towns.get(index));
                    while(route != null) {
                        if(route.destination.equals(towns.get(index + 1))) {
                            distance += route.weight;
                            depth++;
                            break;
                        }
                        route = route.next;
                    }
                }
                else
                    return -1;
                index++;
            }

            if(depth != towns.size() - 1){
               return -1;//NO SUCH ROUTE
            }
          return distance;
      }

      public static int numberOfTripsWithMaximumStop(Town from, Town destination, int max){
        return findRoutes(from, destination, 0,max)-1;
      }

      private static int findRoutes(Town from, Town dest, int depth, int max) {
            int routes = 0;
            if(_route.containsKey(from) && _route.containsKey(dest)) {
                if(depth == max){ return 0;}
                depth++;
                from.setVisited(true);

                Node node = _route.get(from);
                while(node != null) {
                    if(node.destination.equals(dest)) {
                        routes++;
                        node = node.next;
                        continue;
                    }
                    else if(!node.destination.getVisited()) {
                        depth--;
                        routes += findRoutes(node.destination, dest, depth, max);

                    }
                    node = node.next;
                }
            }
            else{
            return 0;//NO SUCH ROUTE
            }

            from.setVisited(false);
            return routes;
        }

      public static int lengthOfShortestRoute(Town from, Town destination){
        return findLengthShortestRoute(from, destination, 0, 0);
      }

      public static int findLengthShortestRoute(Town from, Town dest, int distance, int shortestPath){
        if(_route.containsKey(from) && _route.containsKey(dest)) {
                from.setVisited(true);
                Node node = _route.get(from);
                while(node != null) {
                    if(node.destination == dest || !node.destination.getVisited()){
                      distance += node.weight;
                    }

                    if(node.destination.equals(dest)) {
                        if(shortestPath == 0 || distance < shortestPath)
                            shortestPath = distance;
                        from.setVisited(false);
                        return shortestPath;
                    }
                    else if(!node.destination.getVisited()) {
                        shortestPath = findLengthShortestRoute(node.destination, dest, distance, shortestPath);
                        distance -= node.weight;
                    }
                    node = node.next;
                }
            }
            else{
              return -1;//NO SUCH ROUTE
            }

            from.setVisited(false);
            return shortestPath;
      }

      public static int numberOfDifferentRoutes(Town from, Town dest, int maxDistance) {
            return findAllRoutesBetweenTowns(from, dest, 0, maxDistance);
        }

        private static int findAllRoutesBetweenTowns(Town from, Town destination, int weight, int maxDistance){
            int routes = 0;
            if(_route.containsKey(from) && _route.containsKey(destination)) {

                Node node = _route.get(from);
                while(node != null) {
                    weight += node.weight;
                    if(weight <= maxDistance) {
                        if(node.destination.equals(destination)) {
                            routes++;
                            routes += findAllRoutesBetweenTowns(node.destination, destination, weight, maxDistance);
                            node = node.next;
                            continue;
                        }
                        else {
                            routes += findAllRoutesBetweenTowns(node.destination, destination, weight, maxDistance);
                            weight -= node.weight;
                        }
                    }
                    else
                        weight -= node.weight;

                    node = node.next;
                }
            }
            else{
               return -1;//NO SUCH ROUTE

              }
            return routes;

        }


   
      

    
    
}
