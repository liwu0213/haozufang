export default {
    'get /ds/list':(req,res)=>{
        res.json({
            dataList: [1, 2, 3,4,6],
            maxDate: 6
        })
    },

    'get /ds/user/list' :(req,res)=>{
        res.json([
            {
                key: '1',
                name: 'liwu',
                age: 32,
                address: 'New York No. 1 Lake Park',
                tags: ['nice', 'developer']
            },
            {
                key: '2',
                name: 'Jim Green',
                age: 42,
                address: 'London No. 1 Lake Park',
                tags: ['loser']
            },
            {
                key: '3',
                name: 'Joe Black',
                age: 32,
                address: 'Sidney No. 1 Lake Park',
                tags: ['cool', 'teacher']
            }
        ])
    }
}
