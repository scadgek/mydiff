package ua.scadge.difftool;


import java.util.*;

public class LongestCommonSublist implements List<String> {
    private final List<String> commonSublist;

    public LongestCommonSublist(List<String> first, List<String> second) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                int x = 0;
                while (first.get(i + x).equals(second.get(j + x))) {
                    x++;
                    if (((i + x) >= first.size()) || ((j + x) >= second.size())) break;
                }
                if (x > max) {
                    max = x;
                    start = i;
                }
            }
        }

        this.commonSublist = Collections.unmodifiableList(first.subList(start, (start + max)));
    }

    @Override
    public int size() {
        return commonSublist.size();
    }

    @Override
    public boolean isEmpty() {
        return commonSublist.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return commonSublist.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return commonSublist.iterator();
    }

    @Override
    public Object[] toArray() {
        return commonSublist.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return commonSublist.toArray(a);
    }

    @Override
    public boolean add(String s) {
        return commonSublist.add(s);
    }

    @Override
    public boolean remove(Object o) {
        return commonSublist.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return commonSublist.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return commonSublist.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return commonSublist.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return commonSublist.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return commonSublist.retainAll(c);
    }

    @Override
    public void clear() {
        commonSublist.clear();
    }

    @Override
    public String get(int index) {
        return commonSublist.get(index);
    }

    @Override
    public String set(int index, String element) {
        return commonSublist.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        commonSublist.add(index, element);
    }

    @Override
    public String remove(int index) {
        return commonSublist.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return commonSublist.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return commonSublist.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return commonSublist.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return commonSublist.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return commonSublist.subList(fromIndex, toIndex);
    }
}
