package com.jbk.mapreduce.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<Text, FlowBean,Text, resultBean> {
    private resultBean outV = new resultBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        // 1 遍历集合累加值
        long totalbuy = 0;


        for (FlowBean value : values) {
            if (value.getAction()==2){
                totalbuy+=1;
            }
        }

        // 2 封装outk, outv
        outV.setTotalbuy(totalbuy);

        // 3 写出
        context.write(key, outV);
    }
}
