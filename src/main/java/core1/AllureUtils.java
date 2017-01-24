package core1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 16.08.2016.
 */
public class AllureUtils {

    private static Logger logger = LoggerFactory.getLogger(AllureUtils.class);

    private static Parameter parameter(String name, String value) {
        Parameter param = new Parameter();
        param.setName(name);
        param.setValue(value);
        param.setKind(ParameterKind.ENVIRONMENT_VARIABLE);
        return param;
    }

    public static void fireAllureParameterVariable(final String name, final String value) {
        logger.info(name+": "+value);
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.getParameters().add(parameter(name, value));

            }
        });
    }

    public static void fireAllureFeatureAndStory(final String feature, final String story) {
        List<Label> labelList = new ArrayList<>();
        labelList.add(new Label().withName("feature").withValue(feature));
        labelList.add(new Label().withName("story").withValue(story));
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.setSeverity(SeverityLevel.CRITICAL);
               // testCaseResult.setLabels(labelList);
                testCaseResult.getLabels()
                        .add(new Label().withName("feature").withValue(feature));
                testCaseResult.getLabels()
                        .add(new Label().withName("story").withValue(story));
            }
        });
    }

    public static void fireFeature(final String feature) {
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.getLabels()
                        .add(new Label().withName("feature").withValue(feature));
            }
        });
    }

    public static void fireStory(final String story) {
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.getLabels()
                        .add(new Label().withName("story").withValue(story));
            }
        });
    }




}
