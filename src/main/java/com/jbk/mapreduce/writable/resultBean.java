package com.jbk.mapreduce.writable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class resultBean implements Writable {

    public long getTotalbuy() {
        return totalbuy;
    }

    public void setTotalbuy(long totalbuy) {
        this.totalbuy = totalbuy;
    }

    private long totalbuy;
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(totalbuy);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.totalbuy = in.readLong();
    }
    @Override
    public String toString() {
        return  "\t" + totalbuy;
    }
}
