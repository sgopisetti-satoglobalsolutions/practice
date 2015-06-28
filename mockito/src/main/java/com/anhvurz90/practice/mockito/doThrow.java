package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class doThrow {

	public static void main(String[] args) {
		List mockedList = mock(List.class);
		
		doThrow(new RuntimeException()).when(mockedList).clear();
		
		mockedList.clear();
	}
}
