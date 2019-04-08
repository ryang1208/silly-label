import * as React from 'react'
import { inject, observer } from 'mobx-react'
import { Icon, Input, Button, Row, Col } from 'antd'
import { ILoginPageProps } from 'declare/page/LoginPageInterface'

import './LoginPage.less'

@inject('loginPageModel')
@observer
export default class LoginPage extends React.Component<ILoginPageProps, any> {
  render() {
    const { loginPageModel, history } = this.props

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
                  value={loginPageModel.loginUsername}
                  onChange={e =>
                    loginPageModel.listenLoginUsername(e.target.value)
                  }
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="密码"
                  value={loginPageModel.loginPassword}
                  type="password"
                  onChange={e =>
                    loginPageModel.listenLoginPassword(e.target.value)
                  }
                />
                <div className="split">
                  {
                    // @ts-ignore
                    <Button
                      htmlType="button"
                      type="primary"
                      className="login-form-button"
                      onClick={() => loginPageModel.login(history)}>
                      登录
                    </Button>
                  }
                  &nbsp;&nbsp;Or{' '}
                  <span
                    className="switch"
                    onClick={() => loginPageModel.switchRegister()}>
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
                  value={loginPageModel.registerUsername}
                  onChange={e =>
                    loginPageModel.listenRegisterUsername(e.target.value)
                  }
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="密码"
                  type="password"
                  value={loginPageModel.registerPassword}
                  onChange={e =>
                    loginPageModel.listenRegisterPassword(e.target.value)
                  }
                />
                <Input
                  className="split"
                  prefix={<Icon type="lock" />}
                  placeholder="确认密码"
                  type="password"
                  value={loginPageModel.registerPasswordConfirm}
                  onChange={e =>
                    loginPageModel.listenRegisterPasswordConfirm(e.target.value)
                  }
                />
                <div className="split">
                  {
                    // @ts-ignore
                    <Button
                      htmlType="button"
                      type="primary"
                      className="register-form-button"
                      onClick={() => loginPageModel.register(history)}>
                      注册
                    </Button>
                  }
                  &nbsp;&nbsp;Or{' '}
                  <span
                    className="switch"
                    onClick={() => loginPageModel.switchLogin()}>
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
