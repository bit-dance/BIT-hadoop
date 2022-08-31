package com.jbk.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 1 获取一行
        // 328862,323294,833,2882,2661,08,29,0,0,1,内蒙古
        String line = value.toString();

        // 2 切割

        String[] split = line.split(",");

        // 3 抓取想要的数据
        String customorid = split[0];
        String goodsid = split[1];
        String action  = split[split.length - 4];

        // 4封装
        outK.set(customorid);
        outV.setGoodsid(Long.parseLong(goodsid));
        outV.setAction(Long.parseLong(action));


        // 5 写出
        context.write(outK, outV);
    }
}
