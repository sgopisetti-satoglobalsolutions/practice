package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class Never {

	public static void main(String[] args) {
		List mockOne = mock(List.class);
		List mock2 = mock(List.class);
		List mock3 = mock(List.class);

		mockOne.add("one");
		mockOne.add("three");
		
		verify(mockOne).add("one");
		verify(mockOne, never()).add("two");
		
		verifyZeroInteractions(mock2, mock3);
		verifyZeroInteractions(mockOne);
		System.out.println("Done!");
	}
}
