import Challenge.ScoreSolution;
import Hash.MarathonSolution;
import Heap.DiskSolution;
import Heap.ScovileSolution;

public class Main {


    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        MarathonSolution marathonSolution = new MarathonSolution();

        System.out.println("================= Result ================");
        System.out.println(marathonSolution.solution(participant, completion));
        System.out.println("=========================================");
    }
}
