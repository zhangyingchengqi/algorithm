package com.yc.bean3_datatype3.tree2.AvlTree;

import com.yc.bean3_datatype3.tree1.BinarySearchTree.*;

public class AvlNode  extends BinaryNode{
	public int height; // ¸ß¶È
	
	public AvlNode( Comparable theElement )
     {
         this( theElement, null, null );
     }

	public AvlNode( Comparable theElement, AvlNode lt, AvlNode rt )
     {
        super(  theElement, lt, rt);
         height   = 0;
     }
     
	@Override
	public String toString() {
		return "AvlNode [element=" + element + ", left=" + left + ", right="
				+ right + ",height="+height+"]";
	}

}
