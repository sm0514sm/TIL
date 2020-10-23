class Stack:
    def __init__(self):
        self.queue = []

    def pop(self):
        return self.queue.pop() if not self.isempty() else None

    def push(self, arg):
        return self.queue.append(arg)

    def peek(self):
        return self.queue[-1]

    def isempty(self):
        return False if self.queue else True


if __name__ == "__main__":
    s = Stack()
    s.push(3)
    s.push(5)
    s.push(7)
    print(s.peek())
    print(s.pop())
    print(s.isempty())
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(s.isempty())