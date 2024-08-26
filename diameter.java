public class diameter {
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
    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int h1=height(root.left);
        int h2=height(root.right);
        int max=Math.max(h1,h2)+1;
        return max;
    }
    public static int diameter(Node root)
    {
        //0(n^2)
        if(root==null)
        {
            return 0;
        }

        int lefth=diameter(root.left);
        int right=diameter(root.right);
        int dia3=height(root.left)+height(root.right)+1;
        return Math.max(dia3, Math.max(right, lefth));
    }

    static class treeInfo
    {
        int ht;
        int dia;
        treeInfo(int ht,int dia)
        {
            this.dia=dia;
            this.ht=ht;
        }
    }
    public static treeInfo diamenter2(Node root)
    {
        if(root==null)
        {
            return new treeInfo(0, 0);
        }
        treeInfo left=diamenter2(root.left);
        treeInfo rght=diamenter2(root.right);

        int ht=Math.max(left.ht, rght.ht);


        int dia1=left.dia;
        int dia2=rght.dia;
        int dia3=dia1+dia2+1;

        int mydia=Math.max(dia1, Math.max(dia2, dia3));

        treeInfo ns=new treeInfo(ht, mydia);
        return ns;

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, -1, -1, 4, 5, -1, 6, -1, 7, 8, 9 };
        TreeBuilder treeBuilder = new TreeBuilder();
        Node root = treeBuilder.buildTree(nodes);
        System.out.println(height(root));
        System.out.println(diamenter2(root).dia);
        System.out.println(diameter(root));

    }
}
