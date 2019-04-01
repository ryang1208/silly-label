import * as React from 'react'
import NoPermission from 'components/NoPermission/NoPermission'
// import globalModel from 'stores/GlobalModel'

// 权限说明
export type Permission = () => Promise<void>

const promiseAny = promises => {
  let rejectCount = 0
  let firstRejectRes
  return new Promise((outerResolve, outerReject) => {
    promises.forEach(promise => {
      promise.then(
        res => {
          outerResolve(res)
        },
        res => {
          if (rejectCount === 0) {
            firstRejectRes = res
          }
          rejectCount++
          if (rejectCount === promises.length) {
            outerReject(firstRejectRes)
          }
        }
      )
    })
  })
}

// 校验添加的权限，拥有任意一个权限即可
const validate = (permissions: Permission[]) => {
  return promiseAny(
    permissions.map(permission => {
      return permission()
    })
  )
}

export const PermissionRequired = {
  // passerRequired: () => {
  //   // 1	passer：默认用户，注册之后就有
  //   return PermissionCheck.isPasser() ? Promise.resolve() : Promise.reject()
  // },
  // marketRequired: () => {
  //   // 2	market：可以反馈数据，查看反馈记录
  //   return PermissionCheck.isMarket() ? Promise.resolve() : Promise.reject()
  // },
  // marketLeaderRequired: () => {
  //   // 3	marketLeader：仅可添加 market 权限
  //   return PermissionCheck.isMarketLeader()
  //     ? Promise.resolve()
  //     : Promise.reject()
  // },
  // devRequired: () => {
  //   // 4	dev：拥有 market 权限及部分特殊权限
  //   return PermissionCheck.isDev() ? Promise.resolve() : Promise.reject()
  // },
  // devLeaderRequired: () => {
  //   // 5	devLeader：仅可添加 dev 权限
  //   return PermissionCheck.isDevLeader() ? Promise.resolve() : Promise.reject()
  // },
  // adminRequired: () => {
  //   // 6	admin：仅可添加所有人员权限
  //   return PermissionCheck.isAdmin() ? Promise.resolve() : Promise.reject()
  // }
}

export const PermissionCheck = {
  // isPasser: () => {
  //   return globalModel.userRoles.indexOf('default') > -1
  // },
  // isMarket: () => {
  //   return globalModel.userRoles.indexOf('market') > -1
  // },
  // isMarketLeader: () => {
  //   return globalModel.userRoles.indexOf('marketLeader') > -1
  // },
  // isDev: () => {
  //   return globalModel.userRoles.indexOf('dev') > -1
  // },
  // isDevLeader: () => {
  //   return globalModel.userRoles.indexOf('devLeader') > -1
  // },
  // isAdmin: () => {
  //   return globalModel.userRoles.indexOf('admin') > -1
  // }
}

const ComponentStatus = {
  PENDING: 'pending',
  FULLFILLED: 'fullfilled',
  REJECTED: 'rejected'
}

export default function registerPermission(...permissions: Permission[]) {
  return function decorate(Component: any) {
    return class PermissionWrapper extends React.Component<any, any> {
      constructor(props) {
        super(props)
        this.state = {
          status: ComponentStatus.PENDING
        }
      }

      componentDidMount(): void {
        validate(permissions).then(
          resolveRes => {
            this.setState({ status: ComponentStatus.FULLFILLED })
          },
          rejectRes => {
            this.setState({ status: ComponentStatus.REJECTED })
          }
        )
      }

      render() {
        const { status } = this.state
        return (
          <React.Fragment>
            {status === ComponentStatus.PENDING && (
              <div id="loading">loading</div>
            )}
            {status === ComponentStatus.FULLFILLED && (
              <Component {...this.props} />
            )}
            {status === ComponentStatus.REJECTED && <NoPermission />}
          </React.Fragment>
        )
      }
    }
  }
}
