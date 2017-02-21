package com.mikemyzhao.wordsarraymatrix;

//二位数组某一位为0，对应列和行都清零
//方法，只要某一列或者某一行有0，就清零，构建行和列对应的一维数组，有一个就把对应的清0
public class MatrixSet017 {
	public void setZeros(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		//记录值为0的元素所在行索引和列索引
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		//若行i或列j有个元素为0 ，则将arr[i][j]置为0
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(row[i] || column[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3},{0,4,5},{1,1,1}};
		MatrixSet017 ms = new MatrixSet017();
		ms.setZeros(matrix);
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
			}
		}
	}
	
}
