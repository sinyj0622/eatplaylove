import React, { Component } from 'react';
// import ApiService from "../../ApiService";

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

class AddUserComponent extends Component{

  constructor(props){
    super(props);

    this.state = {
      username: '',
      password: '',
    }

  }

  onChange = (e) => {
    this.setState({
      [e.target.name] : e.target.value
    })
  }

  saveUser = (e) => {
    e.preventDefault();

//     let user = {
//       username: this.state.username,
//       password: this.state.password,
//     }

//     ApiService.addUser(user)
//     .then( res => {
//         this.setState({
//           message: user.username + '님이 성공적으로 등록되었습니다.'
//         })
//         console.log(this.state.message);
//         this.props.history.push('/users');
//     })
//     .catch( err => {
//       console.log('saveUser() 에러', err);
//     });

  }

  render(){
    return(
      <div>
        <Typography variant="h4" style={style}>Add User</Typography>
        <form style={formContainer}>

            <TextField type="text" placeholder="please input your username" name="username"
fullWidth margin="normal" value={this.state.username} onChange={this.onChange} />

            <TextField type="password" placeholder="please input your password" name="password"
fullWidth margin="normal" value={this.state.password} onChange={this.onChange} />

          <Button variant="contained" color="primary" onClick={this.saveUser}>Save</Button>

        </form>
      </div>
    );
  }
}

const formContainer = {
  display: 'flex',
  flexFlow: 'row wrap'
}

const style = {
  display: 'flex',
  justifyContent: 'center'
}

export default AddUserComponent;