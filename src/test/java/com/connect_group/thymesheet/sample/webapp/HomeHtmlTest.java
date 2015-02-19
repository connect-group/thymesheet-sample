package com.connect_group.thymesheet.sample.webapp;

import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
import com.connect_group.thymeleaf.testing.config.TestMessageSource;
import com.connect_group.thymeleaf.testing.config.ThymesheetTestSpringContext;
import com.connect_group.thymesheet.css.selectors.NodeSelectorException;
import com.connect_group.thymesheet.query.HtmlElements;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasOnlyText;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.isSingleElementThat;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ThymesheetTestSpringContext.class })
public class HomeHtmlTest {
    public static final String HTML_PATH = "/html/home.html";

    @Autowired
    private ThymeleafTestEngine testEngine;

    @Autowired
    private TestMessageSource messageSource;
            
    Map<String,Object> model;

    @Before
    public void setup() {
        model = new HashMap<String,Object>();
    }

    @Test
    public void shouldDisplayWelcomeMessage_WhenTagIsHeading1() throws NodeSelectorException {
        messageSource.givenMessageWithKey("welcome", "Expected Welcome Message");
        HtmlElements tags = testEngine.process(HTML_PATH, model);
        assertThat(tags.matching("h1"), isSingleElementThat(hasOnlyText("Expected Welcome Message")));
    }

    @Test
    public void shouldDisplayIntroMessage_WhenRenderingFirstParagraph() throws NodeSelectorException {
        messageSource.givenMessageWithKey("intro", "Expected Intro Message");
        HtmlElements tags = testEngine.process(HTML_PATH, model);
        assertThat(tags.matching("p:first-of-type"), isSingleElementThat(hasOnlyText("Expected Intro Message")));
    }
}
