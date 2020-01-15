package binaryT;

public class TBSTNode {
    int ele;
    TBSTNode left, right;
    boolean leftThread, rightThread;

    public TBSTNode(int ele) {
        this(ele, null, null, true, true);
    }

    public TBSTNode(boolean leftThread, boolean rightThread) {
        this.ele = Integer.MAX_VALUE;
        this.left = this;
        this.right = this;
        this.leftThread = leftThread;
        this.rightThread = rightThread;
    }

    public TBSTNode(int ele, TBSTNode left, TBSTNode right, boolean leftThread, boolean rightThread) {
        this.ele = ele;
        this.left = left;
        this.right = right;
        this.leftThread = leftThread;
        this.rightThread = rightThread;
    }
}
