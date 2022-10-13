// 트리

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 트리 구조 표현을 위한 그래프
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n]; // 방문 여부 확인용
        int[] parentNode = new int[n]; // 부모 노드 저장

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : tree.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v;
                }
            }
        }
        for(int i = 1; i < n; i++) {
            System.out.println(parentNode[i] + 1);
        }
    }
}