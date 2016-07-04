package com.example.androidchart;

import android.support.annotation.Nullable;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineChartViewManager extends SimpleViewManager<com.github.mikephil.charting.charts.LineChart> {
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
    protected LineChart createViewInstance(ThemedReactContext reactContext) {
        return new com.example.androidchart.LineChart(reactContext);
    }

    @ReactProp(name = "data")
    public void setLineData(LineChart root, @Nullable Object[] dataArray){
        ArrayList<String> xlabels = new ArrayList<>();
        ArrayList<Entry> xvalues = new ArrayList<>();

        for (int i=0 ; i < dataArray.length ; i ++){
            try {
                JSONObject dataArrayElem = (JSONObject) dataArray[i];
                xlabels.add(dataArrayElem.getString("date"));
                xvalues.add(new Entry(dataArrayElem.getInt("value"),i));
            }
            catch(JSONException e){

            }

        }
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(new LineDataSet(xvalues,"values"));
        LineData ldata = new LineData(xlabels,dataSets);
        root.setData(ldata);
        root.invalidate();
    }
}
