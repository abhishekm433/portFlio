import java.util.ArrayList;

public class bst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node delNode(Node root, int val) {
        if (root.data > val) {
            root.left = delNode(root.left, val);
        } else if (root.data < val) {
            root.right = delNode(root.right, val);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node Is = IndoserSuc(root.right);
            root.data = Is.data;
            root.right = delNode(root.right, Is.data);

        }
        return root;
    }

    public static Node IndoserSuc(Node root) {
        while (root.left != null) {
            root = root.left;

        }
        return root;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;

    }

    public static void inoder(Node root) {
        if (root == null) {
            return;
        }
        inoder(root.left);
        System.out.print(root.data + ", ");
        inoder(root.right);
    }

    public static boolean binarysearch(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return binarysearch(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return binarysearch(root.right, key);
        }

    }

    public static void printInrange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printInrange(root.left, x, y);
            System.out.print(root.data + " ");
            printInrange(root.right, x, y);

        }

        if (root.data >= y) {
            printInrange(root.left, x, y);
        } else {
            printInrange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path)
    {
        for(int i=0;i<path.size()-1;i++)
        {
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void printr2f(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printr2f(root.left, path);
            printr2f(root.right, path);
        }
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        int data[] = { 1, 3, 5, 4, 6, 2, 7 };
        Node root = null;
        for (int datae : data) {
            root = insert(root, datae);
        }
        inoder(root);
        System.out.println();

        System.out.println(binarysearch(root, 2));

        delNode(root, 2);
        inoder(root);
        System.out.println();

        printInrange(root, 0, 6);
        ArrayList<Integer> ls=new ArrayList<>();


        System.out.println();
        printr2f(root, ls);
    }
}