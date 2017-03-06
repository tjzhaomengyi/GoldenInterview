package com.mikemyzhao.stackqueue;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;//用作时间戳
	
	public void enqueue(Animal a){
		//order用作某种形式的时间戳，以便比较猫或狗
		//插入队列的先后排序
		a.setOrder(order);	
		order++;
		if(a instanceof Dog){
			dogs.addLast((Dog) a);
		}else if( a instanceof Cat){
			cats.addLast((Cat)a);
		}
	}
	
	public Animal dequeueAny(){
		//查看猫和狗的队列的首部，弹出最旧的值
		if(dogs.size() == 0){
			return dequeueCats();
		} else if (cats.size() == 0){
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)){
			return dequeueDogs();
		}else{
			return dequeueCats();
		}
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}
	

}
	

