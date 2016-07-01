/**
* @Author: Rahul Ravindran <root>
* @Date:   2016-07-01T14:54:20+05:30
* @Email:  rahul.r945@gmail.com
* @Last modified by:   root
* @Last modified time: 2016-07-01T17:38:16+05:30
*/
'use-strict';

var { requireNativeComponent , React } = require('react-native');

var iface={
  name: 'LineChart',
  propTypes:{
    data : React.PropTypes.arrayOf(React.PropTypes.object)
  }

};

module.exports = requireNativeComponent('RCTLineChart',iface);
