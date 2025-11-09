
import java.util.Scanner;

class Worker {

    String name;
    int age;
    String dateOfBirth;
    String id;
    String password;

    Worker(String name, int age, String dateOfBirth, String id, String password) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.password = password;

    }

    Boolean verifyId(String idInput, Worker[] w, int noOfWorkers) {
        for (int i = 0; i < noOfWorkers; i++) {
            if ((w[i].id).equals(idInput)) {
                return true;
            }
        }
        return false;
    }

    Boolean verifyPassword(String passwordInput, Worker[] w, int noOfWorkers) {
        for (int i = 0; i < noOfWorkers; i++) {
            if ((w[i].password).equals(passwordInput)) {
                return true;
            }
        }
        return false;
    }

    int getAccountNumber(String idInput, Worker[] w, int noOfWorkers) {
        for (int i = 0; i < noOfWorkers; i++) {
            if ((w[i].id).equals(idInput)) {
                return i;
            }
        }
        return -1;
    }
}

class Member {

    String name;
    int age;
    String dateOfBirth;
    String id;
    String password;
    int booksBorrowed;

    Member() {
    }

    Member(String name, int age, String dateOfBirth, String id, String password) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.password = password;
    }

    void addMember(Member[] m, int noOfMembers) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n==============================");
            System.out.println("   Enter Member Information   ");
            System.out.println("==============================");
            System.out.print("Enter name of the Member: ");
            String memberName = sc.nextLine();
            System.out.print("Enter Age of the Member: ");
            int memberAge = sc.nextInt();
            System.out.print("Enter Date of Birth (dd/mm/yyyy): ");
            String memberDOB = sc.next();
            System.out.print("Enter Member ID: ");
            String memberId = sc.next();
            System.out.print("Enter password: ");
            String memberPassword = sc.next();
            m[noOfMembers] = new Member(memberName, memberAge, memberDOB, memberId, memberPassword);
            System.out.println("\n----------------------------------------");
            System.out.println("Member Added Successfully!");
            System.out.println("----------------------------------------\n");
        }
    }

    void removeMember(Member[] m, String id1) {
        boolean found = false;
        for (int i = 0; i < (m.length); i++) {
            if (m[i] != null && m[i].id.equals(id1)) {
                found = true;
                for (int j = i; j < (m.length - 1); j++) {
                    m[j] = m[j + 1];
                }
                m[(m.length - 1)] = null;
                System.out.println("------Member Is Removed Sucessfully------");
                break;
            }
        }
        if (!found) {
            System.out.println("No such record Found");
        }
    }

    void display() {
        System.out.println("----Member Details----");
        System.out.println("Name of the Member :- " + this.name);
        System.out.println("Age of the Member :- " + this.age);
        System.out.println("Date of Birth of the Member :- " + this.dateOfBirth);
        System.out.println("ID of Member Account :- " + this.id);
    }

    Boolean verifyId(String idInput, Member[] m, int noOfMembers) {
        for (int i = 0; i < noOfMembers; i++) {
            if ((m[i].id).equals(idInput)) {
                return true;
            }
        }
        return false;
    }

    Boolean verifyPassword(String passwordInput, Member[] m, int noOfMembers) {
        for (int i = 0; i < noOfMembers; i++) {
            if ((m[i].password).equals(passwordInput)) {
                return true;
            }
        }
        return false;
    }

    int getAccountNumber(String idInput, Member[] m, int noOfMembers) {
        for (int i = 0; i < noOfMembers; i++) {
            if ((m[i].id).equals(idInput)) {
                return i;
            }
        }
        return -1;
    }
}

class Book {

    String title;
    String author;
    String ISBN;
    int available_copies;

    Book() {
    }

    Book(String title, String author, String ISBN, int available_copies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available_copies = available_copies;
    }

