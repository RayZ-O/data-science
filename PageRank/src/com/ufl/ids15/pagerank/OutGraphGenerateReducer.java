package com.ufl.ids15.pagerank;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class OutGraphGenerateReducer extends MapReduceBase implements
	Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterator<Text> values,
	    OutputCollector<Text, Text> output, Reporter reporter)
	    throws IOException {
	StringBuilder sb = new StringBuilder();
	while (values.hasNext()) {
	    sb.append(values.next().toString() + '\t');
	}
	sb.setLength(Math.max(sb.length() - 1, 0)); // delete last \t
	output.collect(key, new Text(sb.toString()));
    }
}
