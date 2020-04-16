import React, { Component } from 'react'
import { Table, Button } from 'reactstrap';
import ModalForm from '../Modals/Modal'

class DataTable extends Component {

    deleteItem = id => {
        let confirmDelete = window.confirm('Tem certeza que deseja remover esse item?')
        if(confirmDelete){
            fetch('/produto', {
                method: 'delete',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id
                })
            })
                .then(response => response.json())
                .then(item => {
                    this.props.deleteItemFromState(id)
                })
                .catch(err => console.log(err))
        }

    }

    render() {
//{"id":1,"nome":"alcool em gel","quantidade":123.00,"valor":66.00}
        const items = this.props.items.map(item => {
            return (
                <tr key={item.id}>
                <th scope="row">{item.id}</th>
                <td>{item.nome}</td>
                <td>{item.quantidade}</td>
                <td>{item.valor}</td>
                <td>
                <div style={{width:"110px"}}>
        <ModalForm buttonLabel="Editar" item={item} updateState={this.props.updateState}/>
            {' '}
        <Button color="danger" onClick={() => this.deleteItem(item.id)}>Remover</Button>
            </div>
            </td>
            </tr>
        )
        })

        return (
            <Table responsive hover>
        <thead>
        <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Quantidade</th>
        <th>Valor</th>
        <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        {items}
        </tbody>
        </Table>
    )
    }
}

export default DataTable