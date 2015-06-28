package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;
public class Verify {

	public static void main(String[] args) {
		List mockedList = mock(List.class);
		
		//using mock object
		mockedList.add("one");
		mockedList.clear();
		
		//verification
		verify(mockedList, times(1)).add("one");
		verify(mockedList).clear();
		verify(mockedList, times(2)).add("one");
	}
}
