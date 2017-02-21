package com.mikemyzhao.words;
/*
 * 实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * 给定一个String iniStirng，请返回一个bool值，True代表所有字符全都不同，False代表存在相同的字符。
 * 保证字符串中的字符为ASCII。字符串的长度大小等于3000.
 */

public class CharDifferernt11 {
	/*
	 * 法1.构建一个布尔值的数组，索引值i对应的标记只是该字符串是否含有字母表第i个字符。若这个字符第二次出现，立即返回false
	 * 
	 */
	public static boolean isUniqueChars2(String iniString){
		if(iniString.length() > 3000)
			return false;
		boolean[] char_set = new boolean[3000];
		for(int i=0; i<iniString.length(); i++){
			int val = iniString.charAt(i);
			if (char_set[val]){ //这个位置设置过true，就是之前有过，说明有相同的
				return false;
			}else{
				char_set[val] = true;//这个位置仍然为false，没有设置过
			}
			
		}
		return true;
	}
	
	
	
	public static void main(String[] args){
		String iniString = "ABC";
		for(int i=0; i<iniString.length(); i++){
			int val = iniString.charAt(i);
			System.out.print(val);
		}
		System.out.println(isUniqueChars2("abcd"));
	}
	
}
