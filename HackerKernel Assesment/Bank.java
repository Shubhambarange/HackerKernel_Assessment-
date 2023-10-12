import java.util.ArrayList;

class Customer {
    private int custID;
    private String cname;
    private String contactdetails;

    public Customer(int custID, String cname, String contactdetails) {
        this.custID = custID;
        this.cname = cname;
        this.contactdetails = contactdetails;
    }

    public int getcustID() {
        return custID;
    }

    public String getcname() {
        return cname;
    }

    public String getcontactdetails() {
        return contactdetails;
    }
}

class Account {
    private int accNumber;
    private Customer accHolder;
    private double cust_balance;

    public Account(int accNumber, Customer accHolder, double cust_balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.cust_balance = cust_balance;

    }

    public int getaccNumber() {
        return accNumber;
    }

    public Customer getaccHolder() {
        return accHolder;
    }

    public double getcust_balance() {
        return accNumber;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            cust_balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= cust_balance) {
            cust_balance -= amount;
            return true;
        }
        return false;
    }
}

class Bank {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account createAccount(int custID, double initialcust_balance) {
        Customer customer = findCustomer(custID);
        if (customer != null) {
            int accNumber = accounts.size() + 1;
            Account account = new Account(accNumber, customer, initialcust_balance);
            accounts.add(account);
            return account;
        }
        return null;
    }

    public Customer findCustomer(int custID) {
        for (Customer customer : customers) {
            if (customer.getcustID() == custID) {
                return customer;
            }
        }
        return null;
    }

    public Account findAccount(int accNumber) {
        for (Account account : accounts) {
            if (account.getaccNumber() == accNumber) {
                return account;
            }
        }
        return null;
    }

    public boolean performTransaction(int fromaccNumber, int toaccNumber, double amount) {
        Account fromAccount = findAccount(fromaccNumber);
        Account toAccount = findAccount(toaccNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount) && toAccount.deposit(amount)) {
                return true;
            }
        }
        return false;
    }

    public void displayAccountDetails(int accNumber) {
        Account account = findAccount(accNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getaccNumber());
            System.out.println("Account Holder: " + account.getaccHolder().getcname());
            System.out.println("cust_balance: $" + account.getcust_balance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer1 = new Customer(1, "John Doe", "john.doe@email.com");
        System.out.println("Customer added");
        Customer customer2 = new Customer(2, "Jane Smith", "jane.smith@email.com");
        System.out.println("Customer added");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        Account account1 = bank.createAccount(1, 1000);
        System.out.println("account Created");
        Account account2 = bank.createAccount(2, 500);
        System.out.println("account Created");

        bank.displayAccountDetails(1);
        bank.displayAccountDetails(2);

        if (bank.performTransaction(1, 2, 200)) {
            System.out.println("Transaction successful.");
        } else {
            System.out.println("Transaction failed.");
        }

        bank.displayAccountDetails(1);
        bank.displayAccountDetails(2);
    }
}
