import java.util.List;

/**
 * Created by nimtego_loc on 18.06.2018.
 */
public interface Search <T extends Number> {
    List<T> sort(List<T> set);
    boolean itemExists(T item);
    List<T> sort();
    void putItem(T item);
    int binary(T number);
}
