package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class Verify2 {

	public static void main(String[] args) {
		List mockedList = mock(List.class);
		
		mockedList.add("once");
		
		mockedList.add("twice");
		mockedList.add("twice");
		
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		
		verify(mockedList, never()).add("never happened");
		
		verify(mockedList, atLeastOnce()).add("three times");
//		verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
		System.out.println("OK!");
	}
}
