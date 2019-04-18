/**
 * 此文件存放用户相关接口
 */
import { ppost } from 'utils/requestUtil'
import { IApiRes } from 'declare/CommonInterface'

const userApi = {
  /**
   * 用户登录
   * @param username
   * @param password
   */
  login: (username: string, password: string): Promise<IApiRes<string>> => {
    return ppost(`/user/login`, { username: username, password: password })
  },
  /**
   * 用户注册
   * @param username
   * @param password
   */
  register: (username: string, password: string): Promise<IApiRes<string>> => {
    return ppost(`/user/register`, { username: username, password: password })
  },
  /**
   * 重置密码
   * @param username
   * @param oldPassword
   * @param newPassword
   */
  resetPassword: (
    username: string,
    oldPassword: string,
    newPassword: string
  ): Promise<IApiRes<string>> => {
    return ppost(`/user/reset`, {
      username: username,
      oldPassword: oldPassword,
      newPassword: newPassword
    })
  },
  /**
   * 用户登出
   */
  logout: () => {
    return ppost(`/user/logout`)
  }
}

export default userApi
