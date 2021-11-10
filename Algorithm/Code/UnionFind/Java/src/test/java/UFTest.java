import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;

public class UFTest {

    private static final int TINY = 10;
    private static final String STINY = "tiny";
    private static final String TINYPATH = "tinyUF.txt";
    private static final int MEDIUM = 625;
    private static final String SMEDIUM = "medium";
    private static final String MEDIUMPATH = "mediumUF.txt";
    private static final int LARGE = 1000000;
    private static final String SLARGE = "large";
    private static final String LARGEPATH = "largeUF.txt";


    @Test
    public void Test1QuickFind() {
        UF uf = new QuickFindUF(TINY);
        uf.union(3,4);
        Assert.assertTrue(uf.connected(3,4));
    }


    @Test(dataProvider = "tinyUF", groups = {SLARGE})
    public void TestQuickFind(int p, int q) {
        UF uf = new QuickFindUF(LARGE);
        uf.union(p,q);
        Assert.assertTrue(uf.connected(p,q));
    }

    @DataProvider
    public Iterator<Object[]> tinyUF(ITestNGMethod method) {
        try {
            switch (method.getGroups()[0]) {
                case STINY:
                    return new UfDataIterator(TINY, new FileReader(new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(TINYPATH)).getPath())));
                case SMEDIUM:
                    return new UfDataIterator(MEDIUM, new FileReader(new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(MEDIUMPATH)).getPath())));
                case SLARGE:
                    return new UfDataIterator(LARGE, new FileReader(new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(LARGEPATH)).getPath())));
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
