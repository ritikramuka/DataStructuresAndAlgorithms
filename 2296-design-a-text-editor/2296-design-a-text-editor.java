class TextEditor {
    class Node {
        char ch;
        Node next;
        Node prev;

        Node (char ch) {
            this.ch = ch;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    Node cursor;

    public void addChar(char ch) {
        Node node = new Node(ch);
        Node prev = cursor.prev;
        prev.next = node;
        node.prev = prev;
        node.next = cursor;
        cursor.prev = node;
    }

    public boolean deleteChar() {
        if (cursor.prev == head) {
            return false;
        } else {
            Node deleteNode = cursor.prev;
            cursor.prev = deleteNode.prev;
            deleteNode.prev.next = cursor;
            deleteNode.prev = null;
            deleteNode.next = null;

            return true;
        }
    }

    public boolean moveLeft() {
        if (cursor.prev == head) {
            return false;
        } else {
            Node prevNode = cursor.prev;
            cursor.prev = prevNode.prev;
            prevNode.prev.next = cursor;
            prevNode.prev = cursor;
            prevNode.next = cursor.next;
            cursor.next = prevNode;

            return true;
        }
    }

    public String getLeftString() {
        StringBuilder ans = new StringBuilder("");
        
        Node temp = cursor.prev;
        while (ans.length() < 10 && temp != head) {
            ans.append(temp.ch);
            temp = temp.prev;
        }

        return ans.toString();
    }

    public boolean moveRight() {
        if (cursor.next == tail) {
            return false;
        } else {
            Node nextNode = cursor.next;
            nextNode.prev = cursor.prev;
            cursor.prev.next = nextNode;
            cursor.prev = nextNode;
            cursor.next = nextNode.next;
            nextNode.next = cursor;

            return true;
        }
    }

    public TextEditor() {
        head = new Node('$');
        tail = new Node('$');
        cursor = new Node('|');

        head.next = cursor;
        cursor.prev = head;

        cursor.next = tail;
        tail.prev = cursor;
    }
    
    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            addChar(ch);
        }
    }
    
    public int deleteText(int k) {
        int t = k;
        while (t > 0) {
            boolean isDone = deleteChar();
            if (isDone == false) {
                break;
            }
            t--;
        }  

        return k - t;
    }
    
    public String cursorLeft(int k) {
        int t = k;
        while (t > 0) {
            boolean isDone = moveLeft();
            if (isDone == false) {
                break;
            } 
            t--;
        }

        StringBuilder sb = new StringBuilder(getLeftString());
        return sb.reverse().toString();
    }
    
    public String cursorRight(int k) {
        int t = k;
        while (t > 0) {
            boolean isDone = moveRight();
            if (isDone == false) {
                break;
            }
            t--;
        }

        StringBuilder sb = new StringBuilder(getLeftString());
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */