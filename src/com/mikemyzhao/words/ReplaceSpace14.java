package com.mikemyzhao.words;

public class ReplaceSpace14 {
	/*
	 * 编写一个方法，将字符串中的空格全部替换为”%20”。
	 * 假定该字符串的尾部有足够的空间存放新增字符，
	 * 并且知道字符串的“真实”长度（java用字符数组，以便在数组上操作）
	 * 示例：输入：“Mr John Smith”，输出：“Mr%20John%20Smith”
	 */
	/*方法：假定字符串尾部有足够空间存放新增字符，并且知道字符串的真实长度
	 * 对字符串进行两次扫描，第一次扫面出字符串中有多少空格，算出最终字符串长度
	 * 第二次扫描开始反向编辑字符串，检测到空格将%20复制到一个位置，不是的话复制原先字符
	 */
	public char[] replaceSpace(char[] str,int length){
		int spaceCount = 0,newLength,i;
		for (i = 0; i < length; i++){
			if (str[i] == ' '){
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] newstr = new char[newLength];
		for (i = length - 1; i >= 0; i--){
			if(str[i] == ' '){
				newstr[newLength - 1] = '0';
				newstr[newLength - 2] = '2';
				newstr[newLength - 3] = '%';
				newLength = newLength - 3;
			}else{
				newstr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return newstr;
	}
	
	//方法2、不用字符数组，换成StringBuilder
	public String replaceSpaceString(String inistr,int length){
		int spaceCount = 0,newLength,i;
		for(i = 0; i < length; i++){
			if(inistr.charAt(i) == ' '){
				spaceCount++;
			}
		}
		//newLength = length + spaceCount * 2;
		StringBuilder newstr = new StringBuilder();
		for( i = 0;i <= length-1; i++){
			if(inistr.charAt(i) == ' '){
				newstr.append("%20");
			}else{
				newstr.append(inistr.charAt(i));
			}
		}
		return newstr.toString();
	}
	
	
	public static void main(String[] args){
		ReplaceSpace14 rs = new ReplaceSpace14();
		char[] str = new char[]{'H',' ','e','l','l',' ','a'};
		System.out.println(str.length);
		char[] newstr = rs.replaceSpace(str,str.length);
		System.out.println(newstr);
		
		String str1 = new String("a b c");
		String str2 = rs.replaceSpaceString(str1, str1.length());
		System.out.println(str2);
		
	}
	
	
}
