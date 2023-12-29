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

/**
 * A single word.
 * <p>
 * A single word contains only Unicode letters and apostrophe (') in the middle.
 * Only one apostrophe is allowed.
 * <p>
 * Examples:
 * <ul>
 *     <li>word</li>
 *     <li>it's</li>
 *     <li>don't</li>
 *     <li>can't</li>
 *     <li>o'clock</li>
 * </ul>
 */
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
    /**
     * The default error message if the validation fails.
     *
     * @return the error message
     */
    String message() default "must be a single word";

    /**
     * The groups the constraint belongs to.
     *
     * @return the groups
     */
    Class<?>[] groups() default {};

    /**
     * The payload that can be associated with a constraint violation.
     *
     * @return the payload
     */
    Class<? extends Payload>[] payload() default {};
}
