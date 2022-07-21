package com.spring.ch2;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello[];
//		hello.main(); // private라서 외부 호출불가
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능을 제공하는 API
		// java.lang.reflect 패키지 제공
		Class helloClass = Class.forName("com.spring.ch2.Hello"); // Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다
		Hello hello = (Hello) (helloClass.newInstance()); // Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출가능하게 한다.
		
		main.invoke(hello); // hello.main()
	}

}
