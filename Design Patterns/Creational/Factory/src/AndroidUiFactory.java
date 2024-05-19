public class AndroidUiFactory implements  UIFactory{

    @Override
    public Button createButton(){
        return  new AndroidButton();
    }

    @Override
    public  DropDown createDropDown(){
        return  new AndroidDropDown();
    }
}
