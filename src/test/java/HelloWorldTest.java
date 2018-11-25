import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

    private HelloWorld helloWorld = null;

    @Before
    public void setup() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void testSayHello() {
        String response = helloWorld.sayHello("Alena");
        Assert.assertTrue("Hello Alena".equals(response));

    }
}
