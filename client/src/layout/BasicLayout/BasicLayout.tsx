'use strict'

import * as React from 'react'
import { Layout } from 'antd'
import SideMenu from '../SideMenu/SideMenu'

const { Header, Content, Sider } = Layout

export default class BasicLayout extends React.Component<
  {},
  {
    collapsed: boolean
  }
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
          onCollapse={() => this.onCollapse()}
        >
          <SideMenu />
        </Sider>
        <Layout>
          <Header style={{ background: '#fff', padding: 0 }} />
          <Content style={{ margin: '0.2rem', background: '#fff' }}>
            {this.props.children}
          </Content>
        </Layout>
      </Layout>
    )
  }
}
