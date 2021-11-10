public abstract class UF implements IUF {
    protected int[] id;
    protected int count;

    public UF(int n){
        count = n;
        id = new int[n];
        for(int i = 0;i<n;i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
