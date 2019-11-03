package io.jenkins.plugins.simplebroadcaster;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import org.kohsuke.stapler.DataBoundSetter;

@Extension
public class BroadCasterManager extends GlobalConfiguration {

    private String message;

    public static BroadCasterManager get() {
        return GlobalConfiguration.all().get(BroadCasterManager.class);
    }

    public BroadCasterManager() {
        load();
    }

    public String getMessage() {
        return message;
    }

    @DataBoundSetter
    public void setMessage(String message) {
        this.message = message;
        save();
    }

}
