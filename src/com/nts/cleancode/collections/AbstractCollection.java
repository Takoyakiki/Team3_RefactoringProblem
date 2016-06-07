package com.nts.cleancode.collections;

public abstract class AbstractCollection {
	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
	protected boolean readOnly;

	public abstract void add(Object element);

	public void addAll(AbstractCollection c) {
		if (c instanceof Set) {
			AbstractCollection s = (AbstractCollection)c;
			for (int i=0; i < s.size(); i++) {
				if (!contains(s.getElementAt(i))) {
					add(s.getElementAt(i));
				}
			}
			
		} else if (c instanceof List) {
			AbstractCollection l = (AbstractCollection)c;
			for (int i=0; i < l.size(); i++) {
				if (!contains(l.get(i))) {
					add(l.get(i));
				}
			}
		}
	}
	
	public void add(Object key, Object value) {
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		else 	
			for (int i = 0; i < size; i++)
				if (elements[i].equals(element)) {
					elements[i] = null;
					Object[] newElements = new Object[size - 1];
					int k = 0;
					for (int j = 0; j < size; j++) {
						if (elements[j] != null)
							newElements[k++] = elements[j];
					}
					size--;
					elements = newElements;
					return true;
				}
		return false;
	}

	public Object get(int i) {
		return elements[i];
	}

	public boolean contains(Object element) {
		for (int i=0; i<size; i++) 
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int capacity() {
		return elements.length;
	}

	public Object getElementAt(int index) {
		return elements[index];
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}

}
