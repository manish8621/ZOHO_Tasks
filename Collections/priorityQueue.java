
/**
 * priorityQueue
 */
interface funnable {
}

class priorityQueues {
    public static void main(String[] args) {
        var pq = new PQ();
        var pq1 = new PQ1();
        pq.enqueue(671);
        pq1.enqueue(671);
        pq.enqueue(53);
        pq.enqueue(42);
        pq.enqueue(321);
        pq.enqueue(543);
        pq.enqueue(2);
        pq.PrintQueue();
        if(pq instanceof funnable)
        {
            System.out.println("pq is funnable");
        }
        if(pq1 instanceof funnable)
        {
            System.out.println("pq1 is funnable");
        }
    }
}

/**
 * priorityQueue
 */
class PQ implements funnable{
    int Max_Size = 10;
    int a[] = new int[Max_Size], length = 0;

    public void enqueue(int item) {
        // if queue is empty
        if (isEmpty())
            a[length++] = item;
        else {
            if (isFull())
                a = resize(5);
            addToQueue(item);
        }
    }
    public int dequeue() {
        int front = a[0];
        for(int i=0;i<length-1;i++)
            a[i]=a[i+1];
        length--;
        return front;

    }
    public void PrintQueue() {
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
    }

    private void addToQueue(int item) {
        int i = length - 1;
        while (i >= 0) {
            if (item >= a[i]) {
                a[i + 1] = item;
                break;
            } else
                a[i + 1] = a[i];
            i--;
        }
        // if no item is less than item then add it to the start
        a[0] = (i == -1) ? item : a[0];
        length++;
    }

    private boolean isFull() {
        return length == Max_Size;
    }

    private boolean isEmpty() {
        return (length == 0);
    }

    private int[] resize(int i) {
        Max_Size += i;
        int temp[] = new int[Max_Size];
        int j = 0;
        for (int k : a) {
            temp[j] = k;
            j++;
        }

        return temp;
    }

}
class PQ1{
    int Max_Size = 10;
    int a[] = new int[Max_Size], length = 0;

    public void enqueue(int item) {
        // if queue is empty
        if (isEmpty())
            a[length++] = item;
        else {
            if (isFull())
                a = resize(5);
            addToQueue(item);
        }
    }
    public int dequeue() {
        int front = a[0];
        for(int i=0;i<length-1;i++)
            a[i]=a[i+1];
        length--;
        return front;

    }
    public void PrintQueue() {
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
    }

    private void addToQueue(int item) {
        int i = length - 1;
        while (i >= 0) {
            if (item >= a[i]) {
                a[i + 1] = item;
                break;
            } else
                a[i + 1] = a[i];
            i--;
        }
        // if no item is less than item then add it to the start
        a[0] = (i == -1) ? item : a[0];
        length++;
    }

    private boolean isFull() {
        return length == Max_Size;
    }

    private boolean isEmpty() {
        return (length == 0);
    }

    private int[] resize(int i) {
        Max_Size += i;
        int temp[] = new int[Max_Size];
        int j = 0;
        for (int k : a) {
            temp[j] = k;
            j++;
        }

        return temp;
    }

}