package com.anhvurz90.practice.mockito;

import static org.mockito.Mockito.*;

import java.util.List;

import org.mockito.InOrder;

public class OrderVerification {

	public static void main(String[] args) {
		List singleMock = mock(List.class);
		//using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");
		//create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(singleMock);
		//following will make sure that add is first called with "first", and then "second"
		System.out.println("order verification 1");
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");
		//-------------------------------------
		//multiple mocks
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);
		//using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");
		//create inOrder object passing any mocks that need to be verified in order
		inOrder = inOrder(firstMock, secondMock);
		//following will make sure that firstMock was called before second mock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");
	}
}
