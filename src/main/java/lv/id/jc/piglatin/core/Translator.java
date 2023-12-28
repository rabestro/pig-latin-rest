package lv.id.jc.piglatin.core;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface Translator extends UnaryOperator<String> {
}
