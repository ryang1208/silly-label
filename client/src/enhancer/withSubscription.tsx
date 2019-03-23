'use strict'

import * as React from 'react'

/**
 * 便于 Router 的配置聚合，抽出的方法
 * @param WrappedComponent
 * @param children
 */
export function withSubscription(
  WrappedComponent,
  children
): React.ComponentType<any> {
  class WithSubscription extends React.Component<any, any> {
    render() {
      return <WrappedComponent>{children}</WrappedComponent>
    }
  }

  return WithSubscription
}
