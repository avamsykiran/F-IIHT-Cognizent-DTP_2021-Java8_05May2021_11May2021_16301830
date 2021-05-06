package com.cts.jdk8.service;

@FunctionalInterface
public interface BiPredicate<T,R> {
	boolean check(T v1,R v2);
}
