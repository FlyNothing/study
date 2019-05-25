package com.yzy.model;

public interface Employee {
	void work();
	
	static void check(){
		System.out.println("内部员工打卡");
	}
	
	default void checkIn(){
		System.out.println("打卡成功");
	}
}
