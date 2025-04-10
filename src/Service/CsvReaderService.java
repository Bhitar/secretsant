package Service;

import model.Employee;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvReaderService {

    public List<Employee> readEmployees(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines.subList(1, lines.size())) { // skip header
            String[] tokens = line.split(",");
            if (tokens.length >= 2) {
                employees.add(new Employee(tokens[0].trim(), tokens[1].trim()));
            }
        }
        return employees;
    }

    public List<Assignment> readPreviousAssignments(String filePath) throws IOException {
        {
            Map<Employee, Employee> previousAssignments = new HashMap<>();
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines.subList(1, lines.size())) { // skip header
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    Employee giver = new Employee(tokens[0].trim(), tokens[1].trim());
                    Employee receiver = new Employee(tokens[2].trim(), tokens[3].trim());
                    previousAssignments.put(giver, receiver);
                }
            }
            return (List<Assignment>) previousAssignments;
        }
    }
}