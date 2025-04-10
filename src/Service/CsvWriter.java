package Service;

import model.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

class CsvWriter {

    public void writeAssignmentsToCsv(String outputFilePath, Map<Employee, Employee> assignments) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.append("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n");
            for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
                Employee giver = entry.getKey();
                Employee receiver = entry.getValue();
                writer.append(giver.getName()).append(",")
                        .append(giver.getEmail()).append(",")
                        .append(receiver.getName()).append(",")
                        .append(receiver.getEmail()).append("\n");
            }
        }
    }
}










