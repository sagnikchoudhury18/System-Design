public class SimpleAdaptorFactory {
    public static BankingService getAdapterInstance(String type) {
        if(type.equalsIgnoreCase("ICICI")){
            return new ICICIBankAdapter();
        } else if(type.equalsIgnoreCase("YESBANK")){
            return new YesBankAdapter();
        }
        return null;
    }
}
