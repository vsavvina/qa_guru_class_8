package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.domain.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class AnnotTestWeb {
    String site = "https://github.com/selenide/selenide";

    @CsvSource({
            "88891",
            "88892"
    })
    @DisplayName("Test with CsvSource")
    @ParameterizedTest()
    void testWithComplexName(int allureId, String searchQuery, String testName) {
        Configuration.startMaximized = true;
        open(site);

//        ymp.doSearch(searchQuery).checkResults(searchQuery);
    }

    @EnumSource(value = MenuItem.class, names = {"SEARCH"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("Test with EnumSource")
    @ParameterizedTest()
    void checkSearchResultForSeveralMenuItems(MenuItem menuItem) {
        Configuration.startMaximized = true;
        open(site);
        //ymp.doSearch("selenide").switchToMenuItem(menuItem);
        System.out.println();
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(0, " Все потоки"),
                Arguments.of(1, "Разработка"),
                Arguments.of(2, "Администрирование"),
                Arguments.of(3, "Дизайн"),
                Arguments.of(4, "Менеджмент"),
                Arguments.of(5, "Маркетинг"),
                Arguments.of(6, "Научпоп")
        );
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest()
    @DisplayName("Test with MethodSource")
    void openTabsUsingMethodSource(int number, String tab){
        //page.openMainPage()
         //       .clickItemWithNumber(number)/
        //            .checkTab(tab);
    }
}
