package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="newTours",glue={"com.NewToursLogInTest"})

public class TestRunner {

}
