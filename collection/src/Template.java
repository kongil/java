import java.util.*;

public class Template {
    public static int getEdge(int start, int end, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if ((edges[i][0] == start && edges[i][1] == end) || (edges[i][0] == end && edges[i][1] == start))
                return i;
        }
        return -1;
    }

    public static int[] solution(int n, int[][] edges) {
        int[] answer = new int[2];
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0 ; i < n; i++) {
            arrayList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            arrayList.get(s).add(e);
            arrayList.get(e).add(i);
        }

        for (int j = 0; j < 2; j++) {
            int max_idx = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (arrayList.get(i).size() > max) {
                    max = arrayList.get(i).size();
                    max_idx = i;
                }
            }

            int max_idx2 = 0;
            max = 0;
            for (int i = 0; i < arrayList.get(max_idx).size(); i++) {
                int target_idx = arrayList.get(max_idx).get(i);
                if (arrayList.get(target_idx).size() > max) {
                    max = arrayList.get(target_idx).size();
                    max_idx2 = target_idx;
                }
            }

            int edge_idx = getEdge(max_idx, max_idx2, edges);
            answer[j] = edge_idx;

            for (int i = arrayList.get(max_idx).size()-1; i>= 0; i--) {
                if (arrayList.get(max_idx).contains(max_idx2)) {
                    arrayList.get(max_idx).remove(i);
                }
            }
            for (int i = arrayList.get(max_idx).size()-1; i>= 0; i--) {
                if (arrayList.get(max_idx2).contains(max_idx)) {
                    arrayList.get(max_idx2).remove(i);
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] edges = {
                {0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}
        };

        int[] answer = solution(n, edges);

        for (int i = 0 ; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
