package io.jenkins.plugins.broadcasterpagedecorator;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.RestartableJenkinsRule;

import hudson.model.PageDecorator;

public class BroadcasterPageDecoratorTest {

    @Rule
    public RestartableJenkinsRule rr = new RestartableJenkinsRule();

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void uiAndStorage() {
        rr.then(r -> {
            BroadcasterPageDecorator broadcaster = PageDecorator.all().get(BroadcasterPageDecorator.class);

            assertEquals("The message should be empty initially", "", broadcaster.getMessage());
            assertEquals("The color should be white initially", "white", broadcaster.getColor());
            assertEquals("The background should be red initially", "red", broadcaster.getBackground());

            HtmlForm config = r.createWebClient().goTo("configure").getFormByName("config");
            HtmlTextArea message = config.getTextAreaByName("_.message");
            HtmlTextInput color = config.getInputByName("_.color");
            HtmlTextInput background = config.getInputByName("_.background");
            message.setText("Welcome to Jenkins!");
            color.setText("green");
            background.setText("brown");
            r.submit(config);

            assertEquals("The message should be Welcome to Jenkins!", "Welcome to Jenkins!", broadcaster.getMessage());
            assertEquals("The color should be green", "green", broadcaster.getColor());
            assertEquals("The background should be brown", "brown", broadcaster.getBackground());
        });
        rr.then(r -> {
            BroadcasterPageDecorator broadcaster = PageDecorator.all().get(BroadcasterPageDecorator.class);

            assertEquals("Still there after restart of Jenkins", "Welcome to Jenkins!", broadcaster.getMessage());
            assertEquals("Still there after restart of Jenkins", "green", broadcaster.getColor());
            assertEquals("Still there after restart of Jenkins", "brown", broadcaster.getBackground());
        });
    }

    @Test
    public void defaultColorTest() { 
        BroadcasterPageDecorator broadcaster = j.getInstance()
            .getExtensionList(PageDecorator.class)
            .get(BroadcasterPageDecorator.class);

        broadcaster.setColor("");
        assertEquals("The Color should be white default", "white", broadcaster.getColor());
        broadcaster.setColor(" ");
        assertEquals("The Color should be white default", "white", broadcaster.getColor());
    }

    @Test
    public void defaultBackgroundTest() {
        BroadcasterPageDecorator broadcaster = j.getInstance()
            .getExtensionList(PageDecorator.class)
            .get(BroadcasterPageDecorator.class);

        broadcaster.setBackground("");
        assertEquals("The background should be red for default", "red", broadcaster.getBackground());
        broadcaster.setBackground(" ");
        assertEquals("The background should be red for default", "red", broadcaster.getBackground());
    }

}
