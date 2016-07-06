/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-01T14:54:20+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-06T13:33:17+05:30
*/
'use-strict';

import React,{Component, PropTypes } from 'react';
import {requireNativeComponent, View }from 'react-native';

class LineChartView extends Component{
  constructor(props){
    super(props);
  }

  render(){
    return (<CustomLineChartView data={this.props.data} />);
  }

}

LineChartView.propTypes ={
    ...View.propTypes,
    data: PropTypes.string,
};


var CustomLineChartView = requireNativeComponent('RCTLineChart',LineChartView);

module.exports = LineChartView;
