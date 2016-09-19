package com.yc.bean3_datatype3.tree.BinarySearchTree;

/**
 * 二叉排序树
 *
 *void insert( x)
 *void remove( x)
 *Comparable  find( x)
 *Comparable findMin()
 *Comparable findMax()
 *boolean isEmpty()
 *void makeEmpty()
 *void printTree()
 */
public class BinarySearchTree {
	private BinaryNode root;
	
	public BinarySearchTree(){
		this.root=null;
	}
	
	/**
	 * 判断是否为空树
	 */
	public boolean isEmpty(){
		return root==null;
	}
	
	/**
	 * 将树置空
	 */
	public void makeEmpty(){
		root=null;
	}
	
	/**
	 * 查找树中的最大值
	 * @return
	 */
	public Comparable findMax(){
		BinaryNode maxNode=findMax( root  );
		return maxNode.element;
	}
	/**
	 * 用于递归查找子树下最大值的方法.  最大值所在的节点的特点: 这个节点是没有右节点的
	 * @param t:要查找的子树
	 * @return:最大值所在的节点
	 */
	private BinaryNode findMax(  BinaryNode t  ){
		if(t!=null){
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	
	/**
	 * 查找树中的最小值
	 * @return
	 */
	public Comparable findMin(){
		BinaryNode minNode=findMin( root  );
		return minNode.element;
	}
	/**
	 * 用于递归查找子树下最小值的方法.  最小值所在的节点的特点: 这个节点是没有左节点的
	 * @param t:要查找的子树
	 * @return:最小值所在的节点
	 */
	private BinaryNode findMin(  BinaryNode t  ){
		if(t!=null){
			while(t.left!=null){
				t=t.left;
			}
		}
		return t;
	}
	
	
	/**
	 * 查找元素在树中的节点的元素
	 */
	public Comparable  find(  Comparable element  ){
		BinaryNode node=find(    element, root);
		return node==null?null:node.element;
	}
	private BinaryNode find(  Comparable element, BinaryNode t  ){
		if( t==null){
			return null;
		}
		if(   element.compareTo(t.element)<0  ){
			return find( element, t.left );   //如果element比当前的t节点的element值小，则查左子树
		}else if( element.compareTo(t.element)>0){
			return find( element,t.right);
		}else{
			return t;
		}
	}
	
	/**
	 * 添加操作: 1.查找要添加的位置     2. 添加进去
	 */
	public void insert( Comparable element){
		root=insert( element,root);
	}
	//对树而言是不能重复.  
	private BinaryNode insert(Comparable element, BinaryNode root) {
		// 若二叉树为空。则首先单独生成根结点。
		if( root==null ){
			root=new BinaryNode( element, null, null);
		}else if(  element.compareTo(root.element)<0  ){    //不是空树，则看是要添加到左子树还是右子树
			BinaryNode newNode=insert( element,root.left);
			root.left=newNode;
		}else if(  element.compareTo(root.element)>0){
			BinaryNode newNode=insert( element,root.right);
			root.right=newNode;
		}
		return root;
	}
	
	/**
	 * 删除操作:   1. 找位置
	 */
	public void remove( Comparable element){
		root=remove( element, root);
	}

	private BinaryNode remove(Comparable element, BinaryNode root) {
		if( root==null){
			return root;
		}
		if(   element.compareTo(root.element)<0){
			BinaryNode newNode=remove( element, root.left);
			root.left=newNode;
		}else if( element.compareTo(root.element)>0){
			BinaryNode newNode=remove( element,root.right);
			root.right=newNode;
		}else if(   root.left!=null&& root.right!=null    ){     //root是当前要删除的节点,且左子树与右子树都不为空
			//从右子树中查找最小的值
			root.element=(findMin(   root.right )).element;
			root.right=remove(  root.element, root.right );
		}else{
			root=root.left!=null?root.left:root.right;
		}
		return root;
	}
	
	public void printTree(){
		printTree( this.root );
	}
	
	/**
	 * 输出打印
	 */
	private void printTree(   BinaryNode root    ){
		if(root!=null){
			printTree( root.left );
			System.out.println(  root.element );
			printTree( root.right);
		}
	}
	
	
	public static void main(String[] args){
		BinarySearchTree root=new BinarySearchTree();
		root.insert(3);
		root.insert(4);
		root.insert(10);
		
		root.insert(15);
		root.insert(15);
		
		root.insert(1);
		
		root.insert(7);
		root.insert(11);
		root.insert(12);
		root.insert(14);
		root.insert(9);
	
		root.insert(6);
	
	
		root.printTree();
		
		root.remove(12);
		root.printTree();
		
	}
	
	
	
	
	
}
