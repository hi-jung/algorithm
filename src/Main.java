import Heap.ScovileSolution;

public class Main {


    public static void main(String[] args) {
        int K = 7;
        int[] scovile = new int[] {1,2,3,9,10,12};

        ScovileSolution scovileSoultion = new ScovileSolution();

        System.out.println("================= Result ================");
        System.out.println(scovileSoultion.solution(scovile, K));
        System.out.println("=========================================");
    }
}
