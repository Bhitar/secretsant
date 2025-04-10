package test;

import Service.AssignmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssignmentServiceTest {

    private AssignmentService assignmentService;
    private List<Employee> employees;

    @BeforeEach
    public void setup() {
        assignmentService = new AssignmentService();
        employees = Arrays.asList(
                new Employee("Alice", "alice@example.com"),
                new Employee("Bob", "bob@example.com"),
                new Employee("Carol", "carol@example.com"),
                new Employee("David", "david@example.com")
        );
    }

    @Test
    public void testAssignmentsAreValidAndUnique() {
        Map<Employee, Employee> assignments = null;
        try {
            assignments = assignmentService.assignSecretSantas(employees, Collections.emptyMap());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(employees.size(), assignments.size(), "Each employee should be assigned exactly one secret child");

        Set<Employee> receivers = new HashSet<>(assignments.values());
        assertEquals(employees.size(), receivers.size(), "Each secret child should be unique");

        for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
            assertNotEquals(entry.getKey(), entry.getValue(), "Employee should not be assigned to themselves");
        }
    }

    @Test
    public void testAssignmentsAvoidPreviousYearDuplicates() throws Exception {
        Map<Employee, Employee> previousAssignments = new HashMap<>();
        previousAssignments.put(employees.get(0), employees.get(1));

        for (int i = 0; i < 10; i++) {
            Map<Employee, Employee> newAssignments = assignmentService.assignSecretSantas(employees, previousAssignments);
            assertNotEquals(employees.get(0), previousAssignments.get(employees.get(0)),
                    "Employee should not be assigned the same secret child as last year");
        }
    }
}