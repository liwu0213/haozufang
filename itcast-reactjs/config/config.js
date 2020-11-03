export default {
 /*   plugins:[
        ['@umijs/preset-react',{
            dva: true
        }]
    ]*/
    routes: [{
        path: '/',
        component: '../layouts', //配置布局路由
        routes: [
            {
                path: '/MyTabs',
                component: './MyTabs'
            },
            {
                path: '/user',
                routes: [
                    {
                        path: '/user/list',
                        component: './user/UserList'
                    },
                    {
                        path: '/user/add',
                        component: './user/UserAdd'
                    }
                ]
            }
        ]
    }
    ],
    dva: {},
    antd:{}
}
