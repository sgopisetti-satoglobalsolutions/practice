package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;
public class RedundantInvocation {
 
	public static void main(String[] args) {
		List mockedList = mock(List.class);
		//using mocks
		mockedList.add("one");
		mockedList.add("two");
		
		verify(mockedList).add("one");
		//following verification will fail
		verifyNoMoreInteractions(mockedList);
	}
}
