package cn.sxt.collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
/*
 * 
 * 
 * 	����list
 * 	����Collection�ӿ��еķ���
 */
public class TestList {
	public static void main(String[] args) {
		//test02();
		test03();
	}
	//list��ط���1
	public static void test01() {

	Collection<String> collection = new ArrayList<>();	
		System.out.println(collection.size());
		//����Ƿ�Ϊ��
		System.out.println(collection.isEmpty());
		
		collection.add("hhw1");
		collection.add("hhw2");
		//print
		System.out.println(collection);
		//����
		System.out.println(collection.size());
		//�����Ƿ����ĳ��Ԫ��
		System.out.println("�Ƿ����ĳ��Ԫ��(����true or false) "+collection.contains("hhw1"));
		
		//�Ƴ� ����ɾ�� ����û�б�ɾ��
		collection.remove("hhw1");
		System.out.println(collection);
		//�Ƴ�����Ԫ��
		collection.clear();
	}
	//list��ط���2  ���List֮��Ĳ���
	public static void test02() {

		List<String> l1 = new ArrayList<>();
		l1.add("aa");
		l1.add("bb");
		l1.add("cc");
		List<String> l2 = new ArrayList<>();
		l2.add("aa");
		l2.add("dd");
		l2.add("ee");
		
		System.out.println("list01 "+l1);
		
		//l1.addAll(l2);//��l1�����l2�е�Ԫ��
		//l1.removeAll(l2);//ɾ����l2�ظ���Ԫ��
		l1.retainAll(l2);
		System.out.println("list01 "+l1);
		//���01�����Ƿ������02����������
		System.out.println(l1.containsAll(l2));
		
	}
	//List��ط���3 �й�List��3��ʵ����
	public static void test03() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		
		list.add(2,"hhw"); //2Ϊλ�ã�����
		System.out.println(list);
		
		list.remove(2); //�Ƴ�
		System.out.println(list);
		
		list.set(2, "��Ŷ��");//���� ����ԭ��ֵ
		System.out.println(list);
		
		System.out.println(list.get(2));//��ȡλ��Ϊ2������
		
		list.add("C");
		list.add("B");
		list.add("A");
		System.out.println(list);
		
		System.out.println(list.indexOf("B"));//����Ԫ�أ���һ�γ��ֵ�λ�ã�
		System.out.println(list.lastIndexOf("B")); //����Ԫ�أ����һ�γ��ֵ�λ�ã�
		
	}
	//Vectorʵ��
	public void test04() {
		List<String> list2 = new Vector<>();
	}
	
}
