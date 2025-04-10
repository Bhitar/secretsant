package Service;

import model.Employee;

import java.util.*;

public class AssignmentService {

    public Map<Employee, Employee> assignSecretSantas(List<Employee> employees, Map<Employee, Employee> lastYearAssignments) throws Exception {
        if (employees.size() < 2) {
            throw new Exception("Not enough participants for Secret Santa.");
        }

        Map<Employee, Employee> result = new HashMap<>();
        List<Employee> givers = new ArrayList<>(employees);
        List<Employee> receivers = new ArrayList<>(employees);

        Random random = new Random();
        int attempts = 0;
        final int MAX_ATTEMPTS = 1000;

        while (attempts < MAX_ATTEMPTS) {
            Collections.shuffle(receivers, random);
            boolean valid = true;
            result.clear();

            for (int i = 0; i < givers.size(); i++) {
                Employee giver = givers.get(i);
                Employee receiver = receivers.get(i);

                if (giver.equals(receiver) ||
                        (lastYearAssignments.containsKey(giver) && lastYearAssignments.get(giver).equals(receiver))) {
                    valid = false;
                    break;
                }
                result.put(giver, receiver);
            }

            if (valid) {
                return result;
            }
            attempts++;
        }

        throw new Exception("Unable to generate valid assignments after " + MAX_ATTEMPTS + " attempts.");
    }


    public void assignSecretChildren(List<Employee> employees) {
    }
}