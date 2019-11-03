package io.jenkins.plugins.simplebroadcaster;

import hudson.Extension;
import hudson.model.PageDecorator;

@Extension
public class BroadcasterDecorator extends PageDecorator {

    public String getMessage() {
        return BroadCasterManager.get().getMessage();
    }

}
