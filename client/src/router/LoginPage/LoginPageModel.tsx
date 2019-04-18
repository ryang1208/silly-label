import { observable, action, computed } from 'mobx'
import { message } from 'antd'
import { routerOutline } from 'router/router'
import BasicModel from 'stores/BasicModel'

import Api from 'api'

export const LOGIN_PAGE_STATUS = {
  LOGIN: Symbol('login'),
  REGISTER: Symbol('register')
}

class LoginPageStatus {
  @observable pageStatus = LOGIN_PAGE_STATUS.LOGIN
  @observable loginUsername = ''
  @observable loginPassword = ''
  @observable registerUsername = ''
  @observable registerPassword = ''
  @observable registerPasswordConfirm = ''
}

export class LoginPageModel extends BasicModel<LoginPageStatus> {
  @observable status = new LoginPageStatus()

  @computed get isLoginStatus() {
    return this.status.pageStatus === LOGIN_PAGE_STATUS.LOGIN
  }

  @computed get isRegisterStatus() {
    return this.status.pageStatus === LOGIN_PAGE_STATUS.REGISTER
  }

  @action
  async login(history) {
    if (!this.status.loginUsername || !this.status.loginPassword) {
      message.error('请输入完整用户名或密码')
      return
    }
    const loginRes = await Api.user.login(
      this.status.loginUsername,
      this.status.loginPassword
    )
    if (loginRes.code === 200) {
      history.push(routerOutline.HelloPage)
    } else {
      message.error(loginRes.data)
    }
  }

  @action
  async register(history) {
    if (
      !this.status.registerUsername ||
      !this.status.registerPassword ||
      !this.status.registerPasswordConfirm
    ) {
      message.error('请填写完整注册信息')
      return
    }

    if (this.status.registerPassword === this.status.registerPasswordConfirm) {
      const registerRes = await Api.user.register(
        this.status.registerUsername,
        this.status.registerPassword
      )
      if (registerRes.code === 200) {
        history.push(routerOutline.HelloPage)
      } else {
        message.error(registerRes.data)
      }
    } else {
      message.error('密码不一致，请确认输入')
    }
  }
}

const loginPageModel = new LoginPageModel()
export default loginPageModel
