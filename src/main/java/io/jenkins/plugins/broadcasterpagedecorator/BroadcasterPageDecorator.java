package io.jenkins.plugins.broadcasterpagedecorator;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.PageDecorator;
import net.sf.json.JSONObject;

@Extension
public class BroadcasterPageDecorator extends PageDecorator {

    public final static String DEFAULT_COLOR = "white";
    public final static String DEFAULT_BACKGROUND = "red";

    private String message;
    private String color;
    private String background;

    @DataBoundConstructor
    public BroadcasterPageDecorator(String message, String color, String background) {
        this();
        this.message = message;
        this.color = color;
        this.background = background;
    }

    public BroadcasterPageDecorator() {
        load();
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return true;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (message == null || message.trim().isEmpty()) {
            return "";
        }
        return message;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        if (color == null || color.trim().isEmpty()) {
            return DEFAULT_COLOR;
        }
        return color;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackground() {
        if (background == null || background.trim().isEmpty()) {
            return DEFAULT_BACKGROUND;
        }
        return background;
    }

}
