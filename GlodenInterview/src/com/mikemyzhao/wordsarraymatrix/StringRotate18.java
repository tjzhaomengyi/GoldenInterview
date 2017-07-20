package com.mikemyzhao.wordsarraymatrix;

public class StringRotate18 {
//判断一个字符串是否由另一个字符串某点切割旋转，例hello：llohe
//就是判断旋转后的字符串是否是第一个拼接完的字符串subString 
	public boolean isRotation(String s1,String s2){
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			if(s1s1.contains(s2)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		StringRotate18 sr = new StringRotate18();
		boolean res =sr.isRotation("abcdefg", "efgabcd");
		System.out.print(res);
	}
	

}
