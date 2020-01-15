package binaryT;

public class ThreadedBinarySearchTree {
    private TBSTNode root;

    public ThreadedBinarySearchTree() {
        root = new TBSTNode(true, false);
    }

    public void clear() {
        root = new TBSTNode(true, false);
    }

    public void insert(int ele) {
        TBSTNode ptr = findNode(root, ele);

        if (ptr == null)
            return;

        if (ptr.ele < ele) {
            ptr.right = new TBSTNode(ele, ptr, ptr.right, true, true);
            ptr.rightThread = false;
        } else {
            ptr.left = new TBSTNode(ele, ptr.left, ptr, true, true);
            ptr.leftThread = false;
        }
    }

    private TBSTNode findNode(TBSTNode r, int ele) {
        if (r.ele < ele) {
            if (r.rightThread)
                return r;
            return findNode(r.right, ele);
        } else if (r.ele > ele) {
            if (r.leftThread)
                return r;
            return findNode(r.left, ele);
        } else
            return null;
    }

    public boolean search(int ele) {
        return findNode(root, ele) == null;
    }

    public void inOrder() {
        TBSTNode temp = root;
        for (; ; ) {
            temp = insucc(temp);
            if (temp == root)
                break;
            System.out.print(temp.ele + " ");
        }
    }

    private TBSTNode insucc(TBSTNode tree) {
        TBSTNode temp;
        temp = tree.right;
        if (!tree.rightThread)
            while (!temp.leftThread)
                temp = temp.left;
        return temp;
    }
}