package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (!readOnly) {
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

	public boolean contains(Object element) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public Object getElementAt(int index) {
		return elements[index];
	}

	public int capacity() {
		return elements.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
