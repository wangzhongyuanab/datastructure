package com.test;

import com.mukewang.SegmentTree;

/**
 * 采用线段树解决区域和检索 - 数组可修改
 */
public class NumArray307two {

    private SegmentTree<Integer> segmentTree;

    public NumArray307two(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> (int) a + (int) b);

        }
    }
    public void update(int index, int val) {
        if (segmentTree==null){
            throw new IllegalArgumentException("Segment is null");
        }
        segmentTree.set(index,val);
    }

    public int sumRange ( int i, int j){
        if (segmentTree==null){
            throw new IllegalArgumentException("Segment is null");
        }
        return segmentTree.query(i,j);
    }
}
