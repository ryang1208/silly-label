'use strict'

import * as React from 'react'
import { BrowserRouter, Route } from 'react-router-dom'
import { withSubscription } from 'enhancer/withSubscription'

import BasicLayout from 'layout/BasicLayout/BasicLayout'

import HelloPage from './HelloPage/HelloPage'

const routerPrefix = ''

export const routerOutline = {
  HelloPage: `${routerPrefix}/hello`
}

const router = (
  <BrowserRouter>
    <div>
      <Route
        path={`${routerPrefix}`}
        component={withSubscription(
          BasicLayout,
          <React.Fragment>
            <Route
              strict
              path={routerOutline.HelloPage}
              component={HelloPage}
            />
          </React.Fragment>
        )}
      />
    </div>
  </BrowserRouter>
)

export default router
