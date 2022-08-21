package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SplitLogicTest {
    @Test
    void remarksEvaluation() {
        RemarksEvaluator remarksEvaluator = new RemarksEvaluator();
        remarksEvaluator.addContext(createContext());
        File file = readRemarkLines("remarks.txt");
        addLinesToEvaluator(remarksEvaluator, file);
        remarksEvaluator.evaluate();
        assertThat(remarksEvaluator.getValue("HISTORY_REMARK"), is("H01-1234RAFAEL GUTIERREZ"));
    }

    @Test
    void remarksEvaluation2() {
        RemarksEvaluator remarksEvaluator = new RemarksEvaluator();
        remarksEvaluator.addContext(Map.of("AGENT_FIRST_NAME", "RAFAEL", "AGENT_LAST_NAME", "GUTIERREZ", "AGENT_CODE", "123"));
        remarksEvaluator.addLine("HISTORY_REMARK = H01-#AGENT_CODE##AGENT_FIRST_NAME# #AGENT_LAST_NAME#");
        remarksEvaluator.evaluate();
        assertThat(remarksEvaluator.getValue("HISTORY_REMARK"), is("H01-1234RAFAEL GUTIERREZ"));
    }

    private void addLinesToEvaluator(RemarksEvaluator remarksEvaluator, File file) {
    }

    private File readRemarkLines(String s) {
        return null;
    }

    private Map<String, String> createContext() {
        return null;
    }
}
