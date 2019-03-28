import * as React from 'react'
import { Menu, Icon } from 'antd'
import { Link } from 'react-router-dom'

const SubMenu = Menu.SubMenu

export default class BasicSideMenu extends React.Component {
  renderDatasetMenu() {
    return (
      <SubMenu
        key="dataset"
        title={
          <span>
            <Icon type="rocket" theme="filled"/>
            <span>数据集</span>
          </span>
        }
      >
        <Menu.Item key="dataset-create">
          <Link to={'/'}>创建数据集</Link>
        </Menu.Item>
        <Menu.Item key="dataset-list">
          <Link to={'/'}>数据集列表</Link>
        </Menu.Item>
      </SubMenu>
    )
  }

  renderTaskMenu() {
    return (
      <Menu.Item key="task">
        <Link to={'/'}>
          <Icon type="align-left"/>
          <span>任务</span>
        </Link>
      </Menu.Item>
    )
  }

  renderSettingMenu() {
    return (
      <Menu.Item key="setting">
        <Link to={'/'}>
          <Icon type="setting"/>
          <span>个人中心</span>
        </Link>
      </Menu.Item>
    )
  }

  render() {
    return (
      <Menu
        theme="dark"
        mode="inline"
        defaultSelectedKeys={['dashboard']}
        defaultOpenKeys={['dataset']}
      >
        <Menu.Item key="dashboard">
          <Link to={'/'}>
            <Icon type="pie-chart"/>
            <span>Dashboard</span>
          </Link>
        </Menu.Item>
        {this.renderDatasetMenu()}
        {this.renderTaskMenu()}
        {this.renderSettingMenu()}
      </Menu>
    )
  }
}
