package org.personal.controller;

import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.personal.WebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebMvcConfig.class })
public class HomeControllerTest
{
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private String controller_url_base = "/home";

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void homeController_smokeTesting()
    {
        ServletContext servletContext = wac.getServletContext();

        assertThat(servletContext, Matchers.notNullValue());
        assertTrue(servletContext instanceof MockServletContext);
        assertThat(wac.getBean("homeController"), Matchers.notNullValue());
    }

    @Test
    public void homeController_AccessTesting() throws Exception
    {
        Map<String, String> viewMappingMap = new HashMap<>();
        viewMappingMap.put(controller_url_base + "/default", "home");
        viewMappingMap.put(controller_url_base + "/link", "home");

        for (Map.Entry<String, String> viewEntry : viewMappingMap.entrySet())
        {
            this.mockMvc.perform(get(viewEntry.getKey())).andExpect(view().name(viewEntry.getValue()));
        }

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(controller_url_base + "/parametertest").param("username", "vincent").param("age", "37");
        this.mockMvc.perform(requestBuilder).andExpect(view().name("home"));
    }
}