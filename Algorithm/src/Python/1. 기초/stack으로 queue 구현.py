class Node:
    def __init__(self, data):
        self.next = None
        self.data = data


# Linked list로 Stack 구현
class Stack:
    def __init__(self):
        self.head = None

    def push(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            new_node.next = self.head
            self.head = new_node

    def pop(self):
        if self.head:
            return_data = self.head.data
            self.head = self.head.next
            return return_data
        return self.head

    def peek(self):
        return self.head.data if self.head else None

    def is_empty(self):
        return True if not self.head else False


# Stack 2개로 Queue 구현
class Queue:
    def __init__(self):
        self.aStack = Stack()
        self.bStack = Stack()

    def enqueue(self, data):
        self.aStack.push(data)

    def dequeue(self):
        if self.bStack.is_empty():
            while not self.aStack.is_empty():
                self.bStack.push(self.aStack.pop())
        return self.bStack.pop()

    def is_empty(self):
        return True if self.aStack.is_empty() and self.bStack.is_empty() else False


if __name__ == "__main__":
    s = Stack()
    s.push(3)
    s.push(5)
    s.push(7)
    print(s.pop())
    print(s.peek())
    print(s.is_empty())
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.is_empty())
    print("-----------------")
    q = Queue()
    q.enqueue(3)
    q.enqueue(5)
    q.enqueue(7)
    print(q.dequeue())
    print(q.is_empty())
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q.is_empty())