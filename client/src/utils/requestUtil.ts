import axios from 'axios'
import { message as antdMessage } from 'antd'

const axiosInstance = axios.create({
  baseURL: '/',
  timeout: 2000
})

/**
 * get 请求
 * @param url 请求资源地址
 * @param params 请求参数
 */
export function pget(url, params = {}) {
  try {
    return axiosInstance
      .get(url, {
        params,
        validateStatus: status => {
          return (status >= 200 && status < 300) || status === 700
        }
      })
      .then(response => {
        const code = response.data.code
        const message = response.data.msg
        if (code > 220 || code < 200) {
          antdMessage.warn(message)
        }
        return response.data
      })
      .catch(error => {
        throw error
      })
  } catch (err) {
    console.error(err.type)
    console.error(err.message)
  }
}

/**
 * post 请求
 * @param url 请求资源地址
 * @param params 请求参数
 */
export function ppost(url, params = {}) {
  try {
    return axios
      .post(url, params)
      .then(response => {
        const code = response.data.code
        const message = response.data.msg
        if (code > 220 || code < 200) {
          antdMessage.warn(message)
        }
        return response.data
      })
      .catch(error => {
        throw error
      })
  } catch (err) {
    console.error(err.type)
    console.error(err.message)
  }
}

/**
 * 多个请求并发
 * @param requests
 */
export function asyncAll(requests = []) {
  try {
    return axios
      .all(requests)
      .then(resultArr => {
        return resultArr
      })
      .catch(error => {
        throw error
      })
  } catch (err) {
    console.error(err.type)
    console.error(err.message)
  }
}
