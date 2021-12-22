var deleteDuplicates = function(head) {
    if (head == null || head.next == null) return head;
    var prev = head, curr = head.next, after = curr.next;
    while(curr != null){
        if(curr.val == prev.val){
            prev.next = curr.next;
            curr = curr.next;
        }
        else {
            var temp = curr;
            curr = curr.next;
            prev = temp;
        }
    }
    return head;
}
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
 }
function ListNode(val,prev){
    this.val = (val===undefined ? 0 : val)
    if(prev != null) prev.next = this;
};