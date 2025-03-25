import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Q02 {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};
        int[] result = streamSolution(arr);
        System.out.println(Arrays.toString(result));

        int[] result2 = treeSolution(arr);
        System.out.println(Arrays.toString(result2));
    }

    private static int[] streamSolution(int[] arr) {
        // 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        // 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());
        // int 형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    private static int[] treeSolution(int[] arr) {
        // 중복값 제거, 내림차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        // int 형 배열에 담아서 반환
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
}
