package lesson7Dont;

public class Main {
    public static void main(String[] args) {
     testGraph();
//        testDfs();
  //      testBfs();
    }

   private static void testGraph() {

        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
       graph.addVertex("Воронеж");
       graph.addVertex("Питер");
       graph.addVertex("Владивосток");
       graph.addVertex("Минск");
       graph.addVertex("Пятигорск");
       graph.addVertex("Краснодар");
       graph.addVertex("Киев");
       graph.addVertex("Рига");
       graph.addVertex("Мухоранск");

        graph.addEdge("Москва", "Питер", 200);
       graph.addEdge("Питер", "Краснодар", 250);
       graph.addEdge("Краснодар", "Мухоранск", 600);
       graph.addEdge("Мухоранск", "Владивосток", 1500);


       graph.addEdge("Москва", "Минск", 600);
       graph.addEdge("Минск", "Владивосток", 8000);

       graph.addEdge("Москва", "Рига", 600);
       graph.addEdge("Рига", "Воронеж", 600);
       graph.addEdge("Воронеж", "Владивосток", 5600);


        graph.addEdge("Москва", "Пятигорск", 400);
       graph.addEdge("Пятигорск", "Киев", 5600);
       graph.addEdge("Киев", "Владивосток", 12500);


       System.out.println("Size of graph is " + graph.getSize());
        graph.display();

       graph.dfs("Москва");
    }





    /*private static void testDfs() {
        lesson7Dont.Graph graph = new lesson7Dont.GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testBfs() {
        lesson7Dont.Graph graph = new lesson7Dont.GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }*/
}
