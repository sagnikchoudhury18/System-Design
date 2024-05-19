public class IosUiFactory implements  UIFactory{

    @Override
    public Button createButton(){
        return  new IosButton();
    }

    @Override
    public  DropDown createDropDown(){
        return  new IosDropDown();
    }

}
