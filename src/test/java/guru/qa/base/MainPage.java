package guru.qa.base;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public void checkListTab(String tab){
        $("nav.d-header-topmenu").shouldHave(text(tab));
    }

    public MainPage menuList(Integer num){
        $("nav.d-header-topmenu a", num).click();
        return this;
    }
}
