package emailApp;

import java.util.Scanner;

public class Email {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String companySuffix = "jbo";
    private int mailboxCapacity = 1000;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email created: " + this.firstName + " " + this.lastName
                + "\n");
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"
                + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.print("Enter the department\n 1 for Sales\n 2 for Development" +
                "\n 3 for Accounting\n 0 for none\n\nEnter department code:");
        Scanner in = new Scanner(System.in);

        int deptChoice = in.nextInt();
        if (deptChoice == 1) {
            return "sales";
        } else if (deptChoice == 2) {
            return "dev";
        } else if (deptChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789)(*&^%$#@!~{}[]\\|";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void getMailboxCapacity() {
        System.out.println("Mailbox capacity: " + this.mailboxCapacity);
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void getAlternateEmail() {
        System.out.println("Alternate email: " + this.alternateEmail);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getPassword() {
        System.out.println("Password: " + this.password);
    }

    public String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n" +
                "COMPANY EMAIL: " + this.email + "\n" +
                "MAILBOX CAPACITY: " + this.mailboxCapacity;
    }
}
