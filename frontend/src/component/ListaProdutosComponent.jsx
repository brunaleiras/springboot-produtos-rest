import React, { Component } from 'react';


class ListaProdutosComponent extends Component {

    render() {
        return (
            <div className="container">
                <h3>All Products List</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Alcool em Gel</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListaProdutosComponent