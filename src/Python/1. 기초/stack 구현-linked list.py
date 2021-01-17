class Node:
    def __init__(self, data):
        self.next = None
        self.data = data


class Stack:
    def __init__(self):
        self.head = None

    def push(self, arg):
        newnode = Node(arg)
        if not self.head:
            self.head = newnode
        else:
            newnode.next = self.head
            self.head = newnode

    def pop(self):
        if not self.head:
            return None
        if not self.head.next:
            return self.head.data
        temp = self.head.data
        self.head = self.head.next
        return temp


    def peek(self):
        return self.head.data if self.head else None

    def isempty(self):
        return True if not self.head else False


if __name__ == "__main__":
    s = Stack()
    s.push(3)
    s.push(5)
    s.push(7)
    print(s.pop())
    print(s.peek())
    print(s.isempty())
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.isempty())