
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // --------------------------------------------------
        // 1단계: 원본 노드 바로 뒤에 복사본 노드 생성 및 끼워넣기
        // --------------------------------------------------
        Node curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next; // 다음 원본 노드 저장
            
            Node copy = new Node(curr.val);
            curr.next = copy;              // 원본 뒤에 복사본 연결
            copy.next = nextOriginal;      // 복사본 뒤에 다음 원본 연결
            
            curr = nextOriginal;           // 다음 원본 노드로 이동
        }

        // --------------------------------------------------
        // 2단계: 복사본 노드들의 random 포인터 연결
        // --------------------------------------------------
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // curr.next = 복사본 노드
                // curr.random.next = random 대상의 복사본 노드
                curr.next.random = curr.random.next;
            }
            // 다음 원본 노드로 이동 (2칸 이동)
            curr = curr.next.next;
        }

        // --------------------------------------------------
        // 3단계: 얽힌 리스트를 원본과 복사본으로 분리
        // --------------------------------------------------
        curr = head;
        Node clonedHead = head.next; // 복사본 리스트의 시작점
        
        while (curr != null) {
            Node copy = curr.next;
            Node nextOriginal = copy.next;
            
            // 원본 포인터 복원
            curr.next = nextOriginal;
            
            // 복사본 포인터 연결
            if (nextOriginal != null) {
                copy.next = nextOriginal.next;
            }
            
            curr = nextOriginal; // 다음 원본 노드로 이동
        }

        return clonedHead;
    }
}