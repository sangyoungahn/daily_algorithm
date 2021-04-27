package chapter5;

import java.util.ArrayList;

public class 예제5_9 {
	static class Node {
		private int index;
		private int distance;

		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}

		public void show() {
			System.out.println("(" + index + ", " + distance + ")");
		}
	}

	// 행이 3개인 인접리스트 표현
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			graph.add(new ArrayList<Node>());
		}

		// 노드 0에 연결된 노드 정보 저장(노드, 거리)
		graph.get(0).add(new Node(1, 7));
		graph.get(0).add(new Node(2, 5));

		// 노드 1에 연결된 노드 정보 저장(노드, 거리)
		graph.get(1).add(new Node(0, 7));

		// 노드 2에 연결된 노드 정보 저장(노드, 거리)
		graph.get(2).add(new Node(0, 5));

		// 그래프 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				graph.get(i).get(j).show();
			}
			System.out.println();
		}
	}

}
