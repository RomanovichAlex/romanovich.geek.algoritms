package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Москва");//0
        graph.addVertex("Краснодар");//1
        graph.addVertex("Питер");//2
        graph.addVertex("Пятигорск");//3
        graph.addVertex("Саратов");//4
        graph.addVertex("Воронеж");//5
        graph.addVertex("Липецк");//6
        graph.addVertex("Томбов");//7
        graph.addVertex("Тула");//8
        graph.addVertex("Владивосток");//9

        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 4, 56);
        graph.addEdge(4, 6, 62);
        graph.addEdge(0, 2, 54);
        graph.addEdge(2, 4, 31);
        graph.addEdge(2, 3, 23);
        graph.addEdge(0, 3, 74);
        graph.addEdge(3, 5, 33);
        graph.addEdge(5, 6, 44);
        graph.addEdge(6, 5, 54);
        graph.addEdge(8, 6, 44);
        graph.addEdge(6, 8, 24);
        graph.addEdge(7, 9, 154);
        graph.addEdge(8, 9, 133);
        graph.addEdge(8, 7, 94);
        graph.addEdge(7, 9, 244);

        System.out.println("Элементы имеют кратчайшие пути из Москвы: ");
        graph.path();
        graph.clean();
    }
}