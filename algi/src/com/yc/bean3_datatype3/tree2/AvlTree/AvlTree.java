package com.yc.bean3_datatype3.tree2.AvlTree;

import com.yc.bean3_datatype3.tree1.BinarySearchTree.BinarySearchTree;

/**
 * 平衡二叉树: 平衡二叉树要求对于每一个节点来说，它的左右子树的高度之差不能超过1，如果插入或者删除一个节点使得高度之差大于1，就要进行节点之间的旋转，将二叉树重新维持在一个平衡状态。
 *
 * 平衡二叉树实现的大部分过程和二叉查找树是一样的（学平衡二叉树之前一定要会二叉查找树），区别就在于插入和删除之后要写一个旋转算法去维持平衡，维持平衡需要借助一个节点高度的属性。

 * Comparable find( x) 
 * Comparable findMin()
 * Comparable findMax() 
 * boolean isEmpty() 
 * void makeEmpty() 
 * 
 *  * void insert( x) 
 * void remove( x) 
 * 
 * void printTree()
 * 
 * static int height(AvlNode t)  ： 旋转算法需要借助于一个功能的辅助，求树的高度。这里规定，一棵空树的高度为-1，只有一个根节点的树的高度为0，以后每多一层高度加1
 * 
 * 
 */
public class AvlTree {
	private AvlNode root;

	public AvlTree() {
		root = null;
	}

	public void insert(Comparable x) {
		root = insert(x, root);
	}
	/**
	 * @param x
	 *           要插入的节点
	 * @param t
	 *            树的根节点
	 * @return 新的根节点
	 */
	private AvlNode insert(Comparable x, AvlNode t) {
		if (t == null)
			t = new AvlNode(x, null, null);
		else if (x.compareTo(t.element) < 0) {   //x的值小于 t.element,则放到左树中. 
			t.left = insert(x, t.left);    //递归插入到左树中
			//左右枝节点高度差为2
			if (height(t.left) - height(t.right) == 2)
				if (x.compareTo(t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x.compareTo(t.element) > 0) {   //x的值大于  t.element,则放到右树中. 
			t.right = insert(x, t.right);          //递归插入右树. 
			//TODO:
			if (height(t.right) - height(t.left) == 2)
				if (x.compareTo(t.right.element) > 0)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // 插入的节点与t的element相同，则忽略.
		//新节点的高度为左右树的最高高度+1
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	/**
	 * 删除还没有实现.
	 * @param x
	 */
	public void remove(Comparable x) {
		System.out.println("Sorry, remove unimplemented");
	}

	/**
	 * 查找最小节点中存的元素.
	 * @return 
	 */
	public Comparable findMin() {
		return elementAt(findMin(root));
	}
	
	/**
	 * @param t
	 * @return 最小值的节点
	 */
	private AvlNode findMin(AvlNode t) {
		if (t == null)
			return t;
		while (t.left != null)
			t = t.left;
		return t;
	}

	/**
	 * 查找最大值元素
	 */
	public Comparable findMax() {
		return elementAt(findMax(root));
	}
	
	/**
	 * @param t
	 * @return 
	 */
	private AvlNode findMax(AvlNode t) {
		if (t == null)
			return t;
		while (t.right != null)
			t = t.right;
		return t;
	}

	/**
	 * 在树中查找某个元素
	 * @param x
	 * @return 
	 */
	public Comparable find(Comparable x) {
		return elementAt(find(x, root));
	}
	
	/**
	 * @param x
	 * @param t
	 * @return 
	 */
	private AvlNode find(Comparable x, AvlNode t) {
		while (t != null)
			if (x.compareTo(t.element) < 0)
				t = t.left;
			else if (x.compareTo(t.element) > 0)
				t = t.right;
			else
				return t; // Match

		return null; // No match
	}

	/**
	 * 将根节点置null
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * 判断根节点是否为空.
	 * @return 
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 显示树
	 */
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	/**
	 * @param t
	 */
	private void printTree(AvlNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	/**
	 * @param t
	 * @return 显示节点中的元素值
	 */
	private Comparable elementAt(AvlNode t) {
		return t == null ? null : t.element;
	}
	

	/**
	 * 返回树节点的高度
	 */
	private static int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * 输出最大值
	 */
	private static int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	/**
	 * 单旋转： 左左旋转的情况
	 */
	private static AvlNode rotateWithLeftChild(AvlNode k2) {
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * 单旋转：右右旋转的情况
	 */
	private static AvlNode rotateWithRightChild(AvlNode k1) {
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child. For AVL trees, this is a double
	 * rotation for case 2. Update heights, then return new root.
	 */
	private static AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child. For AVL trees, this is a double
	 * rotation for case 3. Update heights, then return new root.
	 */
	private static AvlNode doubleWithRightChild(AvlNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	
	

	// Test program
	public static void main( String [ ] args )
    {
        AvlTree t = new AvlTree( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( new MyInteger( i ) );

        if( NUMS < 40 )
            t.printTree( );
        if( ((MyInteger)(t.findMin( ))).intValue( ) != 1 ||
            ((MyInteger)(t.findMax( ))).intValue( ) != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 1; i < NUMS; i++ )
             if( ((MyInteger)(t.find( new MyInteger( i ) ))).intValue( ) != i )
                 System.out.println( "Find error1!" );
}
