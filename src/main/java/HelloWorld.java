public class HelloWorld {

    public static void main(String[] strs){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.sayHello("Friend"));

    }
    public String sayHello(String name){
        return "Hello " + name;
    }
}
