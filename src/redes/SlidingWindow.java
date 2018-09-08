package redes;

import java.util.*;

public class SlidingWindow {
    private long size;
    private long ptr;
    public HashMap<Long, Boolean> packs;

    public SlidingWindow(int size) {
        this.size = size;
        this.ptr = 0;
        packs = new HashMap<>(size);
    }

    public void insert(long seq) {
        packs.put(seq, false);
        /*System.out.println("insert:");
        print();*/
    }

    public long getSize() {
        return size;
    }

    public long getPtr() {
        return ptr;
    }

    boolean canSend(long seq) throws InterruptedException {
        /*System.out.println("can:");
        print();
        System.out.println(seq+" "+" "+ ptr+" "+ size);*/
        Thread.sleep(10);
        return seq >= this.ptr && seq <= this.size+this.ptr-1;
    }

    void update(long seq) {
        packs.put(seq, true);
        /*print();
        System.out.println(seq+" "+" "+ ptr+" "+ size);*/
        while(packs.get(ptr)) {
            ptr++;
            if(ptr >= packs.size()) {
                break;
            }
        }
    }

    public HashMap<Long, Boolean> getPacks() {
        return packs;
    }

    public Collection<Boolean> getValues() {
        Collection<Boolean> string = packs.values();
        return string;
    }

    public void print() {
        HashMap<Long, Boolean> pc = this.packs;
        for(long i = 0; i< pc.size(); i++) {
            System.out.print(i+":"+pc.get(i)+" ");
        }
        System.out.println();

    }
}
