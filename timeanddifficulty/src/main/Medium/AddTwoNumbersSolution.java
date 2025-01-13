// Source: https://leetcode.com/problems/add-two-numbers/

import java.math.BigInteger;
public class AddTwoNumbersSolution {
    public static void main(String[] args) {    
        Solution2 a=new Solution2();
        ListNode first=new ListNode(9);
        ListNode second=new ListNode(1);
        ListNode secondhead=second;
        for(int apple=0; apple<3; apple++){
            second.next=new ListNode(9);
            second=second.next;
        }
        
        ListNode third=a.addTwoNumbers2(first, secondhead);
        while(third!=null){
            System.out.println(third);
            third=third.next;
        }
    }
  public static class ListNode {
      int val;
      ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      @Override
      public String toString(){
            return Integer.toString(val);
      }
  }
  public static class Solution2 {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode cur=head;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return head.next;    
    }

    }
    //o(l1) time+o(l2)time
  public static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder one=new StringBuilder(""+l1.val);
        StringBuilder two=new StringBuilder(""+l2.val);
        ListNode current=l1;
        ListNode current2=l2;
        int count=1;
        while(current.next!=null){
            current=current.next;
            one.append(current.val);
        }
        one.reverse();
        while(current2.next!=null){
            current2=current2.next;
            two.append(current2.val);
        }
        two.reverse();
        BigInteger three=new BigInteger(one.toString());
        BigInteger four=new BigInteger(two.toString());
        BigInteger sum=three.add(four);
        String answer=sum.toString();
        ListNode head=new ListNode(Integer.parseInt(answer.substring(answer.length()-1)));
        current=head;
        while(count<answer.length()){
            current.next=new ListNode(Integer.parseInt(answer.substring(answer.length()-count-1, answer.length()-count)));
            current=current.next;
            count++;
        }
        return head;
    }
  }
}
