package AlgoTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Algo2_서울_8반_송민수 {
	//맵의 크기와 요소를 저장하는 변수 선언
	static int R, C;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		// 입출력 버퍼 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] numbers = br.readLine().split(" ");
		R = Integer.parseInt(numbers[0]);
		C = Integer.parseInt(numbers[1]);
		map = new char[R][C];
		
		// 데이터 입력
		for(int r = 0; r < R; r++) {
			String lines = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = lines.charAt(c);
			}
		}
		
		// 화산재 수에 따른 반복
		int testCase = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < testCase; tc++) {
			int y = Integer.parseInt(br.readLine());
			//화산재의 좌표를 매개변수로 할당
			dfs(0, y-1);
		}
		
		//결과값 출력
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		bw = null;
		br = null;
	}
	
	// 왼쪽, 왼쪽 아래 좌표
	static int[][] left_deltas = { {0, -1}, {1, -1} };
	// 오른쪽, 오른쪽 아래 좌표
	static int[][] right_deltas = { {0, 1}, {1, 1} };
	
	
	public static void dfs(int x, int y) { // x, y = 현재 화산재의 좌표
		// 화산재의 아래 좌표
		int nx = x + 1;
		int ny = y;
		
		// 화산재의 아래 좌표가 맵의 범위를 벗어났을 경우 화산재 멈춤
		if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
			map[x][y] = 'O';
			return;
		}
		
		// 화산재 아래 좌표가 비어있지 않을 경우
		if(map[nx][ny] != '.') {
			// 화산재 아래 장애물 있을 경우 화산재 멈춤
			if(map[nx][ny] == 'X') {
				map[x][y] = 'O';
				return;
			}
			
			// 화산재 아래 화산재가 있을 경우
			else if(map[nx][ny] == 'O') {
				int newX = 0;
				int newY = 0;
				int flag = 0;
				
				//왼쪽, 왼쪽 아래 비었을 때
				for(int d = 0; d < 2; d++) {
					newX = x + left_deltas[d][0];
					newY = y + left_deltas[d][1];
					if(newX < 0 || newX >= R || newY < 0 || newY >= C || map[newX][newY] != '.') {
						flag = 1;
						break;
					}
				}
				
				if(flag == 1) {
					//오른쪽, 오른쪽 아래 비었을때
					for(int d = 0; d < 2; d++) {
						newX = x + right_deltas[d][0];
						newY = y + right_deltas[d][1];
						if(newX < 0 || newX >= R || newY < 0 || newY >= C || map[newX][newY] != '.') {
							flag = 2;
							break;
						}
					}
				}
				// flag = 0 => 왼쪽이 비었을 때, flag = 1 => 오른쪽이 비었을 때
				if(flag <= 1)			
					// 반복문을 통해 얻어낸 좌표를 매개변수로 할당 후 재귀
					dfs(newX, newY);
				else {
					// 왼쪽, 오른쪽 모두 비어있지 않을 경우 화산재 멈춤
					map[x][y] = 'O';
					return;
				}
			}
		}
		// 화산재 아래가 비어있을경우(.) 재귀
		dfs(nx, ny);
	}
}
