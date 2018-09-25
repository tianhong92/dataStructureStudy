package com.tianhong.DIYDataStructure.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
