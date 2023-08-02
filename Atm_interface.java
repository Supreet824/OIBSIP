import java.util.Scanner;
// The login details are to be fetched from the database. Here we have used a sample data
class login{
    int id =001;
    int PIN = 10000;
    double balance=150000.0;
    int amt;


    public void loginpage(){
        System.out.println("Enter the userid of your bank: ");
        Scanner sc =new Scanner(System.in);
        int enteredID = sc.nextInt();

        System.out.println("Enter your atm pincode: ");

        int enteredpiN = sc.nextInt();

        if(enteredID==id && enteredpiN==PIN){
            menu();
        }
        else {
            System.out.println("Enter the correct id and password");
            loginpage();
        }
    }

    public void menu(){
        System.out.println("1. Remanining balance");
        System.out.println("2. Withdraw Cash ");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Transfer money");
        System.out.println("5. Exit");

        System.out.println("Enter your choice 1 , 2, 3, 4, 5");
        Scanner sc= new Scanner(System.in);
        int ch =sc.nextInt();

        if (ch==1){
            Remaining_balance();
        }
        else if(ch == 2 ){
            withdraw_cash();
        }
        else if(ch == 3 ){
            deposit_cash();
        }
        else if(ch == 4){
            transfer_money();
        }
        else if(ch == 5 ){
            System.out.println("Thank you for Banking with us");
            return;
        }

        else{
            System.out.println("Invalid Choice");
        }

    }
    public void Remaining_balance(){
        System.out.println("Remaining balance "+balance);
        menu();
    }


    public void withdraw_cash(){
        System.out.println("Enter the amount you want to withdraw");
        Scanner sc =new Scanner(System.in);
        int amt= sc.nextInt();


        if (amt > balance){
            System.out.println("Insufficient Balance");
        }

        else {
            balance = balance - amt;
            System.out.println("Money has been withdrawn successfully");
            System.out.println("Do you want to display the remaining balance y/n ");
            String Dis_rem=sc.next();
              if (Dis_rem.equalsIgnoreCase("y")) {
                   Remaining_balance();
                } else {
                    
                }
            menu();
        }
    }


    public void  deposit_cash(){
        System.out.println("Enter the amount u want to deposit");
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();

        balance= balance+ amt ;
        System.out.println("Money deposited Sucessfully");

        System.out.println("Your current balance is "+ balance);
        menu();
    }


    public void transfer_money(){
        // System.out.println("CURRENT BALANCE "+balance);
        System.out.println("Enter the bank details you want to transfer");
        System.out.println("...........................................");
        System.out.println("Enter the account number of the reciever's bank");
        Scanner sc = new Scanner(System.in);
        float recno = sc.nextFloat();

        System.out.println("Enter the amount u want to transfer");
        float trans =sc.nextFloat();

        if ( balance > trans ){
            System.out.println("Amount Transferred Successfully");
        }
        else{
            System.out.println("Insufficient Money to transfer");
        }


        menu();
    }

}

public class Atm_interface
{
    public static void main (String args[]) {

        login obj =new login();
        obj.loginpage();
    
    }
}