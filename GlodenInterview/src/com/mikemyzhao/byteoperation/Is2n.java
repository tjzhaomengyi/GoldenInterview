package com.mikemyzhao.byteoperation;

public class Is2n {
	public static boolean is2n(int n){
		if((n & (n-1)) == 0 ){
			return true;
		}else{
			return false;
		}
	}
}
