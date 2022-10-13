// 큐

import java.util.*;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue queue = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cnt = 0;
        while (queue.size() != 1) {
            int data = (int) queue.remove();
            cnt += 1;
            if(cnt % K == 0) {
                sb.append(data + ", ");
            } else {
                queue.add(data);
            }
        }
        sb.append(queue.remove()).append(">");
        System.out.println(sb);
    }
}

