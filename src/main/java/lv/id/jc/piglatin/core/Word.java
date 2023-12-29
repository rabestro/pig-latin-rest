package lv.id.jc.piglatin.core;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Target({PARAMETER, METHOD, FIELD})
@NotNull
@NotBlank
@Pattern(regexp = """
    #
    # A single word
    # contains only Unicode letters and apostrophe (') in the middle
    # only one apostrophe is allowed
    #
    ^               # Start of the line
    (               # Start of the group
        \\p{L}      # Any Unicode letter
    |               # OR
        (?<=\\p{L}) # Positive lookbehind for a Unicode letter
        '           # An apostrophe
        (?=\\p{L})  # Positive lookahead for a Unicode letter
        (?!.*')     # Negative lookahead for another apostrophe
    )               # End of the group
    +               # One or more of the previous group
    $               # End of the line
    """,
    flags = {Pattern.Flag.COMMENTS, Pattern.Flag.CASE_INSENSITIVE}
)
public @interface Word {
    String message() default "must be a single word";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
