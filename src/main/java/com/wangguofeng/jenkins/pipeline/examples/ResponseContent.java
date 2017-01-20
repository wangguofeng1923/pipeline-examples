package com.wangguofeng.jenkins.pipeline.examples;

import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.Whitelisted;


import java.io.Serializable;


public class ResponseContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String greeting;

    public ResponseContent(String str) {
       greeting = str;
    }

    @Whitelisted
    public String getGreeting() {
        return greeting;
    }


    @Override
    public String toString() {
        return greeting;
    }
}