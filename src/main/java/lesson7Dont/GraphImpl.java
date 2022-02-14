package lesson7Dont;

import java.util.*;

public class GraphImpl implements Graph {


    //список где храним все вершины
    private final List<Vertex> vertexList;
    //матрица смежности
    private int[][] adjMatrix;
    private int count=10000000;


    //макс количество вершин
    public GraphImpl(int maxVertexCount) {
        //вершины
        this.vertexList = new ArrayList<>(maxVertexCount);
        //матрица смежности
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];

    }

    //добавление новой вершины
    @Override
    public void addVertex(String name) {;
        vertexList.add(new Vertex(name));
    }

    //добавление связей между вершинами
    @Override
    public int addEdge(String startLabel, String secondLabel, int val) {
        //определяем требуемый индекс по названию вершины старт
        int startIndex = indexOf(startLabel);
        //следующий индекс
        int endIndex = indexOf(secondLabel);
        //есть ли у нас с чем работать
        if (startIndex == -1 || endIndex == -1) {
            //если нет нужных индексов то нет
            return 0;
        }
        //если есть задаем значение ребра (в дз указать значение 212)
        adjMatrix[startIndex][endIndex] = val; //!!!!!!!!!!!!
        return val;
    }

    //возращаем название вершины
    private int indexOf(String name) {
        //идем по всему списку
        for (int i = 0; i < vertexList.size(); i++) {
            //является ли искомый индекс нужным
            if (vertexList.get(i).getName().equals(name)) {
                //вернем нужный индекс
                return i;
            }
        }
        //либо -1 узла нет
        return -1;
    }


    @Override
    public int getSize() {
        return vertexList.size();
    }


    //обращаемся к методу то стринг
    @Override
    public void display() {
        System.out.println(this);
    }

    //
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            //берем первый узел и пробегаем по всем узлам
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                //если есть связь
                if (adjMatrix[i][j]!=0) {
                    //добавляем связь
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            //перенос строки на следующую
            sb.append("\n");
        }
        //возращаем стринг билдер матрицу
        return sb.toString();
    }


    //обход в глубину
    @Override
    public void dfs(String startLabel) {
        //определяем стартовый индекс
        int startIndex = indexOf(startLabel);
        //если такого индекса нет
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }
        //создаем стек для вершин
        Stack<Vertex> stack = new Stack<>();
        //будем хранить вершину а потом получать новые вершины
        Vertex vertex = vertexList.get(startIndex);
        //метод посещения вершин
        visitVertex(stack, vertex);

        //вершины что не посещали, пока стек не будет пуст
        while (!stack.isEmpty()) {
            //метод исчет ближайший непосещенный узел, вертекс ближайший непосещенный узел
            vertex = getNearUnvisitedVertex(stack.peek());
            //и спрашиваем нашли ли мы этот узел
            if (vertex != null) {
                //если да обазначаем его как посещенный
                visitVertex(stack, vertex);
            } else {
                //если больше непосещенных узлов не осталось выпиливаем верхний узел
                stack.pop();
            }
        }
        System.out.println();
    }

    //метод исчет ближайший непосещенный узел. очередь
    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        //найдем индекс в таблице смежности
        int currentIndex = vertexList.indexOf(vertex);
        //и побежали
        for (int i = 0; i < getSize(); i++) {
            //если в таблице смежности есть связь и узел еще не посещен
            if (adjMatrix[currentIndex][i]!=0 && !vertexList.get(i).isVisited() ) {
                //возращаем непосещенный узел
                return vertexList.get(i);
            }
        }
//если нет то нет
        return null;
    }

    //метод посещения вершин
    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getName() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }


    //для очереди
    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        //название
        System.out.print(vertex.getName() + " ");
        //добавление в стек
        stack.add(vertex);
        //затем устанавливае поле что уже были, вершину посетили
        vertex.setVisited(true);
    }

    //для очереди
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }
}
