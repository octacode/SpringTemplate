class Demo {
	
	static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}

		public void insert(int data) {
			Node temp = this;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}

		public void print() {
			Node temp = this;
			while (temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}

		public Node reverse() {
			Node temp = this;
			while (temp != null) {

			}
			return temp;
		}

		public void printRec() {
			System.out.print(this.data);
			if (this.next != null)
				this.next.printRec();
		}

		public void printRevRec() {
			if (this.next != null)
				this.next.printRevRec();
			System.out.print(this.data);
		}
	} 

	public static void main(String[] args) {
		Node root = new Node(1);
		int i=2;
		while (i<10){
			root.insert(i);
			i++;
		}
		root.printRec();
		System.out.println();
		root.printRevRec();
	}
}
