package com.mikemyzhao.words;

public class MatrixChange9016 {
/*
 * 给定一幅由nXn矩阵表示的图像，其中每个像素的大小为4字节，编写一个方法将图像旋转90度。不占用额外内存空间能否做到？
 */
	//解法：for i = 0 to n：
	//		temp=top[i];top[i]=left[i];left[i]=bottom[i];
	//		bottom[i]=right[i];right[i]=temp
	//从最外面一层开始逐渐向里，也可以从内层开始
	public void rotate(int[][] matrix,int n){
		for(int layer = 0; layer < n/2; ++layer){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i){
				int offset = i - first;
				//存储在上边
				int top = matrix[first][i];
				//左到上
				matrix[first][i] = matrix[last-offset][first];
				//下到左
				matrix[last-offset][first] = matrix[last][last-offset];
				//右到下
				matrix[last][last-offset] = matrix[i][last];
				//上到右
				matrix[i][last] = top;
			}
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
			}
		}
		MatrixChange9016 mc = new MatrixChange9016();
		mc.rotate(matrix,3);
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
			}
		}
	}
	
}
