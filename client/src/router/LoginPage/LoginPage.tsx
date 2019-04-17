import * as React from 'react'
import { inject, observer } from 'mobx-react'
import { Icon, Input, Button, Row, Col } from 'antd'
import { ILoginPageProps } from 'declare/page/LoginPageInterface'
import { LOGIN_PAGE_STATUS } from 'router/LoginPage/LoginPageModel'

import './LoginPage.less'

@inject('loginPageModel')
@observer
export default class LoginPage extends React.Component<ILoginPageProps, any> {
  render() {
    const { loginPageModel, history } = this.props

    const {
      loginUsername,
      loginPassword,
      registerUsername,
      registerPassword,
      registerPasswordConfirm
    } = loginPageModel.status

    return (
      <div className="login-container">
        <Row type="flex" justify="center" align="middle">
          <Col span={8} md={8}>
            {loginPageModel.isLoginStatus && (
              <div className="login-content">
                <Input
                  className="split"
                  prefix={<Icon type="user" />}
                  placeholder="用户名"
                  value={loginUsername}
                  onChange={e => {
                    loginPageModel.setStatus({ loginUsername: e.target.value })
                  }}
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="密码"
                  value={loginPassword}
                  type="password"
                  onChange={e => {
                    loginPageModel.setStatus({ loginPassword: e.target.value })
                  }}
                />
                <div className="split">
                  <Button
                    htmlType="button"
                    type="primary"
                    className="login-form-button"
                    onClick={() => loginPageModel.login(history)}>
                    登录
                  </Button>
                  &nbsp;&nbsp;Or{' '}
                  <span
                    className="switch"
                    onClick={() => {
                      loginPageModel.setStatus({
                        pageStatus: LOGIN_PAGE_STATUS.REGISTER
                      })
                    }}>
                    注册账号
                  </span>
                </div>
              </div>
            )}

            {loginPageModel.isRegisterStatus && (
              <div className="register-content">
                <Input
                  className="split"
                  prefix={<Icon type="user" />}
                  placeholder="用户名"
                  value={registerUsername}
                  onChange={e => {
                    loginPageModel.setStatus({
                      registerUsername: e.target.value
                    })
                  }}
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="密码"
                  type="password"
                  value={registerPassword}
                  onChange={e => {
                    loginPageModel.setStatus({
                      registerPassword: e.target.value
                    })
                  }}
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="确认密码"
                  type="password"
                  value={registerPasswordConfirm}
                  onChange={e => {
                    loginPageModel.setStatus({
                      registerPasswordConfirm: e.target.value
                    })
                  }}
                />
                <div className="split">
                  <Button
                    htmlType="button"
                    type="primary"
                    className="register-form-button"
                    onClick={() => loginPageModel.register(history)}>
                    注册
                  </Button>
                  &nbsp;&nbsp;Or{' '}
                  <span
                    className="switch"
                    onClick={() => {
                      loginPageModel.setStatus({
                        pageStatus: LOGIN_PAGE_STATUS.LOGIN
                      })
                    }}>
                    直接登录
                  </span>
                </div>
              </div>
            )}
          </Col>
        </Row>
      </div>
    )
  }
}
