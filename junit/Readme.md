
# JUnit 5 - Getting Started

## Overview

JUnit 5 is the latest version of the popular testing framework for Java. It provides a robust platform for writing unit tests and introduces several improvements over JUnit 4. The architecture of JUnit 5 is modular, making it flexible and extensible, with better support for Java 8 and beyond.

This README will cover:

- **JUnit 5 Architecture**
- **Setting Up JUnit 5**
- **Key Annotations**
- **Assertions**
- **Writing Unit Test Cases**
- **AAA Structure for Writing Effective Test Cases**

---

## 1. JUnit 5 Architecture

JUnit 5 is composed of three main modules:

### 1.1. **JUnit Platform**
The foundation for launching testing frameworks. It defines the Test Engine API for developing new testing frameworks and offers a platform for discovery and execution of tests.

- **Test Discovery**: Locates test classes and test methods.
- **Test Execution**: Executes the tests and handles the results.

### 1.2. **JUnit Jupiter**
This is the main library for writing tests in JUnit 5. It includes the new annotations and extensions for writing tests and allows backward compatibility with JUnit 4 through the `junit-vintage-engine`.

- **Test Engine**: Provides a test engine to run JUnit 5 tests.
- **Annotations**: New annotations such as `@Test`, `@BeforeEach`, `@AfterEach`, and more.

### 1.3. **JUnit Vintage**
JUnit Vintage provides backward compatibility to run JUnit 3 and JUnit 4 tests within JUnit 5.

---

## 2. Setting Up JUnit 5

To start using JUnit 5 in your project, you simply need to add the necessary dependencies.

### 2.1. Using **Maven**:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.3</version>
    <scope>test</scope>
</dependency>
```

### 2.2. Using **Gradle**:

```gradle
testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.11.2'
```

Once the dependencies are added, you're ready to write and run tests in JUnit 5.

---

## 3. Important Annotations in JUnit 5

JUnit 5 introduces new annotations to provide more control over the testing lifecycle. Here are some of the most important ones:

### 3.1. **@Test**
Marks a method as a test method. This is the main annotation used to define test cases.

```java
@Test
void myFirstTest() {
    assertEquals(2, 1 + 1);
}
```

### 3.2. **@BeforeEach**
Executed before each test method in the current test class. Use this annotation to set up the test data or configurations.

```java
@BeforeEach
void setUp() {
    // Initialize resources
}
```

### 3.3. **@AfterEach**
Executed after each test method. Typically used to clean up resources.

```java
@AfterEach
void tearDown() {
    // Clean up resources
}
```

### 3.4. **@BeforeAll**
Executed once before all test methods in the test class. Useful for setting up static resources like database connections or external services.

```java
@BeforeAll
static void initAll() {
    // Initialize database connection
}
```

### 3.5. **@AfterAll**
Executed once after all test methods in the test class. Used to release static resources.

```java
@AfterAll
static void tearDownAll() {
    // Close database connection
}
```

### 3.6. **@Disabled**
Disables a test method or class temporarily.

```java
@Disabled("Feature not yet implemented")
void testThisLater() {
    // Test code here
}
```

---

## 4. Assertions in JUnit 5

Assertions are methods that allow you to validate the expected outcomes of your test cases. JUnit 5 provides several assertion methods to compare actual results with expected values.

### 4.1. **assertEquals()**
Checks if two values are equal.

```java
assertEquals(5, 2 + 3);
```

### 4.2. **assertNotEquals()**
Checks if two values are not equal.

```java
assertNotEquals(4, 2 + 3);
```

### 4.3. **assertTrue() / assertFalse()**
Checks if a condition is `true` or `false`.

```java
assertTrue(5 > 2);
assertFalse(3 > 5);
```

### 4.4. **assertThrows()**
Checks if a specific exception is thrown during execution.

```java
assertThrows(IllegalArgumentException.class, () -> {
    throw new IllegalArgumentException("Invalid argument");
});
```

### 4.5. **assertAll()**
Allows grouping multiple assertions together. All assertions within an `assertAll()` block will be executed even if some fail.

```java
assertAll(
    () -> assertEquals(5, 2 + 3),
    () -> assertTrue(10 > 1)
);
```

---

## 5. Writing Unit Test Cases

### 5.1. Basic Structure

A typical unit test class in JUnit 5 has the following structure:

```java
import org.junit.jupiter.api.*;

public class MyTestClass {

    @BeforeAll
    static void setUpBeforeClass() {
        // Code executed once before all test methods
    }

    @BeforeEach
    void setUp() {
        // Code executed before each test method
    }

    @Test
    void testMethod1() {
        // Test code
    }

    @Test
    void testMethod2() {
        // Test code
    }

    @AfterEach
    void tearDown() {
        // Code executed after each test method
    }

    @AfterAll
    static void tearDownAfterClass() {
        // Code executed once after all test methods
    }
}
```

### 5.2. Naming Conventions

- **Test class name**: `ClassNameTest` (e.g., `CalculatorTest`)
- **Test method name**: Should describe the behavior being tested (e.g., `shouldAddTwoNumbers`)

---

## 6. AAA Structure for Writing Effective Tests

The **AAA** (Arrange, Act, Assert) structure is a widely-used pattern for writing clean and organized test cases. It helps maintain clarity and purpose in tests by dividing them into three distinct sections:

### 6.1. **Arrange**
Prepare the necessary objects and data.

```java
Calculator calculator = new Calculator();
int a = 5;
int b = 10;
```

### 6.2. **Act**
Perform the action or method you want to test.

```java
int result = calculator.add(a, b);
```

### 6.3. **Assert**
Verify that the outcome matches the expected result.

```java
assertEquals(15, result);
```

### Example of a test using AAA:

```java
@Test
void shouldAddTwoNumbers() {
    // Arrange
    Calculator calculator = new Calculator();
    int a = 5;
    int b = 10;

    // Act
    int result = calculator.add(a, b);

    // Assert
    assertEquals(15, result);
}
```

This structure makes your tests easier to read and maintain, ensuring that each test clearly defines what is being tested and why.

---
## Conclusion

JUnit 5 provides a powerful and flexible testing framework that improves upon JUnit 4's features. By using its modular architecture, new annotations, and assertions, you can write effective unit tests. Organizing your tests with the **AAA** structure ensures clarity and readability, making your test code easy to maintain.

Happy testing 😀
