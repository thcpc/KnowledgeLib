import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class UfDataIterator implements Iterator<Object[]> {

    private int n;
    private int index;
    private BufferedReader bufferedReader;
    private String[] ufData;

    public UfDataIterator(int n, FileReader fileReader) throws IOException {
        this.n = n;
        bufferedReader = new BufferedReader(fileReader);
        ufData = new String[n];
        for(int i = 0; i<n;i++){
            ufData[i] = bufferedReader.readLine();
        }
    }

    public boolean hasNext() {
        return index<n;
    }

    public Object[] next() {
        return this.covert(ufData[index++]);
    }

    private Object[] covert(String txt){
        return Stream.of(txt.split("\\s+")).map((e)->{
            return Integer.valueOf(e);
        }).toArray();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
