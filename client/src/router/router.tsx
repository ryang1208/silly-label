import * as React from 'react'
import { BrowserRouter, Route } from 'react-router-dom'
import { withSubscription } from 'enhancer/withSubscription'
import BasicLayout from 'layout/BasicLayout/BasicLayout'
import loadable from '@loadable/component'

const LoginPage = loadable(() => import('./LoginPage/LoginPage'))
const HelloPage = loadable(() => import('./HelloPage/HelloPage'))

const routerPrefix = '/label'

export const routerOutline = {
  LoginPage: `${routerPrefix}/login`,
  HelloPage: `${routerPrefix}/panel/hello`
}

const router = (
  <BrowserRouter>
    <div>
      <Route strict path={routerOutline.LoginPage} component={LoginPage} />
      <Route
        path={`${routerPrefix}/panel`}
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
