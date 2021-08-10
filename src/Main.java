import Heap.DiskSolution;
import Heap.ScovileSolution;

public class Main {


    public static void main(String[] args) {
        int K = 7;
        int[][] list = new int[][] {{0,3},{1,9},{2,6}};

        DiskSolution diskSolution = new DiskSolution();

        System.out.println("================= Result ================");
        System.out.println(diskSolution.solution(list));
        System.out.println("=========================================");
    }
}
