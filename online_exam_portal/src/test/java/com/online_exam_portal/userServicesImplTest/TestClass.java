package com.examportal.serviceimpltest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

	 @Test
	    public void TestMethod() {
	        // Create an instance of the Test class
	        com.examportal.entity.Test test1 = new com.examportal.entity.Test();

	        // Your test logic here
	        // You can set properties or perform assertions as needed
	    }
}
