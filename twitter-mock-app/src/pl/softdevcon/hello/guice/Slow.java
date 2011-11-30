package pl.softdevcon.hello.guice;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.*;

@Documented
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Slow {
}
