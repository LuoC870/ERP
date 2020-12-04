package cn.mldn;
interface ILink<E> { //���÷��ͱ��ⰲȫ����
	public void add(E e) ;

}
class LinkImpl<E> implements ILink<E> {
	private class Node {	//����ڵ�����ݹ�ϵ
		private E data ;	//��������
		public Node next ;	//������һ������
		public Node(E data) { //�����ݵ�����²�������
			this.data = data ;
		}
		//��һ�ε��ã�this = LinkImpl.root;
		//�ڶ��ε��ã�this = LinkImpl.root.next ;
		//�����ε��ã�this = LinkImpl.root.next.next ;
		public void addNode(Node newNode) {	//�����µ�Node����
			
		}
	}
	//---------------����ΪLink���ж���ĳ�Ա---------------
	private Node root ;
	//---------------����ΪLink���ж���ķ���---------------
	public void add(E e) {
		if(e == null) {	//���������Ϊnull
			return ; //��������ֱ�ӽ���
		}
		//���ݱ����߱��������Եģ�ֻ��Node���У���ʵ�ֹ������뽫���ݰ�װ��Node����
		Node newNode = new Node(e) ; //����һ���µĽڵ�
		if(this.root == null) {	//����û�и��ڵ�
			this.root = newNode ;	//��һ���ڵ���Ϊ���ڵ�
		}else {	//���ڵ����
			this.root.addNode(newNode); //���½ڵ㱣���ں��ʵ�λ��
		}
	}
}
public class LinkDemo {
	public static void main(String args[]) {
		System.out.println("Hello");
	}
}