    void addBook(String title, String author, String ISBN, int available_copies, int noOfBooks) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available_copies = available_copies;
        System.out.println("----Book added Succesfully----");
        noOfBooks++;
    }

    void searchBook(String book_name, Book[] b, int noOfBooks) {
        boolean chck = false;
        for (int i = 0; i < noOfBooks; i++) {
            if (b[i].title.equals(book_name)) {
                if (b[i].available_copies > 0) {
                    System.out.println("Yes Book is available");
                } else {
                    System.out.println("Required book is out of stock ");
                }
                chck = true;
                break;
            } else {
            }
        }
        if (chck == false) {
            System.out.println("Required book is not available in Library");
        }
    }

    void borrowBook(String bookName, Book[] b, int noOfBooks, Member[] m, int i1) {
        boolean chck = false;
        for (int i = 0; i < noOfBooks; i++) {
            if (b[i].title.equals(bookName)) {
                if (b[i].available_copies > 0) {
                    if (m[i1].booksBorrowed <= 10) {
                        System.out.println("Book is added to the account");
                        m[i1].booksBorrowed++;
                        b[i].available_copies--;
                    } else {
                        System.out.println("Your Account Vacancy for book is full");
                    }
                } else {
                    System.out.println("Required book is out of stock ");
                }
                chck = true;
                break;
            } else {
            }
        }
        if (chck == false) {
            System.out.println("Required book is not available in Library");
        }
    }

    void returnBook(String bookName, Book[] b, int noOfBooks, Member[] m, int i1) {
        boolean chck = false;
        for (int i = 0; i < noOfBooks; i++) {
            if (b[i].title.equals(bookName)) {
                chck = true;
                System.out.println("Book is removed from account account");
                m[i1].booksBorrowed--;
                b[i].available_copies++;
                break;
            }

        }
        if (chck == false) {
            System.out.println("No such record found");
        }
    }

    void display(String bookName, Book[] b, int noOfBooks) {
        boolean chck = false;
        for (int i = 0; i < noOfBooks; i++) {
            if (b[i].title.equals(bookName)) {
                chck = true;
                System.out.println("------Details of Given Book----------");
                System.out.println("Title of the given Book : " + b[i].title);
                System.out.println("Author of the given Book : " + b[i].author);
                System.out.println("ISBN of the given Book : " + b[i].ISBN);
                System.out.println("Available copies of the given Book : " + b[i].available_copies);
                break;
            }
        }
        if (chck == false) {
            System.out.println("No record found");
        }
    }

    void removeBook(Book[] b, String book_name) {
        boolean found = false;
        for (int i = 0; i < (b.length); i++) {
            if (b[i] != null && b[i].title.equals(book_name)) {
                found = true;
                for (int j = i; j < (b.length - 1); j++) {
                    b[j] = b[j + 1];
                }
                b[(b.length - 1)] = null;
                System.out.println("------Book Is Removed Sucessfully------");
                break;
            }
        }
        if (!found) {
            System.out.println("No such record Found");
        }
    }

}

class Library {

    static int noOfMembers;
    static int noOfWorkers;
    static int noOfBooks;

