/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-01T14:54:20+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-05T15:12:55+05:30
*/
'use-strict';

import React,{Component, PropTypes } from 'react';
import {requireNativeComponent, View }from 'react-native';

class LineChartView extends Component{
  constructor(props){
    super(props);
  }

  render(){
    return (<CustomLineChartView {...this.props} />);
  }

}
LineChartView.propTypes ={
    ...View.propTypes,
    data: PropTypes.string,
};
var CustomLineChartView = requireNativeComponent('RCTLineChart',LineChartView);

module.exports = LineChartView;
