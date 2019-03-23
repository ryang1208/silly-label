'use strict'

import * as React from 'react'
import { Menu, Icon } from 'antd'
import { Link } from 'react-router-dom'
import { routerOutline } from '../../router/router'

const SubMenu = Menu.SubMenu

/**
 * 此文件配置项目作业菜单栏
 */
export default class SideMenu extends React.Component {
  constructor(props) {
    super(props)
    this.state = {}
  }

  render() {
    return (
      <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
        <Menu.Item key="1">
          <Link to={'/'}>
            <Icon type="pie-chart" />
            <span>首页</span>
          </Link>
        </Menu.Item>
        <SubMenu
          key="sub1"
          title={
            <span>
              <Icon type="rocket" theme="filled" />
              <span>子菜单</span>
            </span>
          }
        >
          <Menu.Item key="2">
            <Link to={routerOutline.HelloPage}>HelloPage</Link>
          </Menu.Item>
        </SubMenu>
      </Menu>
    )
  }
}
