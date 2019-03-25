import * as React from 'react'

// 权限说明
export type Permission = () => Promise<void>

// 校验添加的所有的权限
const validate = (permissions: Permission[]) => {
  return Promise.all(
    permissions.map(permission => {
      return permission()
    })
  )
}

const ComponentStatus = {
  PENDING: Symbol('pending'),
  FULLFILLED: Symbol('fullfilled'),
  REJECTED: Symbol('rejected')
}

export default function registerPermission(...permissions: Permission[]) {
  return function decorate(Component: any) {
    return class PermissionWrapper extends React.Component<any, any> {
      constructor(props) {
        super(props)
        this.state = {
          stauts: ComponentStatus.PENDING
        }
      }

      componentDidMount(): void {
        validate(permissions).then(
          // fullfilled
          () => {
            this.setState({ status: ComponentStatus.FULLFILLED })
          },
          // rejected
          () => {
            this.setState({ status: ComponentStatus.REJECTED })
          }
        )
      }

      render() {
        const { status } = this.state

        if (status === ComponentStatus.PENDING) {
          return <div id="loading" />
        }

        if (status === ComponentStatus.FULLFILLED) {
          return <Component {...this.props} />
        }

        if (status === ComponentStatus.REJECTED) {
          return <div id="no-permission" />
        }
      }
    }
  }
}
