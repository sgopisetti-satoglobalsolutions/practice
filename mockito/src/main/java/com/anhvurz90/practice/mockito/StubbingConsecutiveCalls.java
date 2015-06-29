package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class StubbingConsecutiveCalls {

	public static void main(String[] args) {
		List mock = mock(List.class);
		
		when(mock.get(1))
			.thenThrow(new RuntimeException())
			.thenReturn("foo", "bar", "three");
		
		//First call: throws runtime exception:
		try {
			mock.get(1);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		
		//Second call: prints "foo"
		System.out.println(mock.get(1));
		
		//Any consecutive call: prints "foo" as well (last stubbing wins)
		System.out.println(mock.get(1));
		
	}
}
