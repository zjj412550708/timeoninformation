import React, { Component } from "react";
import axios from "axios";
import { Button, Input } from "antd";
import { Table } from 'antd';



class Info extends Component {
  constructor(props) {
    super(props);
    this.onChange =this.onChange.bind(this);
    this.information = this.information.bind(this);
    this.state = {
      list:[],
      usercode: "",
      
    };
    
  }
   onChange(e){
    this.setState({
    usercode:e.target.value
    })
    } 
  information() {
    
    var usercode = document.getElementById("usercode").value;
    axios.post("http://192.168.51.122:9095/getRole" ,{ "usercode": usercode }).then((response) => {
      console.log(response);
      var data=[response.data];
      this.setState({
       list:data
      });
    });
  }
  render() {
      this.columns=[
        {
          title:'编号',
          dataIndex:'usercode',
          key: 'usercode',
        },
        {
          title:'名字',
          dataIndex:'username',
          key: 'username',
        },
        {
          title:'部门',
          dataIndex:'department',
          key: 'department',
        },
          {
          title:'入职时间',
          dataIndex:'hiredate',
          key: 'hiredate',
        },
        
      ];
      const {usercode}=this.state
      console.log(usercode)

    return (
      <div>
        <Input
          id="usercode" onChange={this.onChange} value={usercode} 
          style={{
            margin: "20px",
            width: "400px"
          }}
        />

        <Button size="large" onClick={this.information.bind(this)}>
          查询
        </Button>
        <Table
         columns = {this.columns}
         dataSource={this.state.list} />
        

        {/* <Input.TextArea
          value={this.state.info}
          style={{
            height: "120px"
          }}
        /> */}




      </div>
    );
  }
}
export default Info;
