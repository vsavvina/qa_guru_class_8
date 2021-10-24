package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.base.MainPage;
import guru.qa.domain.MenuItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class AnnotTestWeb {
    final private MainPage mainPage = new MainPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://www.lamoda.ru/");
    }

    @CsvSource({
            "Premium",
            "Спорт",
            "Красота",
    })
    @DisplayName("Tests with CsvSource")
    @ParameterizedTest()
    void testWithComplexName(String searchQuery) {
        mainPage.checkListTab(searchQuery);
        System.out.println(searchQuery);
    }

    @EnumSource(value = MenuItem.class)
    @DisplayName("Test with EnumSource")
    @ParameterizedTest()
    void checkSearchResultForSeveralMenuItems(MenuItem menuItem) {
        Configuration.startMaximized = true;
        mainPage.checkListTab(menuItem.getDesc());
        System.out.println(menuItem.getDesc());
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(3, "Обувь"),
                Arguments.of(4, "Аксессуары"),
                Arguments.of(5, "Бренды")
        );
    }
    @MethodSource("testWithMethodSource")
    @ParameterizedTest()
    @DisplayName("Test with MethodSource")
    void openTabsUsingMethodSource(int num, String name){
        mainPage.menuList(num).checkListTab(name);
        System.out.println(name);
    }
}
