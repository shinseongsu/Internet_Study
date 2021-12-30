package fastcampus.functionalPrograming.chapter03.util;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
