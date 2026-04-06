package com.myprojecticaro.poc_junit5_all_featues.extension;

import org.junit.jupiter.api.extension.*;

public class LogExecutionTimeExtension implements 
        BeforeTestExecutionCallback, 
        AfterTestExecutionCallback {

    private static final String START_TIME = "startTime";

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        long startTime = System.currentTimeMillis();

        context.getStore(ExtensionContext.Namespace.GLOBAL)
               .put(START_TIME, startTime);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long startTime = context.getStore(ExtensionContext.Namespace.GLOBAL)
                                .get(START_TIME, long.class);

        long duration = System.currentTimeMillis() - startTime;

        System.out.println(
            context.getDisplayName() + " executed in " + duration + " ms"
        );
    }
}