import React, { Component } from 'react';
import ListaProdutosComponent from './ListaProdutosComponent'

class LojaApp extends Component {
    render() {
        return (<>
              <h1>E-commerce Application</h1>
              <ListaProdutosComponent/>
            </>
        )
    }
}

export default LojaApp