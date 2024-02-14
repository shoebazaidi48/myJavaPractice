package com.java.myJavaPractice.rpi;

// collection of unique and unordered elements
// [1,2,3] == [3,1,2]
// [1,2,3,3] not unique
// speed is important
public class Set {

    private int size = 0;
    private Object[] elements;

    public Set(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public Set() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element) {
        if (contains(element)) {
            return;
        }
        if (size == elements.length) {
            Object[] tmp = new Object[size * 2];
            System.arraycopy(elements, 0, tmp, 0, size);
            elements = tmp;
        }
        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    // [1,2,3},null...] -(remove 1)-> [3,2},null,null...]
    public void remove(Object element) {
        if (contains(element)) {
            int index = indexOf(element);
            elements[index] = elements[size - 1];
            elements[size - 1] = null;
            size--;
        }
    }

    private int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}

