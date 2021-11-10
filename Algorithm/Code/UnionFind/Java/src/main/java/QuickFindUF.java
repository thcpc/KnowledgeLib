public class QuickFindUF extends UF {

    public QuickFindUF(int n) {
        super(n);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if(pID == qID) return;
        for(int i = 0;i<id.length;i++){
            if(connected(i,p)) id[i] = qID;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }
}
