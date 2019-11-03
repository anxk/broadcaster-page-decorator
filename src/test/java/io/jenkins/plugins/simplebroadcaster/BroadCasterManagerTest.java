package io.jenkins.plugins.simplebroadcaster;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.jvnet.hudson.test.RestartableJenkinsRule;

public class BroadCasterManagerTest {

    @Rule
    public RestartableJenkinsRule rr = new RestartableJenkinsRule();

    /**
     * Tries to exercise enough code paths to catch common mistakes:
     * <ul>
     * <li>missing {@code load}
     * <li>missing {@code save}
     * <li>misnamed or absent getter/setter
     * <li>misnamed {@code textbox}
     * </ul>
     */
    @Test
    public void uiAndStorage() {
        rr.then(r -> {
            assertNull("not set initially", BroadCasterManager.get().getMessage());
            HtmlForm config = r.createWebClient().goTo("configure").getFormByName("config");
            HtmlTextArea textarea = config.getTextAreaByName("_.message");
            textarea.setText("hello");
            r.submit(config);
            assertEquals("global config page let us edit it", "hello", BroadCasterManager.get().getMessage());
        });
        rr.then(r -> {
            assertEquals("still there after restart of Jenkins", "hello", BroadCasterManager.get().getMessage());
        });
    }

}
