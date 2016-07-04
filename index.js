/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-01T14:54:20+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-04T13:19:27+05:30
*/
'use-strict';

import React, {requireNativeComponent , PropTypes } from 'react';

var iface={
  name: 'LineChart',
  propTypes:{
    data: PropTypes.string,
  }

};

module.exports = requireNativeComponent('RCTLineChart',iface);
