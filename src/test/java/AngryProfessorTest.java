import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AngryProfessorTest {

    private int k;
    private int[] students;
    private String classCanceled;

    public AngryProfessorTest(int k, int[] students, String classCanceled) {
        this.k = k;
        this.students = students;
        this.classCanceled = classCanceled;
    }

    @Parameterized.Parameters(name = "{index}: angryProfessor({0}, {1}) = {2}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {3, new int[]{-1, -3, 4, 2}, "YES"},
                {2, new int[]{-1, -3, 4, 2}, "NO"}
        });
    }

    @Test
    public void angryProfessor() {
        String result = AngryProfessor.angryProfessor(this.k, this.students);
        Assert.assertEquals(this.classCanceled, result);
    }
}