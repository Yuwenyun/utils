package com.owen.common;

import java.lang.instrument.Instrumentation;

public class InstrumentationAgent{

    private static volatile Instrumentation agent;
    
    public static void premain(final String agentArgs, final Instrumentation inst){
        agent = inst;
    }
    
    public static long getObjectSize(Object obj){
        if(agent == null){
            throw new IllegalArgumentException("Agent not initialized");
        }
        if(obj == null){
            return 0L;
        }
        return agent.getObjectSize(obj);
    }
}
