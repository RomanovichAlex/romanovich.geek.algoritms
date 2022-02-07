package lesson6;

import java.util.ArrayList;
import java.util.Random;

public class TreeGen  {
    ArrayList<TreeImpl<Integer>> genArrayTrees;

    public TreeGen () {
        this.genArrayTrees = new ArrayList<>();
    }

    public void genTrees(int level, int trees, int min, int max) {
        if (min > max) { //небольшая защита от ошибок пользователя
            int temp = min;
            min = max;
            max = temp;
        }


        for (int i = 0; i < trees; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            Random random = new Random();
            for (int j = min; j <= max; j++) {
                int value;
                if (max >= 0 && min >= 0) {
                    value = random.nextInt((max - min + 1) + min);
                } else if (max < 0) {
                    value = (Math.abs(min) - random.nextInt(Math.abs(min) - Math.abs(max) + 1)) * -1;
                } else {
                    value = random.nextBoolean() ? random.nextInt(Math.abs(min)) * -1 - 1 : random.nextInt(Math.abs(max + 1));
                }
                addLevel(tree, value, level);
            }
            genArrayTrees.add(tree);
            tree.display();
        }
    }

    private void addLevel(TreeImpl<Integer> tree, Integer value, int deep) {
        if (tree.contains(value)) {
            return;
        }
        Node<Integer> node = new Node<>(value);
        int level = 0;
        if (tree.isEmpty()) {
            tree.root = node;
            tree.size++;
        } else {
            level = 1;
            Node<Integer> current = tree.root;
            Node<Integer> parent;
            for (; level < deep; level++) {
                parent = current;
                if (value.compareTo(current.getValue()) < 0) {
                    current = current.getLeftChild();

                    if (current == null) {
                        parent.setLeftChild(node);
                        tree.size++;
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        tree.size++;
                        return;
                    }
                }
            }
        }
    }

    public float balancedTrees() {
        float balanced = 0f;
        float disBalanced = 0f;

        for (TreeImpl<Integer> item : genArrayTrees) {
            if (item.balance()) {
                balanced++;
            } else {
                disBalanced++;
            }
        }
        float v = (disBalanced != 0) ? balanced / (balanced + disBalanced) * 100 : 100;
        System.out.println("% сбалансированных деревьев составляет: " + v);
        return v;
    }
}
