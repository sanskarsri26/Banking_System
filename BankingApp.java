package Java.BankingSystem;


import java.util.Scanner;  
class BankDetails {  
    private String acno;  
    private String name;  
    private String acc_type;  
    private long balance;  
    Scanner sc = new Scanner(System.in);  
    //method to open new account  
    public void openAccount() {  
        System.out.print("Enter Account No: ");  
        acno = sc.next();  
        System.out.print("Enter Account type: ");  
        acc_type = sc.next();  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    }  
    //method to display account details  
    public void showAccount() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + acno);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
    //method to deposit money  
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
    //method to withdraw money  
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }  
    //method to search an account number  
    public boolean search(String ac_no) {  
        if (acno.equals(ac_no)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
}  
public class BankingApp {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        //create initial accounts  
        System.out.print("How many number of customers do you want to input? ");  
        int n = sc.nextInt();  
        BankDetails C[] = new BankDetails[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new BankDetails();  
            C[i].openAccount();  
        }  
        // loop runs until number 5 is not pressed to exit  
        int choice;  
        do {  
            System.out.println("\n ***Banking System Application***");  
            System.out.println("1. Display all account details \n"+ 
                               "2. Search by Account number\n"+ 
                               "3. Deposit the amount \n"+ 
                               "4. Withdraw the amount \n"+ 
                               "5. Exit ");  
            System.out.println("Enter your choice: ");  
            choice = sc.nextInt();  
                switch (choice) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showAccount();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 5:  
                        System.out.println("See you soon...");  
                        break;  
                }  
            }  
            while (choice != 5);  
        }  
    }  