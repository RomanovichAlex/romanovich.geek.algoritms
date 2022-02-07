package lesson6;


public class Test {
    public static void main(String[] args) {

        TreeGen treeGen = new TreeGen();
        treeGen.genTrees(4,20,-25,25);
        treeGen.balancedTrees();
    }
}