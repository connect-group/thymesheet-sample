package com.connect_group.thymesheet.sample.webapp;

import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
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

import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.exists;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ThymesheetTestSpringContext.class })
public class FragmentHtmlTest {
    public static final String HTML_PATH = "/html/fragment.html";

    @Autowired
    private ThymeleafTestEngine testEngine;
    
    Map<String,Object> model;
    
    @Before
    public void setup() {
        model = new HashMap<String,Object>();
    }

    @Test
    public void shouldRemoveElement_WhenElementHasClassRemoveMe() throws NodeSelectorException {
        HtmlElements tags = testEngine.process(HTML_PATH, model);
        assertThat(tags.matching(".removeme"), not(exists()));
    }
}

