package com.mikemyzhao.words;
/*
 * 给定两个字符串，请编写程序，确定一个字符串的字符重新排列后，能否变成另一个字符串
 */

public class SortWordsSame13 {
	/*1、解法1：排序字符串
	 * 若两个字符串互为变位词，那么它们拥有同一组字符，只不过顺序不同。因此，对字符串排序，组成两个变位词的字符就会有相同的顺序。
	 */
	public String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation(String s,String t){
		if (s.length() != t.length()){
			return false;
		}else{
			return sort(s).equals(sort(t));
		}
	}
	
	/*
	 * 2、两个字符串的各字符数是否相同，把String类型转换成char数组
	 * 这里有个知识点，就是char单个取出后可以变为数字用来做数组下标进行数组标记
	 * 字符串里面的一个字母对应一个int数组的下标，每到一个字符下标对应的int加1
	 * 同样方法对比较的字符串做比较，每次取出字符，在对应下标的数组中的int里-1
	 * 如果-1后的值小于0，两个字符串不同
	 * 
	 */
	public boolean permutation2(String s,String t){
		if(s.length() != t.length())
			return false;
		int[] letters = new int[256];//假设条件
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			letters[c]++;
		}
		for(int i=0; i<t.length(); i++){
			int c = (int)t.charAt(i);
			if(--letters[c]<0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		SortWordsSame13 sws = new SortWordsSame13();
		boolean res = sws.permutation("hhhh", "hhhh");
		System.out.println(res);
	}
	
	
}
