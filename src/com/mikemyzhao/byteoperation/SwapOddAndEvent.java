package com.mikemyzhao.byteoperation;

public class SwapOddAndEvent {

	public int swapOddEventBits(int x){
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555 << 1)));
	}
	
}
