public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BankingService bankingService = SimpleAdaptorFactory.getAdapterInstance("ICICI");

        PhonePe phonePe = new PhonePe(bankingService);
        phonePe.createBankAccount();
    }
}