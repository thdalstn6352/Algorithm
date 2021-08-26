package baekjoon.BOJ_17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, D;
	static int killCount = Integer.MIN_VALUE;
	static int[][] map;
	static List<Integer> ArcherList;
	static int[] ArcherArr;
	static int[][] deltas = new int[][] {{0, -1}, {-1, 0}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] numbers = br.readLine().split(" ");
		N = Integer.parseInt(numbers[0]);
		M = Integer.parseInt(numbers[1]);
		D = Integer.parseInt(numbers[2]);
		ArcherArr = new int[3];
		map = new int[N][M];
		
		for(int row = 0; row < N; row++) {
			String[] lines = br.readLine().split(" ");
			for(int col = 0 ; col < M; col++) {
				map[row][col] = Integer.parseInt(lines[col]);
			}
		}
		ArcherLocate(0,0);
		sb.append(killCount);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	private static void ArcherLocate(int CNT, int start) {
		if(CNT == 3) {
			//궁수 위치 정한 후 공격
			AttackArcher();
			return;
		}
		for(int i = start; i < M; i++) {
			ArcherArr[CNT] = i;
			ArcherLocate(CNT+1, i+1);
		}
	}
	
	private static void AttackArcher() {
		int[][] CopyMap = deepCopy(map);
		boolean[][] Dead;
		int killCnt = 0;
		for(int i = 0; i < N; i++) {
			Dead = new boolean[N][M];
			
			for(int loc : ArcherArr) {
				if(CopyMap[N - 1][loc] == 1) {
					Dead[N-1][loc] = true;
				}
				else {
					//자기 범위만큼 탐색 해야햇
					SearchEnemy(new ArcherPosition(N-1, loc), Dead, CopyMap);
				}
			}
			killCnt += KillEnemy(Dead, CopyMap);
			AdvanceEnemy(CopyMap);
		}
		killCount = Math.max(killCount, killCnt);
		return;
	}
	
	private static void SearchEnemy(ArcherPosition archerPosition, boolean[][] Dead, int[][] CopyMap) {
		Queue<ArcherPosition> queue = new LinkedList<ArcherPosition>();
		boolean[][] visited = new boolean[N][M];
		visited[archerPosition.x][archerPosition.y] = true;
		queue.add(archerPosition);
		
		for(int dist = 1; dist <= D - 1; dist++) {
			int queueSize = queue.size();
			for(int q = 0; q < queueSize; q++) {
				ArcherPosition archer = queue.poll();
				int qx = archer.x;
				int qy = archer.y;
				for(int d = 0; d < deltas.length; d++) {
					int nx = qx + deltas[d][0];
					int ny = qy + deltas[d][1];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
						continue;
					}
					if(CopyMap[nx][ny] == 1) {
						Dead[nx][ny] = true; //찾으면 더 이상 탐색 불필요
						return;
					}
					else {
						visited[nx][ny] = true;
						queue.add(new ArcherPosition(nx, ny));
					}
				}
			}
		}
	}
	
	private static int KillEnemy(boolean[][] Dead, int[][] CopyMap) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Dead[i][j]) {
					CopyMap[i][j] = 0;
					count++;					
				}
			}
		}
		return count;
	}
	
	private static void AdvanceEnemy(int[][] CopyMap) {
		for(int i = N - 1; i > 0; i--) {
			CopyMap[i] = CopyMap[i-1];
		}
		CopyMap[0] = new int[M];
	}
	
	private static int[][] deepCopy(int[][] copy) {
		int[][] copyMap = new int[N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				copyMap[r][c] = copy[r][c];
			}
		}
		return copyMap;
	}
}

class ArcherPosition {
	int x;
	int y;
	
	public ArcherPosition(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
}
