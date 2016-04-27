public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int i){val = i;}
    public static void printList(ListNode n){
        while(n!=null){
            System.out.print(n.val);
            if(n.next!=null){System.out.print("->");}
            n=n.next;
        }
        System.out.print("\n");
    }
}