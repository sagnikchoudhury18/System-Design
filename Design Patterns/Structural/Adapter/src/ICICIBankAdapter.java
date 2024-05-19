import thirdParty.ICICIBankApi;

public class ICICIBankAdapter implements  BankingService{

    private  final ICICIBankApi iciciBankApi = new ICICIBankApi();

    @Override
    public void addBankAccount(Bank bank) {
        iciciBankApi.addBankAccount(bank.name,bank.aadhar,bank.pan);
    }

    @Override
    public double checkBalance() {
        return 0;
    }
}
