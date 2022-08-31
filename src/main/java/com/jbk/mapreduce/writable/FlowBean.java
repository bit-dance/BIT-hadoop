package com.jbk.mapreduce.writable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 1、定义类实现writable接口
 * 2、重写序列化和反序列化方法
 * 3、重写空参构造
 * 4、toString方法
 */
public class FlowBean implements Writable {


    public long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(long goodsid) {
        this.goodsid = goodsid;
    }

    public long getAction() {
        return action;
    }

    public void setAction(long action) {
        this.action = action;
    }

    private long goodsid; //
    private long action; //

    // 空参构造
    public FlowBean() {
    }


    @Override
    public void write(DataOutput out) throws IOException {

        out.writeLong(goodsid);
        out.writeLong(action);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.goodsid= in.readLong();
        this.action = in.readLong();
    }

    @Override
    public String toString() {
        return  goodsid + "\t" + action;
    }
}
