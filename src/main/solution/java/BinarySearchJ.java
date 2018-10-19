package java;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimtego_loc on 18.06.2018.
 */
public class BinarySearchJ<T extends Number> implements SearchJ<T> {

    private List<T> list;
    private boolean isSort;

    BinarySearchJ() {
        this.list = new ArrayList<>();
    }


    @Override
    public boolean itemExists(T item) {
        return list.contains(item);
    }

    @Override
    public List<T> sort(List<T> set) {
        this.list = set;
        return sort();
    }
    @Override
    public List<T> sort() {
        int start = 0;
        int end = list.size() - 1;
        sort(start, end);
        isSort = true;
        return list;
    }

    private void sort(int start, int end) {

        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;

        while (i < j) {
            BigDecimal bdItemI = new BigDecimal(list.get(i).toString());
            BigDecimal bdItemCur = new BigDecimal(list.get(cur).toString());
            BigDecimal bdItemJ = new BigDecimal(list.get(j).toString());
            while (i < cur && (bdItemI.compareTo(bdItemCur) <= 0)) {
                i++;
                bdItemI = new BigDecimal(list.get(i).toString());
                bdItemCur = new BigDecimal(list.get(cur).toString());
            }
            while (j > cur && (bdItemCur.compareTo(bdItemJ) <= 0)) {
                j--;
                bdItemCur = new BigDecimal(list.get(cur).toString());
                bdItemJ = new BigDecimal(list.get(j).toString());
            }
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);

                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        sort(start, cur);
        sort(cur + 1, end);
    }

    @Override
    public void putItem(T item) {
        if (isSort) {
            BigDecimal bdItem = new BigDecimal(item.toString());
            for (int i = 0; i < list.size(); i++) {
                BigDecimal bdList = new BigDecimal(list.get(i).toString());
                if (bdItem.compareTo(bdList) <= 0) {
                    list.add(i, item);
                    break;
                }
                if (i + 1 == list.size() && !(bdItem.compareTo(bdList) <= 0)) {
                    list.add(i + 1, item);
                }
            }
        }
        else
            list.add(item);
    }

    @Override
    public int binary(T number) {
        return rank(new BigDecimal(number.toString()), list, 0, list.size() - 1) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : list )
            sb.append(i).append(" ");
        return String.valueOf(sb);
    }

    private int rank(BigDecimal val, List<T> arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        BigDecimal bgMid = new BigDecimal(arr.get(mid).toString());
        if (val.compareTo(bgMid) < 0) {
            visual(mid);
            return rank(val, arr, lo, mid - 1);
        } else if (val.compareTo(bgMid) > 0) {
            visual(mid);
            return rank(val, arr, mid + 1, hi);
        } else {
            visual(mid);
            return mid;
        }
    }

    private void visual(int mid) {
        for (int i = 0; i < list.size(); i++) {
            if (mid == i) {
                System.out.print("[" +list.get(i) +"] ");
                continue;
            }
            System.out.print(list.get(i) +" ");
        }
        System.out.println();

    }
}
