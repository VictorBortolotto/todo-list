import './App.css';

import { BrowserRouter, Link, Routes, Route } from 'react-router-dom';
import { Button, Icon, List, ListItem, ListItemIcon, ListItemText } from '@material-ui/core';
import { useState } from 'react';
import { ListaTarefa } from './ListaTarefa';

function App() {

  const [showMenu, setShowMenu] = useState(false);

  return (
    <>
    <BrowserRouter>
      <div id="navbar" className={'nav-div'}>

        <Button className={'nav-menu-item'} onClick={() => setShowMenu(!showMenu)}>
          <Icon className={'nav-menu-item-icon'}>menu</Icon>
        </Button>

      </div>

      <div className={'sidebar-main-div'}>
        {showMenu && <div id="sidebar" className={'sidebar-left-div'}>

          <List component="nav">
            <ListItem button={true} component={Link} {...{to: "/tarefa/pendente"}}>
              <ListItemIcon><Icon>list</Icon></ListItemIcon>
              <ListItemText primary="Pendente"></ListItemText>
            </ListItem>
            <ListItem button={true} component={Link} {...{to: "/tarefa/feito"}}>
              <ListItemIcon><Icon>checked</Icon></ListItemIcon>
              <ListItemText primary="Feito"></ListItemText>
            </ListItem>
          </List>

        </div>}

        <div className={'sidebar-body-div'}>
          <div className="sidebar-body-div-outlet">
            <Routes>
              <Route path="/pendente" exact={true} component={() => ListaTarefa({status: false})}/>
              <Route path="/feito" exact={true} component={() => ListaTarefa({status: true})}/>
            </Routes>
          </div>
        </div>
      </div>
    </BrowserRouter>
    </>
  );
}

export default App;
