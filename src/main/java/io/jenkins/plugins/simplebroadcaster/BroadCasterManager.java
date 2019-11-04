package io.jenkins.plugins.simplebroadcaster;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import org.kohsuke.stapler.DataBoundSetter;

@Extension
public class BroadCasterManager extends GlobalConfiguration {

    private String message;
    private String color;
    private String background;

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

    public String getColor() {
        return color;
    }

    @DataBoundSetter
    public void setColor(String color) {
        this.color = color;
        save();
    }

    public String getBackground() {
        return background;
    }

    @DataBoundSetter
    public void setBackground(String background) {
        this.background = background;
        save();
    }

}
