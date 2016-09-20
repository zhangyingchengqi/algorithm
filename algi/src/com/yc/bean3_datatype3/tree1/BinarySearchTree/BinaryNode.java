package com.yc.bean3_datatype3.tree1.BinarySearchTree;

//二叉查找树的结点
//这个类非公有，是包权限，只能在本包中被调用
 public class BinaryNode {
	//二叉查找树是排序的树，所以要求节点中的元素都是可以比较的。 
	public Comparable element;    
	public BinaryNode left;   //左节点
	public BinaryNode right;  //右节点
	
	public BinaryNode( Comparable element){
		this( element,null, null);
	}
	
	public BinaryNode( Comparable element, BinaryNode left, BinaryNode right){
		this.element=element;
		this.left=left;
		this.right=right;
	}

	@Override
	public String toString() {
		return "BinaryNode [element=" + element + ", left=" + left + ", right="
				+ right + "]";
	}
	
	
}
