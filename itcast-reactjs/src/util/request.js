import {fetch} from 'dva'

let checkState = res =>{
    if( res.status >= 200 && res.status < 300 ){
        return res
    }
    const error = new Error(res.statusText)
    error.response = res
    return error
}

export default async function request(url,options) {
    let response = await fetch(url,options)
    response = checkState(response)
    return await response.json()
}
