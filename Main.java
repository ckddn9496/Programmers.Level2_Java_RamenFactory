import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		System.out.println(new Solution().solution(stock, dates, supplies, k));
	}

}
class Solution {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int dateIdx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
        	if (dateIdx < dates.length && i == dates[dateIdx])
        		q.add(supplies[dateIdx++]);
        	if (stock == 0) {
        		stock += q.poll();
        		answer++;
        	}
        	stock--;	
        }
        return answer;
    }
}