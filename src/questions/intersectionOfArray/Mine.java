package questions.intersectionOfArray;

import java.util.HashMap;
import java.util.Map;

public class Mine {

    public static Map<Integer, Integer> array2Map(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        return map;
    }

    public static int[] map2Array(Map<Integer, Integer> map) {
        int size = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            size += entry.getValue();
        }
        int i = 0;
        int[] arr = new int[size];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++){
                arr[i] = entry.getKey();
                i++;
            }
        }
        return arr;
    }

    public static int[] getIntersection(int[] A, int[] B){
        Map<Integer, Integer> mapA = array2Map(A);
        Map<Integer, Integer> mapB = array2Map(B);
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: mapA.entrySet()){
            if (mapB.containsKey(entry.getKey())){
                 if (entry.getValue() < mapB.get(entry.getKey()))
                     map.put(entry.getKey(), entry.getValue());
                 else
                     map.put(entry.getKey(), mapB.get(entry.getKey()));
            }
        }

        return map2Array(map);
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 10};
        int[] B = {1, 3, 8, 3, 9};

        int[] intersection = getIntersection(A, B);
        for (int i : intersection) {
            System.out.print(i+ " ");
        }
    }
}
