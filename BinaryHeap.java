public class BinaryHeap {
    private int a[];
    private int Size =0;//tracks next available spot

    BinaryHeap(){
        a = new int[10];
    }

    void add(int pri){
        if(Size == a.length){
            growArr();
        }
        a[Size] = pri; //will insert at the next available spot
        Size++;
        int item = Size -1;//idex of inserted item (current item)
        while(item>0){
            int parent = (item-1)/2;
            if(a[item]<a[parent])
            {
                Swap(item,parent);
                item = parent;
            }
            else{
                return;
            }
        }
    }

    void ShiftDown(int index)
    {
        int child = index*2 +1;//left.node child. default smaller child
        if(child >= Size){
            return;
        }
        if(a[child+1]<a[child]) //compares children to see which is smaller
        {
            child = child+1;
        }
        if(a[index]>a[child])
        {
            Swap(index,child);
            ShiftDown(child);
        }
    }

    int remove()
    {
        if(Size==0){
            //throw Exception;
        }
        int pri = a[0];
        a[0] = a[Size-1];
        Size--;
        ShiftDown(0);
        return pri;
    }

    void Swap(int ind, int ch)
    {
        int temp = a[ind];
        a[ind] = a[ch];
        a[ch] = temp;

    }
    void growArr(){
        int temp[] = new int[Size*2];
        for(int i=0;i<a.length;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
}
