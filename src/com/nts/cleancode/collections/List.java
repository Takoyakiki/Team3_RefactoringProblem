package com.nts.cleancode.collections;

public class List extends AbstractCollection {
	@Override
	public void add(Object element) {
		if (readOnly) 
			return;
		
		int newSize = size + 1;
		if (newSize > elements.length) {
			Object[] newElements =
					new Object[elements.length + 10];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
		elements[size++] = element;
		
	}

	public void set(int i, Object value) {
		if (readOnly) 
			return;
		
		if (i >= size)
			throw new ArrayIndexOutOfBoundsException();
		elements[i] = value;
	}
}
