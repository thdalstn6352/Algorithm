package sw_expert.sw_expert_1873;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
							//상	하		좌			우
	static int flag;
	static int cur_x;
	static int cur_y;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= test_case; tc++) {
			String[] map_size = br.readLine().split(" ");
			int H = Integer.parseInt(map_size[0]);
			int W = Integer.parseInt(map_size[1]);

			cur_x = 0;
			cur_y = 0;
			
			char[][] battle_field = new char[H][W];
			
			//맵 구조 입력
			for(int r = 0; r < H; r++) {
				String map_element = br.readLine();
				
				for(int c = 0; c < W; c++) {
					battle_field[r][c] = map_element.charAt(c);
					switch(battle_field[r][c]) {
					case '<':
						cur_x = r;
						cur_y = c;
						flag = 2;
						break;
					
					case '>':
						cur_x = r;
						cur_y = c;
						flag = 3;
						break;
						
					case '^':
						cur_x = r;
						cur_y = c;
						flag = 0;
						break;
						
					case 'v':
						cur_x = r;
						cur_y = c;
						flag = 1;
						break;
					default:
						break;
					}
				}
			}
			
			
			//명령어
			int command_num = Integer.parseInt(br.readLine());
			String command = br.readLine();
			
			for(int i = 0; i < command_num; i++) {
				char comm = command.charAt(i);
				if(comm == 'U') {
					flag = 0;
					battle_field[cur_x][cur_y] = '^';
					move(H, W, battle_field);
				}
				else if(comm == 'D') {
					flag = 1;
					battle_field[cur_x][cur_y] = 'v';
					move(H, W, battle_field);
				}
				else if(comm == 'L') {
					flag = 2;
					battle_field[cur_x][cur_y] = '<';
					move(H, W, battle_field);
				}
				else if(comm == 'R') {
					flag = 3;
					battle_field[cur_x][cur_y] = '>';
					move(H, W, battle_field);
				}
				else if(comm == 'S') {
					int nx = cur_x + deltas[flag][0];
					int ny = cur_y + deltas[flag][1];
					
					while(true) {
						//맵 밖을 나갔을 때
						if(nx < 0 || nx >= H || ny <0 || ny >= W || battle_field[nx][ny] == '#')
							break;
						if(battle_field[nx][ny] == '*') {
							battle_field[nx][ny] = '.';
							break;
						}
						nx += deltas[flag][0];
						ny += deltas[flag][1];
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < H; i++) {
				sb.append(battle_field[i]).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		bw = null;
		br = null;
		
	}
	
	public static void move(int H, int W, char[][] battle_field) {
		int nx = cur_x + deltas[flag][0];
		int ny = cur_y + deltas[flag][1];
		
		if(nx >= 0 && nx < H && ny >= 0 && ny < W && battle_field[nx][ny] == '.') {
			battle_field[nx][ny] = battle_field[cur_x][cur_y];
			battle_field[cur_x][cur_y] = '.';
			cur_x = nx;
			cur_y = ny;
		}
	}
}
