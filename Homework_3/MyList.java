import java.util.Objects;

public class MyList implements  IntegerList {

    private Integer[] myList;
    public MyList() {
        myList = new Integer[0];
    }

    @Override
    public int size() {
        return myList.length;
    }

    @Override
    public boolean isEmpty() {
        return myList.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Integer integer : myList) {
            if (integer == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if(index < 0 || index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        return myList[index];
    }

    @Override
    public void add(int index, Integer element) {
        if(index < 0 || index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        Integer[] myList0 = new Integer[myList.length + 1];
        System.arraycopy(myList, 0, myList0, 0, myList.length);
        myList = new Integer[myList0.length];
        System.arraycopy(myList0, 0, myList, 0, myList0.length);
        myList[index] = element;
    }

    @Override
    public Integer remove(int index) {
        if(index < 0 || index >= myList.length) {
            throw new IndexOutOfBoundsException();
        }
        Integer[] myList0 = new Integer[myList.length - 1];
        for(int i = 0; i < myList.length; ++i) {
            if(i < index) {
                myList0[i] = myList[i];
            } else if(i > index) {
                myList0[i - 1] = myList[i];
            }
        }
        Integer num = myList[index];
        myList = new Integer[myList0.length];
        System.arraycopy(myList0, 0, myList, 0, myList.length);
        return num;
    }

    @Override
    public int indexOf(Integer o) {
        for(int i = 0; i < myList.length; ++i) {
            if(Objects.equals(myList[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(Integer e) {
        if(e == null) {
            throw new NullPointerException();
        }
        add(myList.length, e);
        return true;
    }

    @Override
    public boolean remove(Integer o) {
        if(!contains(o)) {
            return false;
        }
        remove(indexOf(o));
        return true;
    }
}
