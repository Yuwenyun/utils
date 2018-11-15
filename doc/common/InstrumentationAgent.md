To get size of Object in Java, use **com.owen.common.InstrumentationAgent.java**
```
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Size of null: " + InstrumentationAgent.getSize(null));
        System.out.println("Size of String: " + InstrumentationAgent.getSize(""));
        System.out.println("Size of Integer: " + InstrumentationAgent.getSize(1));
        System.out.println("Size of Array:" + InstrumentationAgent.getSize(new int[12]));

        System.out.println("Size of Boolean:" + InstrumentationAgent.getSize(true));
        System.out.println("Size of Object:" + InstrumentationAgent.getSize(new App()));
        System.out.println("Size of Inner Object:" + InstrumentationAgent.getSize((new App()).new Employee()));

        System.out.println("Size of class Object:" + InstrumentationAgent.getSize(App.class));
        System.out.println("Size of Container:" + InstrumentationAgent.getSize(Arrays.asList("Alice", "Owen", "Janney")));
        Employee emp = new App().new Employee();
        emp.setAge(25);
        emp.setMale(true);
        System.out.println("Size of object: " + InstrumentationAgent.getSize(emp));
    }

    class Employee{
        private int age;
        private boolean male;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isMale() {
            return male;
        }

        public void setMale(boolean male) {
            this.male = male;
        }
    }
}
```
To make above code work, need to follow below steps.

1. add below configuration in MANIFEST.MF in **utils.jar**
```
Premain-class: com.owen.common.InstrumentationAgent
```
2. reference the jar in target project's pom.xml
```
...
<dependency>
  <groupId>...</groupId>
  <artifactId>utils</artifactId>
  <version>...</version>
</dependency>
...
<repositories>
  <repository>
    <id>my-local-repo</id>
    <url>file://path\to\utils\target</url>
  </repository>
</repositories>
```
3. configure the VM options for target project
```
-javaagent:"path\to\utils.jar"
```
