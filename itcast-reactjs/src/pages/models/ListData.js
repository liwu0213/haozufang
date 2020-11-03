import request from "../../util/request";
export default {
    namespace:"list",
    state:{
        dataList: [],
        maxDate: 0
    },

    reducers:{
        addNums(oldState,result) {
            if (result.data){
                return result.data
            }
            let maxData = oldState.maxDate + 1
            let data = [...oldState.dataList,maxData]
            return {
                dataList: data,
                maxDate: maxData
            }
        }
    },

    effects:{
        *initData(params,sagaEffects){
            console.info("----*initData")
            const {call,put} = sagaEffects
            let data = yield call(request,'/ds/list')
            console.info("---------initdata--",JSON.stringify(data))
            yield put({
                type:"addNums",
                data:data
            })
        }
    }
}
