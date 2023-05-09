public class MyMap<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private MyEntry<K, V>[] myEntries;
    private int size;

    public MyMap() {
        size = 0;
        myEntries = new MyEntry[DEFAULT_SIZE];
    }

    public V get(K k) {
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getK().equals(k)) return myEntries[i].getV();
        }
        return null;
    }

    public boolean containsKey(K k) {
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getK().equals(k)) return true;
        }
        return false;
    }
    public boolean containsValue(V v) {
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getV().equals(v)) return true;
        }
        return false;
    }

    public void clear() {
        myEntries = new MyEntry[DEFAULT_SIZE];
        size = 0;
    }

    public K[] keySet() {
        K[] k = (K[]) new Object[size];
        for (int i = 0; i < size; i++) {
            k[i] = myEntries[i].getK();
        }
        return k;
    }

    public V[] valueSet() {
        V[] v = (V[]) new Object[size];
        for (int i = 0; i < size; i++) {
            v[i] = myEntries[i].getV();
        }
        return v;
    }

    public V removeForKey(K k) {
        V removed = null;
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getK().equals(k)) {
                removed = myEntries[i].getV();
                System.arraycopy(myEntries, i + 1, myEntries, i, size - i - 1);
                size--;
            }
        }
        return removed;
    }

    public K removeForValue(V v) {
        K removed = null;
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getV().equals(v)) {
                removed = myEntries[i].getK();
                System.arraycopy(myEntries, i + 1, myEntries, i, size - i - 1);
                size--;
            }
        }
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K k, V v) {
        resize();
        for (int i = 0; i < size; i++) {
            if (myEntries[i].getK().equals(k)){
                myEntries[i].setV(v);
                return;
            }
        }
        myEntries[size] = new MyEntry(k, v);
        size++;
    }

    private void resize() {
        if (myEntries.length == size) {
            MyEntry[] newElements = new MyEntry[size * 2];
            System.arraycopy(myEntries, 0, newElements, 0, size);
            myEntries = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("{");
        for (int i = 0; i < size; i++) {
            s.append(myEntries[i].toString());
            if (size - i > 1) s.append(", ");
        }
        s.append("}");
        String st = new String(s);
        return st;
    }
}
