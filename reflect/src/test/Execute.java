package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Execute { //리플렉션이란 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법

	public static void main(String[] args) {
		String className = "test.Human";
		try {
			Class clazz = Class.forName(className); //동적 로딩 : 어떠한 클래스가 로딩 될지 모르기 때문에 Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것
			System.out.println(clazz); //휴먼클래스의 메모리 생성x 해당클래스의 정보만 가지고있음
			
			Human h = (Human)clazz.newInstance();
			System.out.println(h); //휴먼클래스의 메모리 생성o
			
			Method[] methods = clazz.getDeclaredMethods(); //getMethod-상속한클래스까지 다나옴, getDeclareMethods-휴먼클래스에 있는 메서드만 
			for(Method method:methods) { //Method 정해지지않은 dt, 클래스임
				System.out.println(method);
				if(method.getName().equals("setAge")) {
					method.invoke(h, "20"); //invoke:해당메서드 h 를실행한다 20 대입
				}
			}
			System.out.println(h); //Human [name=null, age=20, toString()=test.Human@7852e922]
								// 따라서 메서드이름과 데이터타입만 안다면 여러가지를 할 수 있다!!
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
