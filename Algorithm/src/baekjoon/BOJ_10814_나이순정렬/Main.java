package baekjoon.BOJ_10814_나이순정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> queue = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			String[] infos = br.readLine().split(" ");
			Person person = new Person(Integer.parseInt(infos[0]), i, infos[1]);
			queue.add(person);
		}
		while(!queue.isEmpty()) {
			Person p = queue.poll();
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}

class Person implements Comparable<Person>{
	int age;
	int index;
	String name;
	
	public Person(int age, int index, String name) {
		super();
		this.age = age;
		this.index = index;
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Person [age=" + age + ", index=" + index + ", name=" + name + "]";
	}


	@Override
	public int compareTo(Person o) {
		if(this.age == o.age)
			return this.index - o.index;
		return this.age - o.age;
	
	}
	
}