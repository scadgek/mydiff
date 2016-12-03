package ua.scadge.difftool;

import java.util.*;

public class MyDiff implements List<String> {

    private final List<String> diffList;

    public MyDiff(List<String> first, List<String> second) {
        final LongestCommonSublist longestCommonSublist = new LongestCommonSublist(first, second);

        final List<String> diffList = new ArrayList<>();

        if (longestCommonSublist.isEmpty()) {
            int last;
            for (last = 0; last < first.size() && last < second.size(); last++)
                diffList.add("* " + first.get(last) + "|" + second.get(last));

            if (second.size() > first.size()) {
                for (; last < second.size(); last++)
                    diffList.add("+ " + second.get(last));
            } else {
                for (; last < first.size(); last++)
                    diffList.add("- " + first.get(last));
            }
        } else {
            final int sublistIndexFirst = Collections.indexOfSubList(first, longestCommonSublist);
            final int sublistIndexSecond = Collections.indexOfSubList(second, longestCommonSublist);

            final List<String> linesBeforeCommonSublistFirst = first.subList(0, sublistIndexFirst);
            final List<String> linesBeforeCommonSublistSecond = second.subList(0, sublistIndexSecond);

            diffList.addAll(new MyDiff(linesBeforeCommonSublistFirst, linesBeforeCommonSublistSecond));

            for (String common : longestCommonSublist)
                diffList.add(" " + common);

            final List<String> linesAfterCommonSublistFirst = first.subList(sublistIndexFirst + longestCommonSublist.size(), first.size());
            final List<String> linesAfterCommonSublistSecond = second.subList(sublistIndexSecond + longestCommonSublist.size(), second.size());
            diffList.addAll(new MyDiff(linesAfterCommonSublistFirst, linesAfterCommonSublistSecond));
        }

        this.diffList = Collections.unmodifiableList(diffList);
    }

    @Override
    public int size() {
        return diffList.size();
    }

    @Override
    public boolean isEmpty() {
        return diffList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return diffList.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return diffList.iterator();
    }

    @Override
    public Object[] toArray() {
        return diffList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return diffList.toArray(a);
    }

    @Override
    public boolean add(String s) {
        return diffList.add(s);
    }

    @Override
    public boolean remove(Object o) {
        return diffList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return diffList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return diffList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return diffList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return diffList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return diffList.retainAll(c);
    }

    @Override
    public void clear() {
        diffList.clear();
    }

    @Override
    public String get(int index) {
        return diffList.get(index);
    }

    @Override
    public String set(int index, String element) {
        return diffList.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        diffList.add(index, element);
    }

    @Override
    public String remove(int index) {
        return diffList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return diffList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return diffList.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return diffList.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return diffList.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return diffList.subList(fromIndex, toIndex);
    }
}
