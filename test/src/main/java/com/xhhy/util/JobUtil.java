package com.xhhy.util;

import java.util.Date;

public class JobUtil {

	private  int counter = 0;

	protected void execute() {
		System.out.println(new Date());
		System.out.println("(" + counter++ + ")");
	}
}
