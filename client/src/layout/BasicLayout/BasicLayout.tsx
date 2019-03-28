import * as React from 'react'
import { Layout } from 'antd'
import { IBasicLayoutState } from 'declare/LayoutInterface'

import BasicSideMenu from '../BasicSideMenu/BasicSideMenu'
import BasicHeader from '../BasicHeader/BasicHeader'

const { Content, Sider } = Layout

export default class BasicLayout extends React.Component<
  any,
  IBasicLayoutState
> {
  constructor(props) {
    super(props)
    this.state = {
      collapsed: true
    }
  }

  onCollapse() {
    this.setState({
      collapsed: !this.state.collapsed
    })
  }

  render() {
    return (
      <Layout style={{ minHeight: '100vh' }}>
        <Sider
          collapsible
          collapsed={this.state.collapsed}
          onCollapse={() => this.onCollapse()}>
          <BasicSideMenu />
        </Sider>
        <Layout>
          <BasicHeader />
          <Content>{this.props.children}</Content>
        </Layout>
      </Layout>
    )
  }
}
