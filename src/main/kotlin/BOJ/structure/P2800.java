package BOJ.structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P2800 {
    static Set<String> result = new TreeSet<>();
    static List<int[]> brackets = new ArrayList<>();
    static boolean[] checker;

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer("");
            String exp = br.readLine();
            Deque<Integer> bracketIdxs = new ArrayDeque();
            checker = new boolean[exp.length()];

            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    bracketIdxs.push(i);
                } else if (exp.charAt(i) == ')') {
                    int s = bracketIdxs.pop();
                    brackets.add(new int[]{s, i}); // 열린 괄호와 닫힌 괄호 인덱스 저장
                }
            }

            removeBracket(0, exp.toCharArray());
            result.stream().forEach(System.out::println);

        } catch (Exception e) {

        }
    }

    public static void removeBracket(int depth, char[] subExp) {
        if (depth == brackets.size()) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < subExp.length; i++) {
                if (!checker[i]) {
                    //확인 되지 않은 char는 숫자이거나 제거하지 않는 괄호이다
                    sb.append(subExp[i]);
                } else flag = true; // 제거된 괄호는 true이다
            }
            if (flag) result.add(sb.toString());
            return;
        }
        //combination
        removeBracket(depth + 1, subExp); // 지금 bracket을 포함할때
        int[] br = brackets.get(depth);
        checker[br[0]] = true;  // depth 순서의 ( 를 제거함
        checker[br[1]] = true;// depth 순서의 ) 를 제거함
        removeBracket(depth + 1, subExp);
        checker[br[0]] = false;  // 제자리
        checker[br[1]] = false;//제자리

        /**
         *  제자리 하지 않으면 다음과 같은 결과
         * (1+(2*(3+4))) // 입력
         * //결과
         * 1+(2*(3+4))
         * 1+2*(3+4)
         * 1+2*3+4
         * // 괄호를 포함하지 않는 결과만 나오게 된다
         * **/

    }
}
