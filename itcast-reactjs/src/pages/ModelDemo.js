import React from "react"
import {connect} from "dva"

let namespaces = "list"
let mapStateToProps = (states) =>{
    let dataList = states[namespaces].dataList
    let maxDate = states[namespaces].maxDate
    return {dataList,maxDate}

}
let mapDispatchToProps = (dispatch)=>{
    return {
        addNum:()=>{
            dispatch({
                type:namespaces + "/addNums"
            })
        },
        initData(){
            dispatch({
                type: namespaces + "/initData"
            })
        }
    }
}

@connect(mapStateToProps,mapDispatchToProps)
class statusDemo extends React.Component {
    componentDidMount() {
        this.props.initData()
    }

    render() {
        return (
            <div>
                <ul>
                    {
                        this.props.dataList.map((v,i)=>{
                            return <li key={i}>{v}</li>
                        })
                    }
                </ul>
               <button onClick={ ()=>{this.props.addNum()} }>添加</button>
            </div>)
    }

}

export default statusDemo
