package utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @info This annotation shows us, what kind of expansion is given a link to a file. If
 * properties true - file extension {@extension .properties {@see https://ru.wikipedia.org/wiki/.properties}}
 * xml true - file extension {@extension .xml {@see https://ru.wikipedia.org/wiki/XML}}
 */

//@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FileProperties {

    boolean properties() default false;

    boolean xml() default false;

}
