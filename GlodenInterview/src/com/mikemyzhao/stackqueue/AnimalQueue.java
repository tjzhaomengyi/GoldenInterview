package com.mikemyzhao.stackqueue;

/*
 * 有家动物收容所只收容狗和猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，
 * 收养人只能收养所有动物中“最老”（根据进入收容所的时间长短）的动物，
 * 或者可以挑选猫或者狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。
 * 请创建适用于这个系统的数据结构，实现各种操作方法，
 * 比如enqueue、dequeueAny、dequeueDog和dequeueCat等。
 * 允许使用Java内置的LinkedList数据结构。
 */
//相关的类Animal、CatDog
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
	

