package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
public class WhenThen {

	public static void main(String[] args) {
		LinkedList mockedList = mock(LinkedList.class);
		
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedList.get(0));
//		System.out.println(mockedList.get(1));
		
		System.out.println(mockedList.get(999));
		
		verify(mockedList).get(0);
	}
}
