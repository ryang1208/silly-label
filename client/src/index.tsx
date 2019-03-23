import './external'

import * as React from 'react'
import * as ReactDOM from 'react-dom'
import { Provider } from 'mobx-react'
import rootStore from './stores/rootStore'
import router from './router/router'

import './styles/global.less'

ReactDOM.render(
  <Provider {...rootStore}>{router}</Provider>,
  document.querySelector('#main-view-wrapper')
)
