package fr.lernejo.tester.internal;
import org.assertj.core.api.Assertions;
import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {
    @TestMethod
    public void should_discovery_only_marked_methods(){
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = testClassDescription.listTestMethods();

        Assertions.assertThat(methods)
            .extracting(method-> method.getName())
            .containsExactlyInAnyOrder("ok","ko");
    }
    public static void main(String[] args){
        new TestClassDescriptionLernejoTests().should_discovery_only_marked_methods();

    }
}
