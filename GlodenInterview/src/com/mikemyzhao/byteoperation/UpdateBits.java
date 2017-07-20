package com.mikemyzhao.byteoperation;
//左右往中间插一串01数字
//左边生成全是1，右边生成全是1，合成掩码，插入的位置都为0
//与原数字进行域，移动插入的数字，再或一下
public class UpdateBits {
	int updateBits(int n, int m, int i, int j){
		//创建掩码，用来清除n中i到j的位
		//示例：i=2，j=4，掩码为11100011
		int allOnes = ~0;//等于一连串的1
		//在位置j之前的位均为1，其余位0，left=11100000
		int left = allOnes<<(j+1);
		//在位置i之后的位均为1，right = 00000011
		int right = ((1 << i) - 1);
		//除i到j的位为0，其余均为1.mask=11100011
		int mask = left | right;
		//清除位置j到i的位，然后将m放进去
		int n_cleared = n&mask;//清除j到i位置
		int m_shifted = m << i;//将m移动到相应位置
		return n_cleared | m_shifted;//对两者执行位或操作
	}
	
}
