package com.mikemyzhao.words;

public class CompressString15 {
	/*
	 *利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
	 *比如，字符串“aabcccccaaa”会变成”a2b1c5a3”。
	 *若压缩后的字符串没有变短则返回原先的字符串 
	 */
	public String compressBad(String str){
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length();i++){
			if(str.charAt(i) == last){//找到重复字符
				count++;
			}else{//插入字符的数目，更新last字符
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}	
		return mystr + last + count;
	}
	
	public String compressBetter(String str){
		//检查压缩后的字符串是否变长
		//int size = countCompression(str);
		//if( size >= str.length()){
			//return str;
		//}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i=1; i<str.length();i++){
			if(str.charAt(i) == last){
				count++;
			}else{
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		//由于上面两个append，当重复字符改变时，才会插入字符，
		//我们需要在函数末尾更新字符串，因为最后一组重复字符还未放入压缩字符串中
		mystr.append(last);
		mystr.append(count);
		if(mystr.length() > str.length()){
			return str;
		}else{
			return mystr.toString();
		}
	}
	
	public static void main(String[] args){
		CompressString15 cs = new CompressString15();
		String str = cs.compressBad("abbbbbbbccc");
		System.out.println(str);
		
		System.out.println(cs.compressBetter("abcccc"));
		System.out.println(cs.compressBetter("abc"));
	}
}
