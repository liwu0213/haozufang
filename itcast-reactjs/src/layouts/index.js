import React from 'react'
import { Layout } from 'antd'
import { Menu, Button } from 'antd';
import {Link} from 'umi'
import {
    AppstoreOutlined,
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    PieChartOutlined,
    DesktopOutlined,
    ContainerOutlined,
    MailOutlined,
} from '@ant-design/icons';

const { SubMenu } = Menu;
const { Header, Footer, Sider, Content } = Layout
class BasicLayout extends React.Component{

    state = {
        collapsed: false,
    };

    toggleCollapsed = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    };

    render(){
        return (
            <Layout>
                <Sider width={256} style={{ minHeight: '100vh', color:'white' }}>

                    <div style={{ width: 256 }}>
                        <Button type="primary" onClick={this.toggleCollapsed} style={{ marginBottom: 16 }}>
                            {React.createElement(this.state.collapsed ? MenuUnfoldOutlined : MenuFoldOutlined)}
                        </Button>
                        <Menu
                            defaultSelectedKeys={['1']}
                            defaultOpenKeys={['sub1']}
                            mode="inline"
                            theme="dark"
                            inlineCollapsed={this.state.collapsed}
                        >
                            <Menu.Item key="1" icon={<PieChartOutlined />}>
                                Option 1
                            </Menu.Item>
                            <Menu.Item key="2" icon={<DesktopOutlined />}>
                                Option 2
                            </Menu.Item>
                            <Menu.Item key="3" icon={<ContainerOutlined />}>
                                Option 3
                            </Menu.Item>
                            <SubMenu key="sub1" icon={<MailOutlined />} title="Navigation One">
                                <Menu.Item key="5">
                                    <Link to={'/user/add'}>添加用户</Link>
                                </Menu.Item>
                                <Menu.Item key="6">Option 6</Menu.Item>
                                <Menu.Item key="7">Option 7</Menu.Item>
                                <Menu.Item key="8">Option 8</Menu.Item>
                            </SubMenu>
                            <SubMenu key="sub2" icon={<AppstoreOutlined />} title="Navigation Two">
                                <Menu.Item key="9">Option 9</Menu.Item>
                                <Menu.Item key="10">Option 10</Menu.Item>
                                <SubMenu key="sub3" title="Submenu">
                                    <Menu.Item key="11">Option 11</Menu.Item>
                                    <Menu.Item key="12">Option 12</Menu.Item>
                                </SubMenu>
                            </SubMenu>
                        </Menu>
                    </div>

                </Sider>
                <Layout>
                    <Header style={{ background: '#fff', textAlign:'center', padding: 0 }}>Header</Header>
                    <Content style={{ margin: '24px 16px 0' }}>
                        <div style={{ padding: 24, background: '#fff',minHeight: 360 }}>
                            {this.props.children}
                        </div>
                    </Content>
                    <Footer style={{ textAlign: 'center' }}>
                        后台系统 ©2018 Created by 黑马程序员</Footer>
                </Layout>
            </Layout>
        )
    }
}
export default BasicLayout
