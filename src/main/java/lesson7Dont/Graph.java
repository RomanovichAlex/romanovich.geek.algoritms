package lesson7Dont;

public interface Graph {



    //добовляем вершину
    void addVertex(String name);

    //добовляем ребро
    int addEdge(String startLabel, String secondLabel, int val);


    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

}
