package BOJ.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;


public class P11866 {
    static public void main(String[] args) {
        solution();
    }

    static public void solution() {
        try {
            ArrayList<Integer> persons = new ArrayList();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder builder = new StringBuilder();

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                persons.add(i);
            }

            int cur = K - 1;
            builder.append('<');

            while (persons.size() > 1) {
                builder.append(persons.get(cur).toString()+", ");
                persons.remove(cur);
                int cnt = 0;
                int pos = cur - 1;

                while (cnt < K) {
                    cnt++;
                    if (pos >= persons.size() - 1) {
                        pos = 0;
                    } else pos++;
                }
                cur = pos;
            }

            builder.append(persons.get(0)+">");
            System.out.println(builder);

        } catch (Exception e) {

        }
    }
}
