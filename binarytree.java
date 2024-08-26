import java.util.LinkedList;
import java.util.Queue;

public class binarytree {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class TreeBuilder {
        static int index = -1;

        public static Node buildTree(int[] nodes) {
            index++;
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + "");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }

        }
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int x = countNode(root.left);
        int y = countNode(root.right);
        return x + y + 1;

    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static int sumOfNodes(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int x=sumOfNodes(root.left);
        int y=sumOfNodes(root.right);
        return x+y+root.data;
    }
    public static int heigthNode(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int heightleft=heigthNode(root.left);
        int heightr=heigthNode(root.right);
        int max=Math.max(heightleft,heightr)+1;
        return max;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, -1, -1, 4, 5, -1, 6, -1, 7, 8, 9 };
        TreeBuilder treeBuilder = new TreeBuilder();
        Node root = treeBuilder.buildTree(nodes);

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order:");
        levelOrder(root);

        System.out.println("COunt the Node Order:");
        System.out.println(countNode(root));



        System.out.println("Sum of Node:");
        System.out.println(sumOfNodes   (root));

        System.out.println("Height of Node:");
        System.out.println(heigthNode(root));
    }
}
