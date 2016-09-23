package com.yc.bean3_datatype3.tree2.AvlTree;

import com.yc.bean3_datatype3.tree1.BinarySearchTree.BinaryNode;
import com.yc.bean3_datatype3.tree1.BinarySearchTree.BinarySearchTree;

/**
 * 平衡二叉树: 平衡二叉树要求对于每一个节点来说，它的左右子树的高度之差不能超过1，如果插入或者删除一个节点使得高度之差大于1，就要进行节点之间的旋转，
 * 将二叉树重新维持在一个平衡状态。<br />
 *
 * 平衡二叉树实现的大部分过程和二叉查找树是一样的（学平衡二叉树之前一定要会二叉查找树），区别就在于插入和删除之后要写一个旋转算法去维持平衡，
 * 维持平衡需要借助一个节点高度的属性。<br />
 * 
 * 
 * public int height() :
 * 旋转算法需要借助于一个功能的辅助，求树的高度。这里规定，一棵空树的高度为-1，只有一个根节点的树的高度为0，以后每多一层高度加1 <br />
 * private int height(AvlNode root) ： <br />
 * 
 * private int max(int lhs, int rhs): //求出两个值中的大值 <br />
 * 
 * <br />
 * ***********************************平衡树中的旋转情况******************************
 * <br />
 * private AvlNode leftLeftRotation(AvlNode k2): // 单旋转： 左左旋转的情况<br />
 * private AvlNode rightRightRotation(AvlNode k1): 单旋转：右右旋转的情况<br />
 * private AvlNode leftRightRotation(AvlNode k3) ： 左右对应的情况(左双旋转) <br />
 * private AvlNode rightLeftRotation(AvlNode k1) 右左对应的情况(右双旋转)<br />
 * 
 * <br />
 * *********************************重写了父类的remove和insert方法以实现AvlTree树在添加时要旋转树的功能*
 * **********************<br />
 * public void insert(Comparable element): 添加元素到AvlTree中 <br />
 * private AvlNode insert(Comparable x, AvlNode t) <br />
 * public void remove(Comparable x) : 从AvlTree中删除元素x<br />
 * private AvlNode remove(AvlNode root, Comparable x)
 */
public class AvlTree extends BinarySearchTree {

	

	/**
	 * 旋转算法需要借助于一个功能的辅助，求树的高度。这里规定，一棵空树的高度为-1，只有一个根节点的树的高度为0，以后每多一层高度加1<br />
	 * 
	 * @return
	 */
	public int height() {
		return height((AvlNode) root);
	}

