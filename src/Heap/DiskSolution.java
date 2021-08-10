package Heap;

import java.util.*;

public class DiskSolution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int index = 0;
        int count = 0;
        int time = 0;

        // 1) 원본 배열을 작업 요청 시간이 빠른 순으로 배열
        //  - (문제 어디에도 원본 배열이 작업 요청 시간 순서대로 정렬 되어 있다고 하지 않음)
        Arrays.sort(jobs, (x,y) -> x[0] - y[0]);

        // 2) 작업 처리 시간 순서대로 정렬 되는 우선 순위 큐 선언 (우선 순위 기준을 정하여 선언)
        PriorityQueue<int []> priorityQueue = new PriorityQueue<>((x,y) -> x[1] - y[1]);

        // 3) time 에 작업 요청 시간 순서대로 정렬 된 jobs 의 첫번 째 작업의 요청 시간을 넣어줌
        time = jobs[0][0];

        // 4) 작업의 갯수 만큼 while 문 수행
        while (count < jobs.length) {

            // 5) 우선 순위 큐에 작업을 하나 씩 넣어줌 (작업 요청 시간이 되었을 때 큐에 들어감)
            while (index < jobs.length && time >= jobs[index][0]) {
                priorityQueue.offer(jobs[index++]);
            }

            if (priorityQueue.isEmpty()) {
                // 6) 작업이 모두 처리되어 우선 순위 큐가 비어 있다면 마지막 작업의 요청 시간을 넣어줌
                time = jobs[index][0];
            } else {
                // 7) 큐에 작업이 남아있다면 작업 하나를 꺼내어 currentJob에 넣어줌
                int[] currentJob = priorityQueue.poll();

                // 8) time 에 작업 처리 시간을 더해줌
                time += currentJob[1];

                // 9) answer 에 (작업 처리 시간 - 작업 요청시간) 값을 더해줌
                answer += time - currentJob[0];

                count++;
            }
        }

        // (작업 요청부터 종료까지 걸린 시간 / 작업의 갯수) 를 return
        return answer / jobs.length;
    }
}
