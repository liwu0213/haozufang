import React from "react"

class statusDemo extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            dataList: [1, 2, 3],
            maxDate: 3
        }
    }

    render() {
        return (
            <div>
                <ul>
                    {
                        this.state.dataList.map((v,i)=>{
                            return <li key={i}>{v}</li>
                        })
                    }
                </ul>
                <button onClick={ ()=>{
                    let newMaxDate  = this.state.maxDate + 1
                    this.setState({
                        dataList:[...this.state.dataList,newMaxDate],
                        maxDate:newMaxDate
                    })
                }}>添加</button>
            </div>)
    }

}

export default statusDemo
