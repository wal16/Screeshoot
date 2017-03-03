import React from 'react'
import {Grid, Row, Col, Thumbnail} from 'react-bootstrap'
import {Tabs, Tab} from 'react-bootstrap-tabs';

import data from '../../data'

const UserProfileView = (props) => {

  const currentUser = data.users.filter(
    user => user.id === parseInt(props.params.id, 10)
  )

  const currentUserGameList = data.users.find(
    user => user.id === parseInt(props.params.id, 10)
  )

  return (
    <Grid>
      <h1>Profil Użytkownika</h1>
      <Row>
        <Col xs={12} sm={4} md={4}>
          <Thumbnail className="user--avatar" src={process.env.PUBLIC_URL + '/img/board-games-with-roles.svg'}
                     alt="Avatar użytkownika">
          </Thumbnail>
        </Col>

        <Col xs={12} sm={8} md={8}>
          {
            currentUser.map(
              user => (
                <div>
                  <h3 key={user.id}>{user.name} {user.surname}</h3>
                  <p>{user.about}</p>
                </div>
              )
            )
          }
        </Col>
      </Row>
      <Row>
        <Col xs={12} md={12}>
        <Tabs onSelect={(index, label) => console.log(label + ' selected')}>
          <Tab label="Posiadam">
              <h3>Posiadam</h3>
              <ul>
                {
                  currentUserGameList.gameList.map(
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
                  currentUserGameList.wishList.map(
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