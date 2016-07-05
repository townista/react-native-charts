/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-01T14:54:20+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-05T12:24:43+05:30
*/
'use-strict';

import React, {PropTypes } from 'react';
import requireNativeComponent from 'react-native';

var iface={
  name: 'LineChart',
  propTypes:{
    data: PropTypes.string,
  }

};

module.exports = requireNativeComponent('RCTLineChart',iface);
