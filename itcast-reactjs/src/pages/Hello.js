import React from 'react'

class Hellow extends React.Component {

    render() {
        return <div> hello,{this.props.name},{this.props.children} 欢迎你 </div>
    }
}

export default Hellow
