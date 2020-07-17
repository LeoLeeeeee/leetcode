package questions.addTwoNumbers;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    void print(){
        System.out.print(val);
        if (this.next != null){
            System.out.print(" -> ");
            this.next.print();
        } else
            System.out.println();

    }
}
