package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(10);
        for (int i = 0; i < graph.getSize(); i++) {
            graph.addVertex(i);
        }

        graph.addAdjacency(0, 1);
        graph.addAdjacency(1, 2);
        graph.addAdjacency(2, 4);
        graph.addAdjacency(4, 9);

        graph.addAdjacency(0, 3);
        graph.addAdjacency(3, 6);
        graph.addAdjacency(6, 9);

        graph.addAdjacency(0, 5);
        graph.addAdjacency(5, 7);
        graph.addAdjacency(7, 8);
        graph.addAdjacency(8, 9);

        graph.depthTravers();
        graph.widthTravers(true, null);
        System.out.println(graph.getWay(graph.getVertex(7)));
    }
}
