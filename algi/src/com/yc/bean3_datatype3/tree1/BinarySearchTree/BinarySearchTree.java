package com.yc.bean3_datatype3.tree1.BinarySearchTree;

/**
 * 二叉排序树
 *<br />
 *public void insert( Comparable element )       //添加新节点到树中，注意，不能添加相同元素.<br /> 
 *private BinaryNode insert(Comparable element, BinaryNode root)<br />
 *public void remove( Comparable element)     //从树中删除指定元素. <br />
 *private BinaryNode remove(Comparable element, BinaryNode root)<br />

 *public boolean isEmpty()<br />
 *public void makeEmpty()<br />
 *
 *<br />*********************查询部分*********************<br />
 *public Comparable  find( x)      //递归实现查找树中 键值为 x的元素<br />
 *private BinaryNode find(  Comparable element, BinaryNode t  );<br />
 *public Comparable  iterativeFind( x)      //非递归实现查找树中 键值为 x的元素<br />
 *private BinaryNode iterativeFind(  Comparable element, BinaryNode t  );<br />
 *public Comparable findMin()   //查找树中最小值<br />
 *private BinaryNode findMin(  BinaryNode root  )<br />
 *public Comparable findMax()   //查找树中最大值<br />
 *private BinaryNode findMax(  BinaryNode root  )<br />
 *
 *<br />*********************输出部分*********************<br />
 *public void printTreePreOrder()         //前序遍历<br />
 *private void printTreePreOrder(   BinaryNode root    )<br />
 *public void printTreeInOrder()         //中序遍历<br />
 *private void printTreeInOrder(   BinaryNode root    )<br />
 *public void printTreePostOrder()         //后序遍历<br />
 *private void printTreePostOrder(   BinaryNode root    )<br />
 *
 *public void print();      //输出二叉树的层次结构<br />
 *private void print(BinaryNode root, Comparable element,int side);    <br /> 
 */
public class BinarySearchTree {
	protected BinaryNode root;
	
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
	protected BinaryNode findMax(  BinaryNode root  ){
		if(root!=null){
			while(root.right!=null){
				root=root.right;
			}
		}
		return root;
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
	 * 递归实现查找元素在树中的节点的元素
	 */
	public Comparable  find(  Comparable element  ){
		BinaryNode node=find(    element, root);
		return node==null?null:node.element;
	}
	protected BinaryNode find(  Comparable element, BinaryNode root  ){
		if( root==null){
			return null;
		}
		if(   element.compareTo(root.element)<0  ){
			return find( element, root.left );   //如果element比当前的t节点的element值小，则查左子树
		}else if( element.compareTo(root.element)>0){
			return find( element,root.right);
		}else{
			return root;
		}
	}
	/**
	 * 非递归实现查找元素在树中的节点的元素(效率更高)
	 */
	public Comparable  iterativeFind( Comparable element){
		BinaryNode node=iterativeFind( element, root);
		return node==null?null:node.element;
	}      
	 private BinaryNode iterativeFind(  Comparable element, BinaryNode root  ){
		 while(  root!=null ){
			 int cmp=element.compareTo(root.element);
			 if( cmp<0){
				 root=root.left;
			 }else if(cmp>0){
				 root=root.right;
			 }else{
				 return root;
			 }
		 }
		 return root;
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
	
	/**
	 * 先序遍历: 先访问根结点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树
	 */
	public void printTreePreOrder(){
		printTreePreOrder( this.root );
	}
	private void printTreePreOrder(   BinaryNode root    ){
		if(root!=null){
			System.out.print(  root.element+" " );
			printTreePreOrder( root.left );
			printTreePreOrder( root.right);
		}
	}
	
	/**
	 * 中序遍历树：首先遍历左子树，然后访问根结点，最后遍历右子树。在遍历左、右子树时，仍然先遍历左子树，再访问根结点，最后遍历右子树, 若二叉树为空则结束返回
	 */
	public void printTreeInOrder(){
		printTreeInOrder( this.root );
	}
	private void printTreeInOrder(   BinaryNode root    ){
		if(root!=null){
			printTreeInOrder( root.left );
			System.out.print(  root.element+" " );
			printTreeInOrder( root.right);
		}
	}
	
	/**
	 * 后序遍历: 先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点。若二叉树为空则结束返回
	 */
	public void printTreePostOrder(){
		printTreePostOrder( this.root );
	}
	private void printTreePostOrder(   BinaryNode root    ){
		if(root!=null){
			printTreePostOrder( root.left );
			printTreePostOrder( root.right);
			System.out.print(  root.element+" "  );
		}
	}
	
	/**
	 * 输出二叉树的层次结构
	 */
	public void print(){
		if( root!=null){
			print( root, root.element, 0);
		}
	}
	/**
	 * 
	 * @param root
	 * @param element
	 * @param side:   0表示该节点是根节点    -1表示它是它的父节点的左孩子,     1 表示它是它的父节点的右孩子
	 */
	private void print(BinaryNode root, Comparable element,int side){
		if( root!=null){
			if( side==0 ){
				System.out.println(   root.element+" 是根节点 \n");
			}else{
				System.out.println(  root.element+"是"+element+"的"+  (side==1?"右":"左")+"孩子" );
			}
			print( root.left,root.element,-1);
			print( root.right, root.element, 1);
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
	
	
		root.printTreePreOrder();
		System.out.println();
		root.printTreeInOrder();
		System.out.println();
		root.printTreePostOrder();
		System.out.println();
		
		root.print();
	}
	
	
	
	
	
}
