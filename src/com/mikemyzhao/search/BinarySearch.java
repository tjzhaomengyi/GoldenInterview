package com.mikemyzhao.search;

public class BinarySearch {
	int binarySearch(int[] a, int x){
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while (low <= high){
			mid = (low+high) / 2;
			if(a[mid] < x){
				low = mid + 1;
			} else if (a[mid] > x){
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	int binarySearchRecursive(int[] a,int x,int low,int high){
		if ( low > high) 
			return -1;
		int mid = (low+high) / 2;
		if(a[mid] < x){
			return binarySearchRecursive(a,x,mid+1,high);
		}else if (a[mid] > x){
			return binarySearchRecursive(a,x,low,mid-1);
		}else{
			return mid;
		}
	}
	
	public static void main(String[] args){
		int[] a = {2,3,4,5,6,8};
		BinarySearch bs = new BinarySearch();
		int pos = bs.binarySearch(a, 4);
		int pos1 = bs.binarySearchRecursive(a, 4, 0, a.length-1);
		System.out.println(pos);
		System.out.println(pos1);
	}
	
}
