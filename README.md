## Problem statement

You have following code part below which consist of several “if else” statements. You
need to optimize the code to support different data types in the future without
changing it one more time.

````java
public void processContract(String type) {
if ("electricity".equals(type)) {
System.out.println("Processed electricity");
} else if ("dsl".equals(type)) {
System.out.println("Processed dsl");
} else if ("appartment_rent".equals(type)) {
System.out.println("Processed appartment");
}
}
````
## Proposed solution

- Created a springboot application to expose an API endpoint ````/processType/{type}````
- It takes a type and print information on console based on the type.
- I have created an ```` Interface Action.java```` which contains a method  ````performAction()````.
- I created a static block in ````Service.java```` class to add _**type**_ as key and associated behavior as value in the ````HashMap<String, Action>````.
- Used java 8 lambda expression to define the method body as value in ````HashMap````.
- In ````processContract(String type)```` method we just get the value from ````HashMap```` and call ````performAction()```` method.
- Whenever we would require to support more types, we would not require to change ````processContract()```` method, we would just add entries in ````HashMap<String, Action>````.

## Steps to run the project
- Run ```mvn clean install``` to build the project.
- Run ````java -jar \target\optimized-0.0.1-SNAPSHOT.jaroptimized-0.0.1-SNAPSHOT.jar````
- Using postman or any other REST client invoke ````/processType/{type}```` endpoint.
- Result will be printed on the console.
