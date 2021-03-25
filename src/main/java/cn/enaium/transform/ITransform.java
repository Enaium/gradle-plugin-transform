package cn.enaium.transform;

/**
 * Project: transform
 * Author: Enaium
 */
public interface ITransform {
    default byte[] transform(byte[] basic) {
        return basic;
    }
}
