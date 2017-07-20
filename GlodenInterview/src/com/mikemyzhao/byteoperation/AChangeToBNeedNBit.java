package com.mikemyzhao.byteoperation;

public class AChangeToBNeedNBit {

	int bitSwapRequired(int a,int b){
		int count = 0;
		for(int c = a^b;c!=0;c=c>>1){
			count+=c&1;
		}
		return count;
	}
	
	public static void main(String[] args){
		AChangeToBNeedNBit ab = new AChangeToBNeedNBit();
		int a =ab.bitSwapRequired(15, 2);
		System.out.println(a);
	}
}
