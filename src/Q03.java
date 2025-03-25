import java.util.Arrays;
import java.util.HashSet;

public class Q03 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        int[] result1 = solution(arr);
        System.out.println(Arrays.toString(result1));

        int[] result2 = setSolution(arr);
        System.out.println(Arrays.toString(result2));
    }

    private static int[] setSolution(int[] arr) {
        // 중복값 제거를 위한 hash set 사용
        HashSet<Integer> set = new HashSet<>();

        // 두 수를 선택하는 모든 경우를 반복문으로 구함
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        // 정렬 후 int 형 배열로 변환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution(int[] arr) {

        // 두 수의 합을 담을 배열 생성
        int[] temp = new int[arr.length * (arr.length - 1)]; // 굳이 고정된 길이를 가지는 배열 불필요
        int pointer = 0;

        // 반복문을 통해 연산하여 생성된 배열에 할당
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                temp[pointer] = arr[i] + arr[j];
                pointer++;
            }
        }

        // 배열에서 중복 제거
        Integer[] result = Arrays.stream(temp).boxed().distinct().toArray(Integer[]::new);

        // 배열 정렬
        Arrays.sort(result);

        // int 형 배열로 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
