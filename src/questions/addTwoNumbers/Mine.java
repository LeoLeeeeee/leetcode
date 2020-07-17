package questions.addTwoNumbers;

public class Mine {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        ListNode ans = new ListNode(0);
        ListNode ansTemp = ans;
        boolean isOver = false;
        while (l1Temp != null || l2Temp != null){
            if (isOver)
                ansTemp.val++;
            int x = (l1Temp != null) ? l1Temp.val: 0;
            int y = (l2Temp != null) ? l2Temp.val: 0;

            if ( x + y + ansTemp.val >= 10){
                ansTemp.val += x + y - 10;
                isOver = true;
            } else {
                ansTemp.val += x + y;
                isOver = false;
            }
            l1Temp = (l1Temp != null) ? l1Temp.next: null;
            l2Temp = (l2Temp != null) ? l2Temp.next: null;

            if (!(l1Temp == null && l2Temp == null)){
                ansTemp.next = new ListNode(0);
                ansTemp = ansTemp.next;
            }
        }
        if (isOver){
            ansTemp.next = new ListNode(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.print();
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        b.print();
        addTwoNumbers(a, b).print();

        addTwoNumbers(new ListNode(5), new ListNode(5)).print();
    }
}
