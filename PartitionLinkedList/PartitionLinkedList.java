public class PartitionLinkedList{


    public static ListNode partition(ListNode head, int x) {
        if(head == null){return null;}
        
        ListNode lessThanDummyHead = new ListNode(0);
        ListNode endOfLowers = lessThanDummyHead;
        ListNode greaterThanEqualDummyHead = new ListNode(0);
        ListNode endOfHighers = greaterThanEqualDummyHead;
        ListNode curr = head;
        while(curr!=null){
            int cval = curr.val;
            ListNode currCopy = new ListNode(cval);
            if(cval < x){
                endOfLowers.next = currCopy;
                endOfLowers = endOfLowers.next;
            } else {
                endOfHighers.next = currCopy;
                endOfHighers = endOfHighers.next;
            }
            curr = curr.next;
        }
        endOfLowers.next = greaterThanEqualDummyHead.next;
        return lessThanDummyHead.next;
    }


    public static void main(String[] args){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(2);
        
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        
        ListNode.printList(first);
        
        ListNode partitioned = partition(first,3);
        ListNode.printList(partitioned);
    
    }


}

