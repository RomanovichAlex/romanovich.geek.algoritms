package lesson7Dont;

import java.util.Objects;

public class Vertex {

    //вершина
    private final String name;
    //поле для обхода
    private boolean isVisited;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(String name) {
        this.name = name;
        this.isVisited = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "lesson7Dont.Vertex{" + "name='" + name + '\'' + '}';
    }


    //помогает сравнивать два узла по вершине
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
