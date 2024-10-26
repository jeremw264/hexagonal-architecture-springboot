package com.jeremw.hexagonal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Custom annotation to mark service port interfaces in the application.
 * <p>
 * This annotation is intended for use on classes that represent service
 * ports in a hexagonal architecture. Classes annotated with
 * {@code @ServicePort} will be scanned and registered as Spring beans
 * during the application startup, allowing them to be injected where needed.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServicePort {
}
