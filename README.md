## Goal: I need to use jackson-databind version 2.7.9. Databricks platform provides 2.6.5


## Steps

* Clone this repository
* From the project directory:
  * `$ sbt assembly`
  * `$ sbt run` . This should print the following in the terminal:
  
  ```
  {"name":"fred","age":25}
  
  Person(fred,25)
  
  com.fasterxml.jackson.databind.PropertyNamingStrategy$UpperCamelCaseStrategy@5ddd185e
  
  Hello World
  
 ```
* Upload the jar `./target/scala-2.11/shade-jackson-databind-1.0.jar` to Databricks and attach it to your cluster
* Create a notebook, attach it to the cluster containing the jar and run the following command:


```scala
import com.databricks.support.shade.jackson.databind.Test
Test.run
Test.testCantChangeThis // this works.
```

## Notes:
`jackson-databind` has compile time dependencies on:

* com.fasterxml.jackson.core » jackson-annotations
* com.fasterxml.jackson.core » jackson-core

`jackson-module-scala` has compile time dependencies on:
* com.fasterxml.jackson.core » jackson-core
* com.fasterxml.jackson.core » jackson-annotations
* com.fasterxml.jackson.core » jackson-databind
* com.fasterxml.jackson.module » jackson-module-paranamer
* org.scala-lang » scala-library	
* org.scala-lang » scala-reflect


