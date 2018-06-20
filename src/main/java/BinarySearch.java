import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimtego_loc on 18.06.2018.
 */
public class BinarySearch<T extends Number> implements Search<T> {

    private List<T> list;
    private boolean isSort;

    public BinarySearch() {
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
                bdItemI = new BigDecimal(list.get(i).toString());
                bdItemCur = new BigDecimal(list.get(cur).toString());
                System.out.println(bdItemI +" и " +bdItemCur +" - " +bdItemI +" <= " +bdItemCur +(bdItemI.compareTo(bdItemCur) <= 0));
                i++;
            }
            while (j > cur && (bdItemCur.compareTo(bdItemJ) <= 0)) {
                bdItemCur = new BigDecimal(list.get(cur).toString());
                bdItemJ = new BigDecimal(list.get(j).toString());
                System.out.println(bdItemCur +" и " +bdItemJ +" - " +bdItemCur +" <= " +bdItemJ +(bdItemCur.compareTo(bdItemJ) <= 0));
                j--;
            }
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                System.out.println(list);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        sort(start, cur);
        sort(cur + 1, end);
    }


   /* private void sort(int low, int high) {

        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        BigDecimal bdOpora = new BigDecimal(list.get(middle).toString());
        BigDecimal bdOpora = new BigDecimal(list.get(middle).toString());
        BigDecimal bdOpora = new BigDecimal(list.get(middle).toString());
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }*/

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

    private Object[] toArray() {
        return list.toArray();
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
