package com.myprojecticaro.poc_junit5_all_featues.assumption;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Assumptions Tests")
public class AssumptionTest {

    @Test
    void shouldRunOnlyIfConditionIsTrue() {

        assumeTrue(2 > 1);

        System.out.println("Test executed");
    }

    @Test
    void shouldBeSkipped() {

        assumeTrue(false);

        System.out.println("This will NOT run");
    }

    @Test
    void shouldRunOnlyInDevEnvironment() {

        String env = System.getenv("ENV");

        assumeTrue("dev".equalsIgnoreCase(env));

        System.out.println("Running only in DEV");
    }

    @Test
    void shouldNotRunOnProduction() {

        String env = "prod";

        assumeFalse("prod".equals(env));

        System.out.println("Will not run in production");
    }

    @Test
    void shouldExecutePartiallyBasedOnCondition() {

        String env = "dev";

        assumingThat("dev".equals(env), () -> {
            System.out.println("Executed only in DEV");
        });

        System.out.println("Always executed");
    }

}
