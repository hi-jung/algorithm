package Heap;

import java.util.PriorityQueue;

public class ScovileSolution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        // 1) 음식들의 스코빌 지수를 우선순위 큐에 하나씩 넣어서, 스코빌 지수가 낮은 순서대로 정렬되어 들어가도록 함
        for (Integer s : scoville) {
            priorityQueue.add(s);
        }

        // 2) 우선순위 큐를 사용하여 가장 우선 순위가 높은 값이 기준 스코빌 지수보다 커질 때 까지 while 문 수행
        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) return -1;

            // 3) 우선순위가 높은 값 두 개를 꺼내어 섞은 음식의 스코빌 지수 구하기
            int newScovile = (priorityQueue.poll() + (priorityQueue.poll() * 2));
            
            // 4) 섞은 음식의 스코빌 지수를 큐에 넣기
            priorityQueue.add(newScovile);
            
            // 5) 섞은 횟수 만큼 answer 값 1씩 증가
            answer++;
        }

        return  answer;
    }
}
