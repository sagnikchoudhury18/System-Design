public class PhonePe {

    private  BankingService bankingService;

    public PhonePe(BankingService bankingService){
        this.bankingService = bankingService;
    }

    void createBankAccount(){
        Bank bank = new Bank();
        bank.name = "Sagnik";
        bank.pan = "AULPCXXXXX";
        bank.aadhar ="12345678";

        bankingService.addBankAccount(bank);

    }

    void listBankAccounts(){

    }

    void transferMoney(){

    }
}
