package simple1;

class ListNode{
    int val;
    ListNode nextNode;
    ListNode(int val){
        this.val=val;
        this.nextNode=null;
    }
}

public class ListnodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input=new int[]{1,2,4,4,6};
        ListNode listNode=new ListNode(input[0]);
        ListNode curr=listNode;
        int i=1;
        while(i<input.length) {	 	//	´æ´¢listnode
        	listNode.nextNode=new ListNode(input[i]);
        	listNode=listNode.nextNode;
        	i++;
        }
        while(curr!=null){	//	±éÀúlistnode
            System.out.println("valvalue:"+curr.val+"/listNode"+curr.nextNode);
            curr=curr.nextNode;
        }
        
	}

}
