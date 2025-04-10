package test;

import Service.CsvReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderServiceTest {

    private CsvReaderService csvReaderService;

    @BeforeEach
    public void setup() {
        csvReaderService = new CsvReaderService();
    }

    @Test
    public void testReadEmployeesFromValidCsv() throws IOException {
        String content = "Employee_Name,Employee_EmailID\n" +
                "Alice,alice@example.com\n" +
                "Bob,bob@example.com";

        Path tempFile = Files.createTempFile("employees", ".csv");
        Files.write(tempFile, content.getBytes());

        List<Employee> employees = csvReaderService.readEmployees(tempFile.toString());

        assertEquals(2, employees.size());
        assertEquals("Alice", employees.get(0).getName());
        assertEquals("bob@example.com", employees.get(1).getEmail());

        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testReadPreviousAssignmentsFromValidCsv() throws IOException {
        String content = "Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n" +
                "Alice,alice@example.com,Bob,bob@example.com";

        Path tempFile = Files.createTempFile("assignments", ".csv");
        Files.write(tempFile, content.getBytes());

        var previousMap = csvReaderService.readPreviousAssignments(tempFile.toString());

        assertEquals(1, previousMap.size());

        Employee alice = new Employee("Alice", "alice@example.com");
        Employee bob = new Employee("Bob", "bob@example.com");

        assertTrue(previousMap.contains(alice));
        assertEquals(bob,alice);


        Files.deleteIfExists(tempFile);
    }
}