package baekjoon.BOJ_1946_신입사원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> rankMap = new TreeMap<>();
			PriorityQueue<Rank> rankByInterview = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++) {
				String[] ranks = br.readLine().split(" ");
				int docRank = Integer.parseInt(ranks[0]);
				int interRank = Integer.parseInt(ranks[1]);
				
				rankMap.put(docRank, interRank);
				rankByInterview.add(new Rank(docRank, interRank));
			}
			
			while(!rankByInterview.isEmpty()) {
				int firstKey = rankMap.keySet().stream().findFirst().get();
				int curInterRank = rankMap.get(firstKey);
				
				while(rankByInterview.peek().interRank >= curInterRank) {
					int key = rankByInterview.poll().docRank;
					rankMap.remove(key);
					if(rankByInterview.isEmpty())
						break;
				}
				
				cnt++;
			}
			sb.append(cnt).append("\n");
			cnt = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}

class Rank implements Comparable<Rank>{
	int docRank;
	int interRank;
	
	public Rank(int docRank, int interRank) {
		super();
		this.docRank = docRank;
		this.interRank = interRank;
	}

	@Override
	public String toString() {
		return "Rank [docRank=" + docRank + ", interRank=" + interRank + "]";
	}

	@Override
	public int compareTo(Rank o) {
		// TODO Auto-generated method stub
		return -1 * (this.interRank - o.interRank);
	}
	
}

