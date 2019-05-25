package com.yzy.study;

import org.junit.Test;

import com.yzy.model.Employee;
import com.yzy.model.RD;
import com.yzy.model.UI;

public class MyTest {

	public void work() {
		Employee rd = new RD();
		Employee ui = new UI();
		rd.checkIn();
		rd.work();
		ui.checkIn();
		ui.work();

		Employee.check();
		
	}

	@Test
	public void test() {
		int a = 1;
		double b = 1;
		System.out.println(a==b);
	}
}
