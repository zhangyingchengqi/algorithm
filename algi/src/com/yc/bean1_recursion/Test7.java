package com.yc.bean1_recursion;

import java.io.File;

public class Test7 {

	public static void main(String[] args) {
		String path=System.getProperty("user.home");
		File f=new File( path);
		long result=showAll( f );
		System.out.println(    "总大小:"+ result );
	}

	//显示这个   f下所有的文件和文件夹，即这个文件f的大小:   树结构  ->   先序, 中序, 后序. 
	//   isFile()    isDirectory()
	//   File[]  listFile();
	private static long showAll(File f) {
		long size=0;
		System.out.println(    f.getName() );
		if(   f.isFile() ){
			size=f.length();
		}else{
			File[] fs=f.listFiles();
			if(  fs!=null&&fs.length>0){
				for( File file:fs){
					size+=  showAll( file );  
				}
			}
		}
		return size;
	}
	
	

}
