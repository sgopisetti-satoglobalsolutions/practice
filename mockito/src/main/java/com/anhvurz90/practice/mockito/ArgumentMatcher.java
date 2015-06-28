package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class ArgumentMatcher {

	public static void main(String[] args) {
		List mockedList = mock(List.class);
		
		when(mockedList.get(anyInt())).thenReturn("element");
		
		System.out.println(mockedList.get(999));
		
		verify(mockedList).get(anyInt());
	}
}
