package sw_expert.sw_expert_1861;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static int size;
	static int max_room = 0;
	
	static int[][] rooms;
	static Room room;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= test_case; tc++) {
			size = Integer.parseInt(br.readLine());
			
			
			rooms = new int[size][size];
			room = new Room(-1, 0);
			
			for(int r = 0; r < size; r++) {
				String[] lines = br.readLine().split(" ");
				for(int c = 0; c < size; c++) {
					rooms[r][c] = Integer.parseInt(lines[c]);
				}
			}
			
			for(int x = 0; x < size; x++) {
				for(int y = 0; y < size; y++) {
					recur(x, y, 1, rooms[x][y]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(room.value).append(" ").append(room.max_search).append("\n");
			max_room = 0;
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
	}
	
	public static void recur(int row, int col, int cnt, int value) {
		for(int d = 0; d < deltas.length; d++) {
			int nr = row + deltas[d][0];
			int nc = col + deltas[d][1];

			if(nr >= 0 && nr < size && nc >= 0 && nc < size && (rooms[row][col] + 1 == rooms[nr][nc])) {
				recur(nr, nc, cnt+1, value);
				break;
			}
		}
		if(max_room < cnt) {
			max_room = cnt;
			room.value = value;
			room.max_search = max_room;
		}
		else if(max_room == cnt) {
			if(room.value > value)
				room.value = value;
		}
		
		return;
	}
}

class Room {
	int value;
	int max_search;
	
	
	public Room() {
		super();
	}

	public Room(int value, int max_search) {
		super();
		this.value = value;
		this.max_search = max_search;
	}

	@Override
	public String toString() {
		return "Room [value=" + value + ", max_search=" + max_search + "]";
	}
	
	
}
