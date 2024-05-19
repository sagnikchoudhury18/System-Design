import thirdParty.YesBankApi;

public class YesBankAdapter implements  BankingService{

    private final YesBankApi yesBankApi = new YesBankApi();
    @Override
    public void addBankAccount(Bank bank) {
        yesBankApi.registerBankAccount(bank.type, bank.name, bank.pan, bank.dob, bank.fname);
    }

    @Override
    public double checkBalance() {
        return 0;
    }
}
