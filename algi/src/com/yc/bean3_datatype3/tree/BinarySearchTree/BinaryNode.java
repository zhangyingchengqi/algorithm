package com.yc.bean3_datatype3.tree.BinarySearchTree;

//二叉查找树的结点
//这个类非公有，是包权限，只能在本包中被调用
 class BinaryNode {
	//二叉查找树是排序的树，所以要求节点中的元素都是可以比较的。 
	Comparable element;    
	BinaryNode left;   //左节点
	BinaryNode right;  //右节点
	
	BinaryNode( Comparable element){
		this( element,null, null);
	}
	
	BinaryNode( Comparable element, BinaryNode left, BinaryNode right){
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
