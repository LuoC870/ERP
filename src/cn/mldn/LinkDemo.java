package cn.mldn;
interface ILink<E> { //设置泛型避免安全隐患
	public void add(E e) ;
	public int size() ;

}
class LinkImpl<E> implements ILink<E> {
	private class Node {	//保存节点的数据关系
		private E data ;	//保存数据
		public Node next ;	//保存下一个引用
		public Node(E data) { //有数据的情况下才有意义
			this.data = data ;
		}
		//第一次调用：this = LinkImpl.root;
		//第二次调用：this = LinkImpl.root.next ;
		//第三次调用：this = LinkImpl.root.next.next ;
		public void addNode(Node newNode) {	//保存新的Node数据
			if(this.next == null) {	//当前节点的下一个节点为null
				this.next = newNode ;	//保存当前节点
			}else {	//
				this.next.addNode(newNode);
			}
		}
	}
	//---------------以下为Link类中定义的成员---------------
	private Node root ;	//保存根元素
	private int count ; //保存数据的个数
	//---------------以下为Link类中定义的方法---------------
	public void add(E e) {
		if(e == null) {	//保存的数据为null
			return ; //方法调用直接结束
		}
		//数据本身不具备关联特性的，只有Node类有，想实现关联必须将数据包装在Node类中
		Node newNode = new Node(e) ; //创建一个新的节点
		if(this.root == null) {	//现在没有根节点
			this.root = newNode ;	//第一个节点作为根节点
		}else {	//根节点存在
			this.root.addNode(newNode); //将新节点保存在合适的位置
		}
		this.count ++ ;	//统计数据个数
	}
	public int size() {
		return this.count ;	//将统计后数据返回
	}
}
public class LinkDemo {
	public static void main(String args[]) {
		ILink<String> all = new LinkImpl<String> () ;
		System.out.println("【增加之前】数据个数：" + all.size());
		all.add("Hello");
		all.add("World");
		all.add("Mldn");
		System.out.println("【增加之后】数据个数：" + all.size());
	}
}