    public static void main(String args[]) {
        noOfMembers = 2;
        noOfWorkers = 1;
        noOfBooks = 5;
    try (Scanner sc = new Scanner(System.in)) {
        Member[] m = new Member[5];
        Worker[] w = new Worker[25];
        Book[] b = new Book[100];
        m[0] = new Member("Kunal", 19, "11/05/2005", "23001", "Kunal1105");
        m[1] = new Member("Parth", 19, "12/05/2005", "23002", "Parth1205");
        w[0] = new Worker("chaggan", 21, "21/05/1980", "10241", "chaggan2105");
        b[0] = new Book("Limitless", "Jim Kwik", "9780182736748", 5);
        b[1] = new Book("Power Of Habit", "Charles Duhigg", "9780182735734", 4);
        b[2] = new Book("Becoming", "Michelle Obama", "9780184826482", 3);
        b[3] = new Book("Power", "Robert Greene", "9780132675657", 1);
        b[4] = new Book("The Shining", "Stephen King", "9781029387484", 8);
        Member obj1 = new Member();
        Worker obj2 = new Worker("", 0, "", "", "");
        Book obj3 = new Book();
        System.out.println("\n====================================");
        System.out.println("   Welcome to Library Management   ");
        System.out.println("====================================\n");
        System.out.println("Are you a (member) or (worker)?");
        String chck = sc.next().toLowerCase();
        switch (chck) {
            case "member" -> {
            boolean b0 = true;
            while (b0) {
                System.out.print("Enter Member ID: ");
                String idInput1 = sc.next();
                System.out.print("Enter password: ");
                String passwordInput1 = sc.next();
                if ((obj1.verifyId(idInput1, m, noOfMembers)) && (obj1.verifyPassword(passwordInput1, m, noOfMembers))) {
                    b0 = false;
                    boolean b1 = true;
                    int i = obj1.getAccountNumber(idInput1, m, noOfMembers);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Welcome, " + m[i].name + "!");
                    System.out.println("----------------------------------------\n");
                    while (b1) {
                        System.out.println("\n========= Member Menu =========");
                        System.out.println("1. Search for a book");
                        System.out.println("2. Borrow a book");
                        System.out.println("3. Return a book");
                        System.out.println("4. Display book details");
                        System.out.println("5. Exit");
                        System.out.print("Choose an option: ");
                        int chck1 = sc.nextInt();
                        switch (chck1) {
                            case 1 -> {
                                System.out.print("Enter book name: ");
                                String book_name = sc.next();
                                obj3.searchBook(book_name, b, noOfBooks);
                            }
                            case 2 -> {
                                System.out.print("Enter book name: ");
                                String book_name2 = sc.next();
                                obj3.borrowBook(book_name2, b, noOfBooks, m, i);
                            }
                            case 3 -> {
                                System.out.print("Enter book name: ");
                                String book_name3 = sc.next();
                                obj3.returnBook(book_name3, b, noOfBooks, m, i);
                            }
                            case 4 -> {
                                System.out.print("Enter book name: ");
                                String book_name4 = sc.next();
                                obj3.display(book_name4, b, noOfBooks);
                            }
                            case 5 -> {
                                System.out.println("\nThank you for visiting! Goodbye!\n");
                                b1 = false;
                            }
                            default -> System.out.println("Invalid option. Please try again.");
                        }
                    }
                } else {
                    System.out.println("Invalid ID or password. Please try again.\n");
                }
            }
        }
    case "worker" -> {
            boolean b3 = true;
            while (b3) {
                System.out.print("Enter Worker ID: ");
                String idInput2 = sc.next();
                System.out.print("Enter password: ");
                String passwordInput2 = sc.next();
                if ((obj2.verifyId(idInput2, w, noOfWorkers)) && (obj2.verifyPassword(passwordInput2, w, noOfWorkers))) {
                    b3 = false;
                    boolean b4 = true;
                    int i = obj2.getAccountNumber(idInput2, w, noOfWorkers);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Welcome, " + w[i].name + "!");
                    System.out.println("----------------------------------------\n");
                    while (b4) {
                        System.out.println("\n========= Worker Menu =========");
                        System.out.println("1. Add a book");
                        System.out.println("2. Remove a book");
                        System.out.println("3. Add a member");
                        System.out.println("4. Remove a member");
                        System.out.println("5. Display member details");
                        System.out.println("6. Exit");
                        System.out.print("Choose an option: ");
                        int chck1 = sc.nextInt();
                        switch (chck1) {
                            case 1 -> {
                                System.out.print("Enter book title: ");
                                String title = sc.next();
                                System.out.print("Enter author: ");
                                String author = sc.next();
                                System.out.print("Enter ISBN: ");
                                String ISBN = sc.next();
                                System.out.print("Enter available copies: ");
                                int available_copies = sc.nextInt();
                                obj3.addBook(title, author, ISBN, available_copies, noOfBooks);
                            }
                            case 2 -> {
                                System.out.print("Enter book name: ");
                                String book_name5 = sc.next();
                                obj3.removeBook(b, book_name5);
                            }
                            case 3 -> obj1.addMember(m, noOfMembers);
                            case 4 -> {
                                System.out.print("Enter member ID: ");
                                String id1 = sc.next();
                                obj1.removeMember(m, id1);
                            }
                            case 5 -> {
                                System.out.print("Enter member ID: ");
                                String id2 = sc.next();
                                boolean found = false;
                                for (Member member : m) {
                                    if (member != null && member.id.equals(id2)) {
                                        found = true;
                                        member.display();
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("No such record found");
                                }
                            }
                            case 6 -> {
                                System.out.println("\nThank you for visiting! Goodbye!\n");
                                b4 = false;
                            }
                            default -> System.out.println("Invalid option. Please try again.");
                        }
                    }
                } else {
                    System.out.println("Invalid ID or password. Please try again.\n");
                }
            }
        }
        default -> System.out.println("Select from the options only.");
        }
    }

    }
}
