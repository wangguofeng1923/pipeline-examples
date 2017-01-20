package com.wangguofeng.jenkins.pipeline.examples;

import hudson.Extension;
import hudson.model.Run;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractSynchronousNonBlockingStepExecution;
import org.jenkinsci.plugins.workflow.steps.StepContextParameter;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import javax.inject.Inject;
import java.io.IOException;

public class HelloWorldStep extends AbstractStepImpl {

    private String name = "Jenkins";
    private Integer age;

    @DataBoundConstructor
    public HelloWorldStep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @DataBoundSetter
    public void setAge(Integer age) {
		this.age = age;
	}

	public ResponseContent createGreeting(Run<?,?> run, TaskListener listener)
            throws InterruptedException, IOException
    {
		if(age==null){
			  return new ResponseContent(name);
		}else{
			  return new ResponseContent(name+",age="+age);	
		}
		
      
    }


    @Override
    public HelloWorldStep.DescriptorImpl getDescriptor() {
        return (HelloWorldStep.DescriptorImpl) super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends AbstractStepDescriptorImpl {

        public DescriptorImpl() {
            super(Execution.class);
        }

        @Override
        public String getFunctionName() {
            return "helloWorld";
        }

        @Override
        public String getDisplayName() {
            return "Say hello";
        }

    }

    public static final class Execution extends AbstractSynchronousNonBlockingStepExecution<ResponseContent> {

        @Inject
        private transient HelloWorldStep step;

        @StepContextParameter
        private transient Run run;

        @StepContextParameter
        private transient TaskListener listener;

        @Override
        protected ResponseContent run() throws Exception {
            return step.createGreeting(run, listener);
        }

    }

}
