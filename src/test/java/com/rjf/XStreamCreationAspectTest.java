package com.rjf;

import com.thoughtworks.xstream.XStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * To test that AspectJ <strong>is</strong> triggered when the package is not <pre>com.rjf</pre>
 */
public class XStreamCreationAspectTest_ValidPackage {
    @ParameterizedTest(name = "Testing new XStream{arguments}")
    @ArgumentsSource(XStreamArgumentsProvider_ValidPackage.class)
    public void testXStreamConstructorAspect(final XStream stream) {
        // TODO: Actually test something - for now, the aspect just logs to stdout (and so testing is manual)
    }

}