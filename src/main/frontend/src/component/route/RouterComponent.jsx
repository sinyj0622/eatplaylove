import React from 'react';
import { BrowserRouter, Route, Switch} from 'react-router-dom';
import UserListComponent from "../user/UserListComponent";
import AddUserComponent from "../user/AddUserComponent";
import EditUserComponent from "../user/EditUserComponent";
import SignIn from "../login/SignIn";
import SignUp from "../login/SignUp";

const AppRouter = () => {
   return(
     <div style={style}>
       <BrowserRouter>
          <Switch>
            <Route exact path="/" component={UserListComponent} />
            <Route path="/signin" component={SignIn} />
            <Route path="/signup" component={SignUp} />
            <Route path="/edit-user" component={EditUserComponent} />
            <Route path="/add-user" component={AddUserComponent} />
            <Route path="/users" component={UserListComponent} />
          </Switch>
       </BrowserRouter>
     </div>
   );
}

const style = {
  marginTop: '20px'
}

export default AppRouter;