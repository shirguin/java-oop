package Lesson_4.Class_Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ListAr<T> {

    private Object[] array;
    private int nextIndex;

    public int getSize() {
        return nextIndex;
    }

    public ListAr(int size) {
        array = new Object[size];
    }

    public Object[] getArray() {
        return array;
    }

    public ListAr() {
        this(10);
    }

    public void add(T element) {
        if (this.nextIndex < array.length) {
            array[nextIndex] = element;
            nextIndex++;
        } else {
            Object[] temp = new Object[array.length + 10];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp.clone();
            array[nextIndex] = element;
            nextIndex++;
        }
    }

    public T getByIndex(int index) {
        return (T) array[index];
    }

    public void removeByIndex(int index) {
        for (int i = index; i < nextIndex - 1; i++) {
            array[i] = array[i + 1];
        }
        nextIndex--;
    }

    public void removeByElement(T element) {
        if (contains(element)) {
            removeByIndex(indexOf(element));
        }
    }

    public void set(int index, T element) {
        if (this.nextIndex == array.length) {
            Object[] temp = new Object[array.length + 10];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp.clone();
        }
        for (int i = nextIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        nextIndex++;
    }

    public int indexOf(T element) {
        int fIndex = -1;
        int i = 0;
        boolean notFind = true;
        while (i < nextIndex && notFind) {
            if (array[i].equals(element)) {
                notFind = false;
                fIndex = i;
            }
            i++;
        }
        return fIndex;
    }

    public boolean contains(T element) {
        boolean answer = false;
        if (indexOf(element) > -1) {
            answer = true;
        }
        return answer;
    }

    public void addAll(ListAr<T> list) {
        Object[] a = list.getArray();
        if (array.length + 1 < (nextIndex + list.nextIndex)) {
            Object[] tmp = new Object[nextIndex + list.nextIndex];
            System.arraycopy(array, 0, tmp, 0, nextIndex);
            System.arraycopy(a, 0, tmp, nextIndex, list.nextIndex);
            array = tmp.clone();
            nextIndex += list.nextIndex;
        } else {
            System.arraycopy(a, 0, array, nextIndex, list.nextIndex);
            nextIndex += list.nextIndex;
        }
    }

    public void removeAll(ListAr<T> list) {
        Object[] rList = list.getArray();
        for (Object element : rList) {
            while (contains((T) element)) {
                removeByElement((T) element);
            }
        }
    }

    public void sort() {
        Arrays.sort(array, 0, nextIndex);
    }

    public void clear() {
        array = new Object[10];
        nextIndex = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < nextIndex; i++) {
            str.append(" ");
            if (i + 1 == nextIndex) {
                str.append(array[i] + " ");
            } else {
                str.append(array[i] + ", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}
