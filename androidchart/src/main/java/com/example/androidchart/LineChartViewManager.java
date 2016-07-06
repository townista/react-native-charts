/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-04T16:06:42+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-04T16:48:32+05:30
*/



package com.example.androidchart;

import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIProp;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.lang.Object;
import java.util.Date;


public class LineChartViewManager extends SimpleViewManager<LineChart> {

    public static final String REACT_CLASS="RCTLineChart";

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        return super.createShadowNodeInstance();
    }

    @Override
    public Class<LayoutShadowNode> getShadowNodeClass() {
        return super.getShadowNodeClass();
    }

    @Override
    public void updateExtraData(LineChart root, Object extraData) {
        super.updateExtraData(root, extraData);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected com.example.androidchart.LineChart createViewInstance(ThemedReactContext reactContext) {
        return new com.example.androidchart.LineChart(reactContext);
    }

    @ReactProp(name = "data")
    public void setLineData(LineChart root, String data) {
            ArrayList<String> xlabels = new ArrayList<>();
            ArrayList<Entry> xvalues = new ArrayList<>();

            Log.d("linechart",data);

            if (data != null) {
                try {
                    JSONArray dataArray = new JSONArray(data);

                    Log.d("linechart",dataArray.toString());

                    for (int i = 0 ; i < dataArray.length() ; i++) {
                        try {
                            JSONObject dataArrayElem = (JSONObject) dataArray.get(i);
                            xlabels.add(dataArrayElem.getString("date"));
                            xvalues.add(new Entry(dataArrayElem.getInt("value"), i));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                    LineDataSet set = new LineDataSet(xvalues, "values");
                    dataSets.add(set);
                    LineData ldata = new LineData(xlabels, dataSets);
                    root.setData(ldata);
                    root.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                    YAxis yaxis = root.getAxisLeft();
                    yaxis.setValueFormatter(new YAxisFormatter());
                    XAxis xaxis = root.getXAxis();
                    xaxis.setValueFormatter(new XAxisFromatter());
                    root.invalidate();
                }
                catch ( JSONException e){
                    e.printStackTrace();
                }
            }

    }
    class XAxisFromatter implements XAxisValueFormatter{
        SimpleDateFormat format;

        @Override
        public String getXValue(String original, int index, ViewPortHandler viewPortHandler) {
            String date = "";
            try {
                Date temp = format.parse(original);
                date = format.format(temp);
            }
            catch (ParseException  e){

            }
            return date;
        }

        public XAxisFromatter() {
            format = new SimpleDateFormat("EEE, d MMM");
        }
    }
    class YAxisFormatter implements YAxisValueFormatter{
        private DecimalFormat mformat;

        public YAxisFormatter() {
            mformat = new DecimalFormat("##0.#");

        }

        @Override
        public String getFormattedValue(float value, YAxis yAxis) {
            return mformat.format(value);
        }
    }
}
