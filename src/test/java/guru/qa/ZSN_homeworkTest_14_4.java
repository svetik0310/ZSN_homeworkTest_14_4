package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ZSN_homeworkTest_14_4 {
    @BeforeAll
    static void setup() {
        Configuration.browserSize =  "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    public void homework4()
    {
        //- Откройте страницу Selenide в Github
        open("/selenide/selenide");
        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Welcome to the selenide wiki!"));
        //- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        //- Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
