package com.vararg.vipersample.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by vararg on 06-02-17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Job {
}
