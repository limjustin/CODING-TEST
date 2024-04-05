package leetcode.graph;

import java.util.*;

class Solution_332 {
    private List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(fromToMap, "JFK");
        
        return result;
    }

    public void dfs(Map<String, PriorityQueue<String>> fromToMap, String from) {
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(fromToMap, fromToMap.get(from).poll());
        }
        result.add(0, from);
    }
}