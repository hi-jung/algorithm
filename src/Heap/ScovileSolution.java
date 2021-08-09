package Heap;

import java.util.PriorityQueue;

public class ScovileSolution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        for (Integer s : scoville) {
            priorityQueue.add(s);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) return -1;


            int newScovile = (priorityQueue.poll() + (priorityQueue.poll() * 2));
            priorityQueue.add(newScovile);

            answer++;
        }
        return  answer;
    }
}
