'use strict'
import loginPageModel from '../router/LoginPage/LoginPageModel'

const rootStore = {
  loginPageModel
}

const getRootStore = () => {
  return rootStore
}

/**
 * 将数据 model 注入 rootStore
 * @param injectStoreModel
 */
const injectRootStore = injectStoreModel => {
  const key = Object.getOwnPropertyNames(injectStoreModel)[0]
  rootStore[key] = injectStoreModel[key]
}

/**
 * 将已经注入 rootStore 的数据 model 删除
 * @param revokeStoreModel
 */
const revokeRootStore = revokeStoreModel => {
  const key = Object.getOwnPropertyNames(revokeStoreModel)[0]
  if (rootStore[key]) {
    delete rootStore[key]
  }
}

const rootStoreManager = {
  getRootStore,
  injectRootStore,
  revokeRootStore
}

export default rootStoreManager
