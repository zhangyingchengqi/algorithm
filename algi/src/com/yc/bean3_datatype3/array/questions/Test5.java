package com.yc.bean3_datatype3.array.questions;

/**
 * 将一个字符数组中所有的空格全部替换成为  "%20",假设这个字符数组中有足够的空间存放新增字符. 
   String s="ab c";    s.toCharArray();

   char[] chs=new char[]{'a','b',' ','c',' ',' ',' ',' ' };
   int length=4;
   
   
   =>   {'a','b','%','2','0','c',' ',' ' };
 *
 */
public class Test5 {

	public static void main(String[] args) {
		char[] chs=new char[]{'a','b',' ','c',' ','d',' ',' ',' ',' ',' '};
		replaceSpace(  chs, 6);
		System.out.println(   chs );
	}
	
	public static void replaceSpace( char [] str, int length){
		int spaceCount=0;
		int newLength=0;
		for( int i=0;i<length;i++){
			if(  str[i]==' '){
				spaceCount++;
			}
		}
		newLength=length+ spaceCount*2;
		str[newLength]='\0';
		for( int i=length-1;i>=0;i--){
			if(   str[i]==' '){
				str[newLength-1]='0';
				str[newLength-2]='2';
				str[newLength-3]='%';
				newLength-=3;
			}else{
				str[newLength-1]=str[i];
				newLength--;
			}
		}
	}

}
