'use strict'

import { observable, action, computed } from 'mobx'
import { message } from 'antd'
// import { routerOutline } from '../router'
// import Api from '../../api'

export class LoginPageModel {
  PAGE_STATUS = {
    LOGIN: Symbol('login'),
    REGISTER: Symbol('register')
  }

  @observable pageStatus = this.PAGE_STATUS.LOGIN
  @observable loginUsername = ''
  @observable loginPassword = ''
  @observable registerUsername = ''
  @observable registerPassword = ''
  @observable registerPasswordConfirm = ''

  @action.bound listenLoginUsername(value) {
    this.loginUsername = value
  }

  @action.bound listenLoginPassword(value) {
    this.loginPassword = value
  }

  @action.bound listenRegisterUsername(value) {
    this.registerUsername = value
  }

  @action.bound listenRegisterPassword(value) {
    this.registerPassword = value
  }

  @action.bound listenRegisterPasswordConfirm(value) {
    this.registerPasswordConfirm = value
  }

  @computed get isLoginStatus() {
    return this.pageStatus === this.PAGE_STATUS.LOGIN
  }

  @computed get isRegisterStatus() {
    return this.pageStatus === this.PAGE_STATUS.REGISTER
  }

  @action.bound
  switchLogin() {
    this.pageStatus = this.PAGE_STATUS.LOGIN
  }

  @action.bound
  switchRegister() {
    this.pageStatus = this.PAGE_STATUS.REGISTER
  }

  @action.bound
  async login(history) {
    if (!this.loginUsername || !this.loginPassword) {
      message.error('请输入完整用户名或密码')
      return
    }
    // const loginRes = await Api.userLogin(this.loginUsername, this.loginPassword)
    // if (loginRes.code === 200) {
    //   await globalModel.refreshUser()
    //   history.push(routerOutline.LandingPage)
    // } else {
    //   message.error(loginRes.data)
    // }
  }

  @action.bound
  async register(history) {
    if (
      !this.registerUsername ||
      !this.registerPassword ||
      !this.registerPasswordConfirm
    ) {
      message.error('请填写完整注册信息')
      return
    }

    if (this.registerPassword === this.registerPasswordConfirm) {
      // const registerRes = await Api.userRegister(
      //   this.registerUsername,
      //   this.registerPassword
      // )
      // if (registerRes.code === 200) {
      //   await globalModel.refreshUser()
      //   history.push(routerOutline.LandingPage)
      // } else {
      //   message.error(registerRes.data)
      // }
    } else {
      message.error('密码不一致，请确认输入')
    }
  }
}

const loginPageModel = new LoginPageModel()
export default loginPageModel
