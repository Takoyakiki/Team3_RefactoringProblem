package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (readOnly) 
			return;
		
		int newSize = size + 1;
		if (newSize > elements.length) {
			Object[] newElements =
					new Object[elements.length + INITIAL_CAPACITY];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
		
		if (contains(element))
			return;
		elements[size++] = element;
	}
}
