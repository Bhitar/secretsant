🎁 Secret Santa Assignment System
This Java-based application automates Secret Santa assignments for employees. It reads data from CSV files, ensures no repeat matches from the previous year, and optionally sends email notifications.

📦 Features
Import employee data from CSV

Avoids duplicate matches from previous years

Saves current year’s assignments

Extensible design for future enhancements

Email notification support

🛠 Installation
Clone the Repository

bash
Copy
Edit
git clone https://github.com/yourusername/secretsanta.git
cd secretsanta
Set Up Java Environment

Ensure you have Java 11 or higher installed. You can check with:

bash
Copy
Edit
java -version
Dependencies

Install required dependencies using Maven or include them manually:

Univocity CSV parser

JavaMail API

Any other dependency listed in pom.xml

To install via Maven:

bash
Copy
Edit
mvn clean install
🚀 Running the Program
1. Build the Project
If using Maven:

bash
Copy
Edit
mvn package
2. Run the Main Class
bash
Copy
Edit
java -cp target/secretsanta-1.0.jar secretsanta.Main
3. Required Files
employees.csv - A list of employees with names and emails.

assignments_last_year.csv - (Optional) Last year's assignments for avoiding duplicates.

📂 Project Structure
css
Copy
Edit
src/
├── model/
│   └── Employee.java
├── service/
│   └── CsvReaderService.java
│   └── AssignmentService.java
│   └── EmailService.java
└── Main.java
📄 Example CSV Format
employees.csv
csv
Copy
Edit
Name,Email
Alice,alice@example.com
Bob,bob@example.com
assignments_last_year.csv
csv
Copy
Edit
Giver,Receiver
Alice,Bob
Bob,Alice
📧 Email Setup
Update EmailService.java with your SMTP server settings:

java
Copy
Edit
String host = "smtp.example.com";
String from = "your_email@example.com";
String password = "your_password";
🧪 Running Tests
To run JUnit tests:

bash
Copy
Edit
mvn test
🔧 Common Issues
CSV Parsing Errors: Ensure headers are correct and no empty lines.

Access Errors: Avoid using internal or restricted Java classes like sun.nio.ch.DatagramChannelImpl.

Class Not Found: Check your classpath or dependency installation.

🙌 Contributing
Pull requests are welcome. For major changes, please open an issue first.

📃 License
MIT License


