# Spring Dependency Injection Demo

This project demonstrates Spring Framework's Dependency Injection capabilities using both Constructor Injection and Setter Injection with XML and Annotation-based configurations.

## Project Overview

This training application automates student information management in a Spring application, showcasing two primary DI patterns:
- **Constructor Injection**: Values are injected through the constructor
- **Setter Injection**: Values are injected through setter methods

## Project Structure

```
spring-di-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── model/
│   │   │       │   └── Student.java           # POJO class with constructor & setters
│   │   │       ├── config/
│   │   │       │   └── StudentConfig.java     # Annotation-based configuration
│   │   │       ├── XMLConfigMain.java         # XML configuration main class
│   │   │       └── AnnotationConfigMain.java  # Annotation configuration main class
│   │   └── resources/
│   │       └── applicationContext.xml         # Spring XML configuration
│   └── test/
├── pom.xml                                    # Maven configuration
└── README.md                                  # This file
```

## Key Components

### 1. Student POJO Class (`com.example.model.Student`)
- **Fields**: studentId, name, course, year
- **Constructors**: Default constructor and parameterized constructor
- **Methods**: Getters and Setters for all fields
- **Features**: Constructor Injection and Setter Injection support

### 2. XML Configuration (`applicationContext.xml`)
Demonstrates three injection approaches:
- **Constructor Injection**: Using `<constructor-arg>` tags
- **Setter Injection**: Using `<property>` tags
- **Mixed Injection**: Combining both approaches

### 3. Annotation-Based Configuration (`StudentConfig.java`)
Java configuration class with `@Configuration` and `@Bean` annotations demonstrating:
- Constructor Injection via bean creation
- Setter Injection via property setting
- Mixed Injection approach

### 4. Main Classes
- **XMLConfigMain.java**: Loads Spring container from XML configuration
- **AnnotationConfigMain.java**: Loads Spring container from Java configuration

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Framework 5.3.x
- Basic knowledge of Java and Spring Framework

## Dependencies

```xml
- spring-core (5.3.20)
- spring-context (5.3.20)
- slf4j-api (1.7.36)
- logback-classic (1.2.11)
```

## How to Run

### 1. Compile the Project
```bash
mvn clean compile
```

### 2. Run XML Configuration Example
```bash
mvn exec:java -Dexec.mainClass="com.example.XMLConfigMain"
```

### 3. Run Annotation Configuration Example
```bash
mvn exec:java -Dexec.mainClass="com.example.AnnotationConfigMain"
```

### 4. Package the Project
```bash
mvn package
```

## Example Output

### XML Configuration Output
```
========== XML Configuration - Spring Dependency Injection ==========

Student object created using default constructor
Student object created using parameterized constructor
Student object created using parameterized constructor

========== Constructor Injection ==========
Retrieved Student (Constructor Injection):
Student{studentId=101, name='Aman Kumar', course='B.Tech Computer Science', year=2}

========== Setter Injection ==========
Retrieved Student (Setter Injection):
Student{studentId=102, name='Priya Singh', course='B.Tech Information Technology', year=3}
```

### Annotation Configuration Output
```
========== Annotation Configuration - Spring Dependency Injection ==========

Creating student bean using annotation-based constructor injection
Student object created using parameterized constructor
Creating student bean using annotation-based setter injection
Student object created using default constructor
Creating student bean using annotation-based mixed injection
Student object created using parameterized constructor

========== Constructor Injection (Annotation-Based) ==========
Retrieved Student (Constructor Injection):
Student{studentId=201, name='Neha Verma', course='B.Tech Mechanical Engineering', year=1}
```

## Concepts Demonstrated

### Constructor Injection
- Dependencies are provided through the constructor
- Immutability: Objects are immutable after creation
- All required dependencies must be provided during instantiation
- Better for mandatory dependencies

**XML Example:**
```xml
<bean id="studentConstructor" class="com.example.model.Student">
    <constructor-arg name="studentId" value="101"/>
    <constructor-arg name="name" value="Aman Kumar"/>
    <constructor-arg name="course" value="B.Tech Computer Science"/>
    <constructor-arg name="year" value="2"/>
</bean>
```

### Setter Injection
- Dependencies are provided through setter methods
- Flexibility: Optional dependencies can be set
- Objects can be modified after creation
- Better for optional dependencies

**XML Example:**
```xml
<bean id="studentSetter" class="com.example.model.Student">
    <property name="studentId" value="102"/>
    <property name="name" value="Priya Singh"/>
    <property name="course" value="B.Tech Information Technology"/>
    <property name="year" value="3"/>
</bean>
```

### Annotation-Based Configuration
Uses Java configuration class instead of XML:
```java
@Configuration
public class StudentConfig {
    @Bean
    public Student studentAnnotationConstructor() {
        return new Student(201, "Neha Verma", "B.Tech Mechanical Engineering", 1);
    }
}
```

## Learning Outcomes

1. Understanding Spring's Inversion of Control (IoC) container
2. Difference between Constructor and Setter Injection
3. XML-based Spring configuration
4. Java-based (Annotation) Spring configuration
5. Bean lifecycle and container management
6. Practical application of DI in real-world scenarios

## Best Practices

1. **Use Constructor Injection** for required dependencies
2. **Use Setter Injection** for optional dependencies
3. **Prefer Annotation-based configuration** for modern applications
4. **Keep Spring XML configuration** separate from business logic
5. **Use meaningful bean IDs** for easy identification
6. **Close the application context** to release resources

## Troubleshooting

### Issue: "No bean named 'studentConstructor' found"
- Ensure the bean name matches between configuration and retrieval
- Check if the XML file is in the classpath (src/main/resources)

### Issue: ClassNotFoundException for Student
- Verify package structure is correct
- Ensure Maven build includes src/main/java directory

### Issue: Spring context not loading
- Check Spring dependency versions in pom.xml
- Verify XML/Java configuration syntax

## Technology Stack

- **Language**: Java 11
- **Framework**: Spring Framework 5.3.20
- **Build Tool**: Maven 3.x
- **Logging**: SLF4J with Logback

## Author Notes

This project serves as a complete demonstration of Spring's Dependency Injection mechanism, suitable for:
- Spring framework beginners
- Training and educational purposes
- Understanding IoC containers
- Comparing XML vs Annotation-based configurations

## License

This project is provided for educational purposes.

## Contact

For queries or improvements, please raise an issue or create a pull request.
