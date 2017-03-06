import React from 'react'
import {Grid, Row, Col} from 'react-bootstrap'
import {Tabs, Tab} from 'react-bootstrap-tabs';

import data from '../../data'

const UserProfileView = (props) => {

  const currentUser = data.users.find(
    user => user.id === parseInt(props.params.id, 10)
  )

  return (
    <Grid>
      <h1>Profil Użytkownika</h1>
      <Row>
        <Col xs={12} sm={4} md={4}>
          <div key={currentUser.id}>
            <img src={process.env.PUBLIC_URL + currentUser.picture}/>
          </div>
        </Col>

        <Col xs={12} sm={8} md={8}>
          <div key={currentUser.id}>
            <h3>{currentUser.name} {currentUser.surname}</h3>
            <p>{currentUser.about}</p>
          </div>
        </Col>
      </Row>
      <Row>
        <Col xs={12} md={12}>
          <Tabs onSelect={(index, label) => console.log(label + ' selected')}>
            <Tab label="Posiadam">
              <h3>Posiadam</h3>
              <ul>
                {
                  currentUser.gameList.map(
                    game => (
                      <li key={game.id}>{game.name}</li>
                    )
                  )
                }
              </ul>
            </Tab>
            <Tab label="Szukam">
              <h3>Szukam</h3>
              <ul>
                {
                  currentUser.wishList.map(
                    game => (
                      <li key={game.id}>{game.name}</li>
                    )
                  )
                }
              </ul>
            </Tab>
          </Tabs>
        </Col>
      </Row>
    </Grid>
  )
}
export default UserProfileView