	private int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * 输出最大值
	 */
	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	/**
	 * 单旋转： 左左旋转的情况
	 */
	private AvlNode leftLeftRotation(AvlNode k2) {
		AvlNode k1 = (AvlNode) k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height((AvlNode) k2.left), height((AvlNode) k2.right)) + 1;
		k1.height = max(height((AvlNode) k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * 单旋转：右右旋转的情况
	 */
	private AvlNode rightRightRotation(AvlNode k1) {
		AvlNode k2 = (AvlNode) k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height((AvlNode) k1.left), height((AvlNode) k1.right)) + 1;
		k2.height = max(height((AvlNode) k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * 左右对应的情况(左双旋转)
	 */
	private AvlNode leftRightRotation(AvlNode k3) {
		k3.left = rightRightRotation((AvlNode) k3.left);
		return leftLeftRotation(k3);
	}

	/**
	 * 右左对应的情况(右双旋转)
	 */
	private AvlNode rightLeftRotation(AvlNode k1) {
		k1.right = leftLeftRotation((AvlNode) k1.right);
		return rightRightRotation(k1);
	}

	public void insert(Comparable element) {
		root=insert(element, (AvlNode) root);
	}

	/**
	 * @param x
	 *            要插入的节点
	 * @param t
	 *            树的根节点
	 * @return 新的根节点
	 */
	private AvlNode insert(Comparable x, AvlNode t) {
		if (t == null)
			t = new AvlNode(x, null, null);
		else if (x.compareTo(t.element) < 0) { // x的值小于 t.element,则放到左树中.
			t.left = insert(x, (AvlNode) t.left); // 递归插入到左树中
			// 左右枝节点高度差为2
			if (height((AvlNode) t.left) - height((AvlNode) t.right) == 2)
				if (x.compareTo(t.left.element) < 0)
					t = leftLeftRotation(t);
				else
					t = leftRightRotation(t);
		} else if (x.compareTo(t.element) > 0) { // x的值大于 t.element,则放到右树中.
			t.right = insert(x, (AvlNode) t.right); // 递归插入右树.
			// TODO:
			if (height((AvlNode) t.right) - height((AvlNode) t.left) == 2)
				if (x.compareTo(t.right.element) > 0)
					t = rightRightRotation(t);
				else
					t = rightLeftRotation(t);
		} else
			; // 插入的节点与t的element相同，则忽略.
		// 新节点的高度为左右树的最高高度+1
		t.height = max(height((AvlNode) t.left), height((AvlNode) t.right)) + 1;
		return t;
	}

	/**
	 * 删除 <br />
	 * 
	 * @param c:
	 *            要删除的元素
	 */
	public void remove(Comparable x) {
		AvlNode n = null;
		if ((n = (AvlNode) super.find(x,root)) != null) {
			root = remove((AvlNode) root, n);
		}
	}

	private AvlNode remove(AvlNode tree, AvlNode z) {
		// 根为空 或者 没有要删除的节点，直接返回null。
		if (tree == null || z == null)
			return null;

		int cmp = z.element.compareTo(tree.element);
		if (cmp < 0) { // 待删除的节点在"tree的左子树"中
			tree.left = remove((AvlNode) tree.left, z);
			// 删除节点后，若AVL树失去平衡，则进行相应的调节。
			if (height((AvlNode) tree.right) - height((AvlNode) tree.left) == 2) {
				AvlNode r = (AvlNode) tree.right;
				if (height((AvlNode) r.left) > height((AvlNode) r.right))
					tree = rightLeftRotation(tree);
				else
					tree = rightRightRotation(tree);
			}
		} else if (cmp > 0) { // 待删除的节点在"tree的右子树"中
			tree.right = remove((AvlNode) tree.right, z);
			// 删除节点后，若AVL树失去平衡，则进行相应的调节。
			if (height((AvlNode) tree.left) - height((AvlNode) tree.right) == 2) {
				AvlNode l = (AvlNode) tree.left;
				if (height((AvlNode) l.right) > height((AvlNode) l.left))
					tree = leftRightRotation(tree);
				else
					tree = leftLeftRotation(tree);
			}
		} else { // tree是对应要删除的节点。
			// tree的左右孩子都非空
			if ((tree.left != null) && (tree.right != null)) {
				if (height((AvlNode) tree.left) > height((AvlNode) tree.right)) {
					// 如果tree的左子树比右子树高；
					// 则(01)找出tree的左子树中的最大节点
					// (02)将该最大节点的值赋值给tree。
					// (03)删除该最大节点。
					// 这类似于用"tree的左子树中最大节点"做"tree"的替身；
					// 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
					AvlNode max = (AvlNode) findMax(tree.left);
					tree.element = max.element;
					tree.left = remove((AvlNode) tree.left, max);
				} else {
					// 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
					// 则(01)找出tree的右子树中的最小节点
					// (02)将该最小节点的值赋值给tree。
					// (03)删除该最小节点。
					// 这类似于用"tree的右子树中最小节点"做"tree"的替身；
					// 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
					AvlNode min = (AvlNode) findMax(tree.right);
					tree.element = min.element;
					tree.right = remove((AvlNode) tree.right, min);
				}
			} else {
				AvlNode tmp = tree;
				tree = (AvlNode) ((tree.left != null) ? tree.left : tree.right);
				tmp = null;
			}
		}

		return tree;
	}

	private static int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };

	public static void main(String[] args) {

		int i;
		AvlTree tree = new AvlTree();

		System.out.printf("== 依次添加: ");
		for (i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
			tree.insert(arr[i]);
		}

		System.out.printf("\n== 前序遍历: ");
		tree.printTreePreOrder();

		System.out.printf("\n== 中序遍历: ");
		tree.printTreeInOrder();

		System.out.printf("\n== 后序遍历: ");
		tree.printTreePostOrder();
		System.out.printf("\n");

		System.out.printf("== 高度: %d\n", tree.height());
		System.out.printf("== 最小值: %d\n", tree.findMin());
		System.out.printf("== 最大值: %d\n", tree.findMax());
		System.out.printf("== 树的详细信息: \n");
		tree.print();
		
		System.out.println("\n删除树节点   11:");
		tree.remove(11);
		System.out.printf("\n== 前序遍历: ");
		tree.printTreePreOrder();

		System.out.printf("\n== 中序遍历: ");
		tree.printTreeInOrder();

		System.out.printf("\n== 后序遍历: ");
		tree.printTreePostOrder();
		System.out.printf("\n");

		System.out.printf("== 高度: %d\n", tree.height());
		System.out.printf("== 最小值: %d\n", tree.findMin());
		System.out.printf("== 最大值: %d\n", tree.findMax());
		System.out.printf("== 树的详细信息: \n");
		tree.print();

	}
}
