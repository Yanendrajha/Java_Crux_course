public class Graph_Client {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");


        graph.addEdge("A","B",2);
        graph.addEdge("A","D",10);
        graph.addEdge("B","C",3);
        graph.addEdge("C","D",1);
        graph.addEdge("D","E",8);
        graph.addEdge("E","F",5);
        graph.addEdge("E","G",6);
        graph.addEdge("F","G",4);

//        graph.display();
//        System.out.println(graph.numVertex());
//        System.out.println(graph.numEdges());
//
//        System.out.println(graph.containsEdge("B","C"));
//        System.out.println(graph.containsEdge("A","C"));
//
//
//        graph.removeEdge("A","B");
//        graph.display();
//
//        graph.removeVertex("F");
//        graph.display();
//        graph.removeEdge("D","E");
//        System.out.println(graph.hasPath("A", "F", new HashMap<>()));
//        graph.display();
// graph.bft();
//        System.out.println(graph.isConnected());
//        System.out.println(graph.isCyclic());
//        System.out.println(graph.isTree());

//        graph.removeEdge("E","D");
//        graph.addVertex("H ");
//        System.out.println(graph.getConnectedComponents());
        //graph.prims().display();
        System.out.println(graph.dijkstra("A"));
    }
}
