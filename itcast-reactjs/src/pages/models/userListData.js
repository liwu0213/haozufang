import request from "../../util/request"

export default {
    namespace:"userList",
    state:{
        dataList: []
    },

    reducers:{
        userListData(oldState,result) {
            return {
                dataList: result.data,
            }
        }
    },

    effects:{
        *initData(params,sagaEffects){
            console.info("----*initData")
            const {call,put} = sagaEffects
            let data = yield call(request,'/ds/user/list')
            console.info("---------initdata--",JSON.stringify(data))
            yield put({
                type:"userListData",
                data:data
            })
        }
    }
}
