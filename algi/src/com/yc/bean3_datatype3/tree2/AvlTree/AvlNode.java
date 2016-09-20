package com.yc.bean3_datatype3.tree2.AvlTree;

import com.yc.bean3_datatype3.tree1.BinarySearchTree.*;

public class AvlNode  {
	public int height; // 高度

	public Comparable element;   //元素 
	public AvlNode left;   //左节点
	public AvlNode right;  //右节点
	
	 AvlNode( Comparable theElement )
     {
         this( theElement, null, null );
     }

     AvlNode( Comparable theElement, AvlNode lt, AvlNode rt )
     {
         element  = theElement;
         left     = lt;
         right    = rt;
         height   = 0;
     }
     
	@Override
	public String toString() {
		return "AvlNode [element=" + element + ", left=" + left + ", right="
				+ right + ",height="+height+"]";
	}

}
