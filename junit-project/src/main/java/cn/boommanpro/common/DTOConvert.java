package cn.boommanpro.common;

public interface DTOConvert<S, T> {
    T convert(S s);
}
