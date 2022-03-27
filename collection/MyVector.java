import java.util.*;

public class MyVector implements List {
    protected Object[] data = null; // 객체를 담기 위한 객체배열을 선언한다
    protected int capacity = 0;     // 용량
    protected int size = 0;         // 크기

    public MyVector(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("유효하지 않은 값입니다 : " + capacity);

        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        this(10); // 크기를 지정하지 않으면 default 10으로 설정
    }

    // 최소한의 저장곤간(capacity)를 확보하는 메서드
    public void ensureCapcity(int minCapacity) {
        if (minCapacity - data.length > 0)
            setCapacity(minCapacity);
    }

    @Override
    public boolean add(Object obj) {
        // 새로운 객체를 저장하기 전에 저장할  공간을 확보한다.
        ensureCapcity(size+1);
        data[size++] = obj;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        return data[index];
    }

    @Override
    public Object remove(int index) {
        Object oldObj = null;

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        oldObj = data[index];

        // 삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해 빈자리를 채워줘야 한다.
        if (index != size-1) {
            System.arraycopy(data, index+1, data, index, size-index-1);
        }
        data[size-1] = null;
        size--;
        return oldObj;
    }

    @Override
    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(data)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void trimToSize() {
        setCapacity(size);
    }

    private void setCapacity(int capacity) {
        if (this.capacity == capacity) return;

        Object[] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        this.capacity = capacity;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }
}