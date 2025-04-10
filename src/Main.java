import Service.AssignmentService;
import Service.CsvReaderService;
import Service.EmailService;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriterSettings;
import model.Employee;

import javax.jms.JMSException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar secret-santa.jar <employees.csv> <previous_assignments.csv> <output.csv>");
            System.exit(1);
        }

        String employeesFile = args[0];
        String previousAssignmentsFile = args[1];
        String outputFile = args[2];

        try {
            CsvReaderService readerService = new CsvReaderService();
            List<Employee> employees = readerService.readEmployees(employeesFile);
            readerService.readPreviousAssignments(previousAssignmentsFile);

            AssignmentService assignmentService = new AssignmentService();
            assignmentService.assignSecretChildren(employees);

            List<String[]> rows = new ArrayList<>();
            rows.add(new String[]{"Name", "Email"}); // header

            Employee[] employeeList = new Employee[0];
            for (Employee e : employeeList) {
                rows.add(new String[]{e.getName(), e.getEmail()});
            }
            CsvWriterSettings settings = new CsvWriterSettings();
            settings.setHeaders("Name", "Email"); // Optional

             var writer = new CsvWriter(new FileWriter("output.csv"), settings); {
                writer.writeHeaders();

                for (Employee emp : employees) {
                    writer.writeRow(emp.toStringArray());
                }


                EmailService emailService;
                String e = "";
                emailService = new EmailService(e);
                for (Employee u : employees) {
                    emailService.sendAssignmentEmail();
                }

                System.out.println("Secret Santa assignments completed and emails sent!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (EmailService.MessagingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
