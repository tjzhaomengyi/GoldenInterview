package com.mikemyzhao.sort;

public class InsertSort {
	public static int[] insertSort(int[] a,int n){
		for(int i = 1; i<n; i++){
			int temp = a[i];
			int j = i;
			while (j>0&& temp < a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
		return a;
	}
	
	public static void main(String[] args){
		 int[] a = {1,2,3,5,2,3};
	        int[] b = insertSort(a,6);
	        for (int i=0;i<6;i++){
	            System.out.print(b[i]+",");
	        }
	}
	
}
